package modelo.bean;

import java.util.Date;
import java.util.List;

import org.primefaces.event.SelectEvent;

public class QueryQuestionBean {
	private Date queryDate;
	
	public Date getQueryDate() {
		return queryDate;
	}
	
	public void setQueryDate(Date aQueryDate) {
		queryDate = aQueryDate;
	}
	
	public void query(SelectEvent select) {
		
	}
	
	public List<Object> getEvents() {
		
	}
}
