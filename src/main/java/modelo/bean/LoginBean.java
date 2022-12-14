package modelo.bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import dataAccess.DataAccessHibernate;
import domain.User;
import exceptions.InvalidCredentials;
import exceptions.UsernameAlreadyExists;
import dataAccess.DataAccessHibernate;

public class LoginBean {
	private String username;
	private String password;
	private BLFacade blFacade;

	public LoginBean() {
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

	public String logIn() {
		try {
			User u = blFacade.login(username, password);
			return "ok";
		} catch (InvalidCredentials e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Error: Incorrect username or password. Please try again."));
			return null;
		}

	}
	
	public void initializeDb() {
		new DataAccessHibernate().initializeDB();
	}
}