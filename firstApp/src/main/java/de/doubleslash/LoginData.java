package de.doubleslash;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginData {

	
	@NotNull(message = "Please enter your email")
	private String email;
	
	@NotNull(message = "Please enter a password")
	@Size(min = 6, max = 32, message = "Your password must be at least 6 characters long.")
	private String password;
	
	@NotNull(message = "Please enter a password")
	@Size(min = 6, max = 32, message = "Your password must be at least 6 characters long.")
	private String retype;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRetype() {
		return retype;
	}
	public void setRetype(String retype) {
		this.retype = retype;
	}
	
	
	

}
