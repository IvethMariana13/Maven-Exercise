package Manages;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import clases.DeliveryAddress;

public class ManageDeliveryAddress {
	/* Method to create an credit_card in the database */
	public Integer addDeliveryAddress(SessionFactory factory,String Street,String Number) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer DeliveryAdId = null;
		
		try {
			tx = session.beginTransaction();
			DeliveryAddress deliveryaddress = new DeliveryAddress (Street, Number);
			DeliveryAdId = (Integer) session.save(deliveryaddress);
			tx.commit();
		}catch (HibernateException e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		return DeliveryAdId;
	}
	
	/* Method to  READ data the credit_card */
	public void listDeliveryAddress(SessionFactory factory, Integer nDeliveryAddress) {
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
	         tx = session.beginTransaction();
	         System.out.println("--- Data of the delivery address created ---");
	         List deliveryaddress = session.createQuery("FROM DeliveryAddress c WHERE c.DeliveryAdId = " + nDeliveryAddress).list(); 
	         for (Iterator iterator = deliveryaddress.iterator(); iterator.hasNext();){
	        	DeliveryAddress deliveryaddres = (DeliveryAddress) iterator.next();
	        	System.out.println(" Street: " + deliveryaddres.getStreet());
	            System.out.print("Number: " + deliveryaddres.getNumber()); 
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	}
	
	

}
