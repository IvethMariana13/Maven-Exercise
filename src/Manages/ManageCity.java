package Manages;
import java.util.List; 
import java.util.Iterator; 
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import clases.City;

public class ManageCity {
	/*Method to create an city in the database*/
	public Integer addCity(SessionFactory factory, String Name) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer CityId = null;
		
		try {
			tx = session.beginTransaction();
			City city = new City(Name);
			CityId = (Integer) session.save(city);
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
			
		}return CityId;
	}
	/* Method to  READ data the city */
	public void listCities(SessionFactory factory, String Name) {
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			List cities = session.createQuery("From City").list();
			for (Iterator iterator = cities.iterator(); iterator.hasNext();) {
				City city = (City) iterator.next();
				System.out.print("Name" + city.getName());
			}
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	public void deleteCity (SessionFactory factory, Integer CityId) {
		Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         City city = (City)session.get(City.class, CityId); 
	         session.delete(city); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	}
}
