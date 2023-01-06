/*
 * Author Name: Jaival
 * Date: 06-01-2023
 * Createdd with IntelliJ IDEA Community Editiion
 */
package com.niit.UserAuthentication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Admin Not Found")
public class AdminNotFoundException extends Exception {
}
