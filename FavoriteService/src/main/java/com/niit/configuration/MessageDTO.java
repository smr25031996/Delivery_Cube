package com.niit.configuration;

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
