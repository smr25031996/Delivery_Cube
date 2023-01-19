package com.niit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "user Registered already ")

public class UserAlreadyExistsException extends Exception {
}
