package com.angel.presentation.api;

import com.angel.application.dto.command.CreateUserCommandDTO;
import com.angel.application.dto.query.AuthUserQueryDTO;
import com.angel.application.dto.query.UserQueryDTO;
import com.angel.application.dto.request.UserDTO;
import com.angel.application.dto.request.UserRoleDTO;
import com.angel.application.dto.response.CreatedUserDTO;
import com.angel.application.service.UserCommandService;
import com.angel.application.service.UserQueryService;
import com.angel.domain.user.entity.User;
import com.angel.domain.user.vo.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600, methods = {RequestMethod.DELETE , RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.OPTIONS})
public class UserController {

	private final UserQueryService userQueryService;
	private final UserCommandService userCommandService;


	@PostMapping("/get")
	public ResponseEntity<AuthUserQueryDTO> getByEmailAndPassword(@RequestBody UserDTO userDTO) {
		UserQueryDTO userQueryDTO = userQueryService.getUserByEmailAndPasswordQuery.handle(userDTO.email, userDTO.password);
		return ResponseEntity
				.status(200)
				.body(new AuthUserQueryDTO(userQueryDTO.userID, userQueryDTO.roles));
	}

	@PostMapping()
	public ResponseEntity<CreatedUserDTO> create(@RequestBody CreateUserCommandDTO createUserCommandDTO){
		User createdUser = userCommandService.createUserCommand.handle(createUserCommandDTO);
		return ResponseEntity.status(201)
				.body(new CreatedUserDTO(createdUser.getID(), createdUser.getRoles().stream().map(Role::getRoleType).toList()));

	}

	@PutMapping("/addRole")
	public ResponseEntity<String> addRole(@RequestBody UserRoleDTO userRoleDTO){
		return ResponseEntity.status(200)
				.body(null);
	}

 @GetMapping("/hi")
	public String hi(){
		return "hi";
 }


}
