package Manages;
import java.util.Iterator;
import java.util.List;
import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import clases.Billing;

public class ManageBilling {
	/* Method to create an Billing in the database */
	public Integer addBilling(SessionFactory factory,short Amount,Date Date_Billing) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer InvoceId = null;
		
		try {
			tx = session.beginTransaction();
			Billing billing = new Billing(Amount, Date_Billing);
			InvoceId = (Integer) session.save(billing);
			tx.commit();
		}catch (HibernateException e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		return InvoceId;
	}
	
	/* Method to  READ data the billing */
	public void listBilling(SessionFactory factory, Integer nBilling) {
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
	         tx = session.beginTransaction();
	         System.out.println("--- Data of the Billing created ---");
	         List billing = session.createQuery("FROM Billing c WHERE c.InovoceId = " + nBilling).list(); 
	         for (Iterator iterator = billing.iterator(); iterator.hasNext();){
	        	Billing billings = (Billing) iterator.next();
	            System.out.print("Amount: " + billings.getAmount()); 
	            System.out.println("  Date_Billing: " + billings.getDate_Billing());
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
