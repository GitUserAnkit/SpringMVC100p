package com.ankit.command;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserCommand {
    private String username;
    private String password;
    //setter and getter
	/*public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}*/
}
