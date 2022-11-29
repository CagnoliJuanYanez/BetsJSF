package modelo.bean;

import java.util.Date;
import java.util.List;

import org.primefaces.event.SelectEvent;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import dataAccess.DataAccess;
import domain.Event;

public class CreateQuestionBean {
	public List<Event> events;
	private BLFacade blFacade;

	public CreateQuestionBean() {
		blFacade = new BLFacadeImplementation(new DataAccess());
	}
	
	public void query(SelectEvent event) {
		this.events = blFacade.getEvents((Date) event.getObject());
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	


}


