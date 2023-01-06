/*
 * Author Name: Jaival
 * Date: 13-12-2022
 * Createdd with IntelliJ IDEA Community Editiion
 */
package com.niit.UserAuthentication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "User Not Found")
public class UserNotFoundException extends Exception {
}
