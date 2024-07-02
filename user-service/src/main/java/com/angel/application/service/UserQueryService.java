package com.angel.application.service;

import com.angel.application.query.GetUserByEmailAndPasswordQuery;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserQueryService {

	public final GetUserByEmailAndPasswordQuery getUserByEmailAndPasswordQuery;
}
