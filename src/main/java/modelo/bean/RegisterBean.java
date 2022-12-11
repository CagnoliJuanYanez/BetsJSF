package modelo.bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import dataAccess.DataAccessHibernate;
import domain.User;
import exceptions.UsernameAlreadyExists;

public class RegisterBean {
	private String username;
	private String password;
	private String confirmPassword;
	private BLFacade blFacade;

	public RegisterBean() {
		blFacade = new BLFacadeImplementation(new DataAccessHibernate());
	}

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
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error: Passwords are not the same."));
			return null;
		}
		
		if (!(password.length() > 3)) {
			FacesContext.getCurrentInstance().addMessage(null,
					 new FacesMessage("Error: Password must be at least 4 chars long.")); 
			return null;
		} 
		
		if (!(username.length() > 3)) {
			FacesContext.getCurrentInstance().addMessage(null,
					 new FacesMessage("Error: Username must be at least 4 chars long.")); 
			return null;
		} 
		
		try {
			blFacade.registerUser(username, password);
			return "ok";
		} catch (UsernameAlreadyExists e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error: Username is taken."));
		}

		return null;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
