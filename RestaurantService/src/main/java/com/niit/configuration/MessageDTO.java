/*
 *Author Name :P.Hemanth Sai Teja
 *Date:10-01-2023
 *Created With: IntelliJ IDEA Community Edition
 */

package com.niit.configuration;

import com.niit.domain.Restaurant;

public class MessageDTO {
    private String email;


    public MessageDTO() {
    }

    public MessageDTO(String email) {
        this.email = email;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "MessageDTO{" +
                "email='" + email + '\'' +
                '}';
    }
}
