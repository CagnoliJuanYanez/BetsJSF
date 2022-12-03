package dataAccess;

import java.util.List;

public class prueba {

	public static void main(String[] args) {
		DataAccessHibernate a = new DataAccessHibernate();
		a.initializeDB();
		
		System.out.println("Empieza query");
		
		List s = a.getEvents(null);
		System.out.println(s.get(0));
		System.out.println(s.get(1));
	}

}
