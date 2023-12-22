package com.user.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.auth.ApiCodeResponses;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
public class UserController {
	@ApiCodeResponses
	@Operation(description = "get API response.")
	@ApiResponse(responseCode = "200", description = "OK", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = String.class)) })

	@GetMapping( value = "/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

}