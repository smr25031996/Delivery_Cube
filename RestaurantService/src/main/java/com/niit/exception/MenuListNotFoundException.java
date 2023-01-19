package com.niit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "MenuList Not Found!!")

public class MenuListNotFoundException extends Exception {
}
