/*
 * Author Name: Jaival
 * Date: 20-12-2022
 * Createdd with IntelliJ IDEA Community Editiion
 */
package com.niit.UserAuthentication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "User already exist with this ID!! Please enter different username")
public class UserAlreadyExist extends Exception {
}
