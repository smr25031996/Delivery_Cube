package com.niit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Restaurant not  exist with this ID!!")

public class RestaurantNotFoundException extends Exception {
}
