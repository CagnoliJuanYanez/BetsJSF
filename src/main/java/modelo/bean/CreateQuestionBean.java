package modelo.bean;

import java.util.Date;
import java.util.List;

import org.primefaces.event.SelectEvent;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import dataAccess.DataAccess;
import domain.Event;
import exceptions.EventFinished;
import exceptions.QuestionAlreadyExist;

public class CreateQuestionBean {
	public List<Event> events;
	private BLFacade blFacade;
	public Event event;
	public String question;
	public String betMinimum;
	public String result;


	public CreateQuestionBean() {
		blFacade = new BLFacadeImplementation(new DataAccess());
	}
	
	public void query(SelectEvent event) {
		this.events = blFacade.getEvents((Date) event.getObject());
	}
	
	public void addQuestion() {
		float minimum;
		if (event == null || betMinimum.isEmpty() || question.isEmpty()) {
			this.result  = "Something is missing. You should select an event, indicate question and a minimum bet.";
		} else {
			try {
				minimum = Float.parseFloat(betMinimum); 
				blFacade.createQuestion(event, question, minimum);
				this.result = "Question added successfuly!";
			} catch (EventFinished e) {
				System.out.print("You cannot add a question to this event, this event has already finished.");
				this.result = "You cannot add a question to this event, this event has already finished.";
			} catch (QuestionAlreadyExist e) {
				System.out.print("You cannot add this question to this event, this question already exists.");
				this.result = "You cannot add this question to this event, this question already exists.";
			} catch (NumberFormatException e) {
				System.out.print("Minimum bet should be numerical.");
				this.result = "Minimum bet should be numerical.";
			} catch (Exception e) {
				System.out.print("Error has ocurred:" + e.getMessage());
				this.result = "Error has ocurred:" + e.getMessage();
			}
		}
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
	public Event getEvent() {
		return event;
	}
	
	public void setEvent(Event ev) {
		this.event = ev;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String q) {
		this.question = q;
	}
	
	public String getBetMinimum() {
		return betMinimum;
	}
	
	public void setBetMinimum(String bm) {
		this.betMinimum = bm;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String res) {
		this.result = res;
	}


}


