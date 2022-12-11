package modelo.bean;

import java.util.Date;
import java.util.List;

import org.primefaces.event.SelectEvent;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import dataAccess.DataAccessHibernate;
import domain.Event;
import domain.Question;

public class QueryQuestionBean {
	public List<Event> events;
	public List<Question> questions;
	public Event event;
	private BLFacade blFacade;
	
	public QueryQuestionBean() {
		blFacade = new BLFacadeImplementation(new DataAccessHibernate());
	}
	
	public void queryEvents(SelectEvent event) {
		this.events = blFacade.getEvents((Date) event.getObject());
		this.questions = null;
	}
	
	public void queryQuestions(SelectEvent selectEvent) {
		this.questions = event.getQuestions();
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
	public List<Question> getQuestions() {
		return questions;
	}
	
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	public Event getEvent() {
		return event;
	}
	
	public void setEvent(Event ev) {
		this.event = ev;
	}
}
