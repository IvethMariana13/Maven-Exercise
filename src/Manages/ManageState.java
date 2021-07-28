package Manages;
import java.util.List; 
import java.util.Iterator; 
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import clases.State;

public class ManageState {
	/* Method to create an State in the database */
	public Integer addState(SessionFactory factory,String Name) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer StateId = null;
		
		try {
			tx = session.beginTransaction();
			State state = new State(Name);
			
			StateId = (Integer) session.save(state);
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
			
		}return StateId;
	}
	/* Method to  READ data the state*/
	public void listStates(SessionFactory factory, String Name) {
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			List states = session.createQuery("From State").list();
			for (Iterator iterator = states.iterator(); iterator.hasNext();) {
				State state = (State) iterator.next();
				System.out.print("Name" + state.getName());
			}
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	public void deleteStates (SessionFactory factory, Integer StateId) {
		Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         State state = (State)session.get(State.class, StateId); 
	         session.delete(state); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	}


}
