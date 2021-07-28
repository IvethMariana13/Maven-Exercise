package Manages;
import java.util.List; 
import java.util.Date;
import java.util.Iterator; 
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import clases.Country;

public class ManageCountry {
	/* Method to create an country in the database */
	public Integer addCountry(SessionFactory factory,String Name) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer CountryId = null;
		
		try {
			tx = session.beginTransaction();
			Country country = new Country(Name);
			CountryId = (Integer) session.save(country);
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
			
		}return CountryId;
	}
	/* Method to  READ data the country */
	public void listCountries(SessionFactory factory, String Name) {
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			List countries = session.createQuery("From Country").list();
			for (Iterator iterator = countries.iterator(); iterator.hasNext();) {
				Country country = (Country) iterator.next();
				System.out.print("Name" + country.getName());
			}
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	public void deleteCountries (SessionFactory factory,  Integer CountryId) {
		Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         Country country = (Country)session.get(Country.class, CountryId); 
	         session.delete(country); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	}

}
