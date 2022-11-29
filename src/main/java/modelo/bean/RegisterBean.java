package modelo.bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class RegisterBean {
	private String username;
	private String password;
	private String confirmPassword;

	public String getUsername() {
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
	}

	public String register() {
		if (!password.equals(confirmPassword)) {
			FacesContext.getCurrentInstance().addMessage(null,
					 new FacesMessage("Error: Passwords are not the same.")); 
			return null;
		} else {
			return "ok";
		}
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
