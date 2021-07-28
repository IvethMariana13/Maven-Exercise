package Manages;
import java.util.Iterator;
import java.util.List;
import java. util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import clases.DeliveryPackage;

public class ManageDeliveryPackage {
	/* Method to create an delivery package in the database */
	public Integer addDeliveryPackage(SessionFactory factory,Date Date) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer PackageId = null;
		
		try {
			tx = session.beginTransaction();
			DeliveryPackage DeliveryPack = new DeliveryPackage(Date);
			PackageId = (Integer) session.save(DeliveryPack);
			tx.commit();
		}catch (HibernateException e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		return PackageId;
	}
	
	/* Method to  READ data the delivery package */
	public void listDeliveryPackages(SessionFactory factory, Integer nDeliveryPackage) {
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
	         tx = session.beginTransaction();
	         System.out.println("--- Data of the Delivery Package created ---");
	         List DeliveryPackage = session.createQuery("FROM CreditCards c WHERE c.creditCardId = " + nDeliveryPackage).list(); 
	         for (Iterator iterator = DeliveryPackage.iterator(); iterator.hasNext();){
	        	DeliveryPackage DeliveryPack = (DeliveryPackage) iterator.next();
	            System.out.print("Date: " + DeliveryPack.getDate()); 
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
