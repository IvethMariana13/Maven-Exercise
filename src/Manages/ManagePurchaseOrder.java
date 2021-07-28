package Manages;
import java.util.Iterator;
import java.util.List;
import java. util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import clases.PurchaseOrder;

public class ManagePurchaseOrder {
	
	/* Method to create an purchase order in the database */
	public Integer addPurchaseOrder(SessionFactory factory,Date Date_Order) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer POrderId = null;
		
		try {
			tx = session.beginTransaction();
			PurchaseOrder purchaseorder =  new PurchaseOrder (Date_Order);
			POrderId = (Integer) session.save(purchaseorder);
			tx.commit();
		}catch (HibernateException e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		return POrderId;
	}
	
	/* Method to  READ data the purchaseorder */
	public void listPurchaseOrder(SessionFactory factory, Integer nPurchaseOrder) {
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
	         tx = session.beginTransaction();
	         System.out.println("--- Data of the purchase order created ---");
	         List creditcard = session.createQuery("FROM PurchaseOrder po WHERE po.POrderId = " + nPurchaseOrder).list(); 
	         for (Iterator iterator = creditcard.iterator(); iterator.hasNext();){
	        	PurchaseOrder purchaseorder = (PurchaseOrder) iterator.next(); 
	            System.out.print("Date_Order: " + purchaseorder.getDate_Order()); 
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
