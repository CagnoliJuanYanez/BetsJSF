package modelo.bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class LoginBean {
	private String username;
	private String password;

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

	public String logIn() {
		if (username.equals("pirata")) {
			FacesContext.getCurrentInstance().addMessage(null,
					 new FacesMessage("Error: La longitud del nombre y de la contraseņa son diferentes.")); 
			return null;
		} else {
			return "ok";
		}
	}

}