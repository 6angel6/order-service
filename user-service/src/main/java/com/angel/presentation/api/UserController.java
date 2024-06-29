package com.angel.presentation.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/healh")
public class UserController {

	@GetMapping
	public String health(){
		return "Hello";
	}
}
