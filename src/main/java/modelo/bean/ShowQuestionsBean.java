package modelo.bean;

import java.util.Date;
import java.util.List;

import org.primefaces.event.SelectEvent;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import dataAccess.DataAccessHibernate;
import domain.Event;
import domain.Question;

public class ShowQuestionsBean {
	public List<Question> questions;
	public Event event;
	private BLFacade blFacade;
	
	public ShowQuestionsBean() {
		blFacade = new BLFacadeImplementation(new DataAccessHibernate());
	}
	
	public void queryQuestions(SelectEvent event) {
		this.questions = blFacade.getQuestions((Date) event.getObject());
		if (this.questions.size()>0) {
			System.out.println(questions);
		}else {
			System.out.println(blFacade.getEvents((Date) event.getObject()));
		}
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
