package com.angel.presentation.config;

import com.angel.application.command.CreateUserCommand;
import com.angel.application.interfaces.persistence.RoleReader;
import com.angel.application.interfaces.persistence.UserDao;
import com.angel.application.interfaces.persistence.UserReader;
import com.angel.application.interfaces.security.PasswordEncoder;
import com.angel.application.query.GetUserByEmailAndPasswordQuery;
import com.angel.application.service.UserCommandService;
import com.angel.application.service.UserQueryService;
import com.angel.domain.user.service.UserService;
import com.angel.infrastructure.db.impl.RoleDAOimpl;
import com.angel.infrastructure.db.impl.UserDAOimpl;
import com.angel.infrastructure.db.orm.RoleORM;
import com.angel.infrastructure.db.orm.UserORM;
import com.angel.infrastructure.security.PasswordEncoderImpl;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

	@Bean("myObjectMapper")
	public ObjectMapper myObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return objectMapper;
	}

	@Bean
	public UserReader userReader(UserORM userORM) {
		return new UserDAOimpl(userORM);
	}

	@Bean
	public UserDao userDAO(UserORM userORM) {
		return new UserDAOimpl(userORM);
	}

	@Bean
	public RoleReader roleReader(RoleORM roleORM) {
		return new RoleDAOimpl(roleORM);
	}

	@Bean
	public UserQueryService userQueryService(UserReader userReader, PasswordEncoder passwordEncoder) {
		return new UserQueryService(
				new GetUserByEmailAndPasswordQuery(userReader, passwordEncoder)
		);
	}

	@Bean
	public UserCommandService userCommandService(UserDao userDAO, RoleReader roleReader) {
		return new UserCommandService(
				new CreateUserCommand(new UserService(), userDAO, roleReader)
		);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new PasswordEncoderImpl();
	}
}
