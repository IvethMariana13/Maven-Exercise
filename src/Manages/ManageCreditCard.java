package Manages;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import clases.CreditCard;

public class ManageCreditCard {
	/* Method to create an credit_card in the database */
	public Integer addCreditCard(SessionFactory factory,Integer CardNumber,String CardHolder) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer CreditCardId = null;
		
		try {
			tx = session.beginTransaction();
			CreditCard creditcard = new CreditCard(CardNumber, CardHolder );
			CreditCardId = (Integer) session.save(creditcard);
			tx.commit();
		}catch (HibernateException e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		return CreditCardId;
	}
	
	/* Method to  READ data the credit_card */
	public void listCreditCard(SessionFactory factory, Integer nCreditCard) {
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
	         tx = session.beginTransaction();
	         System.out.println("--- Data of the credit card created ---");
	         List creditcard = session.createQuery("FROM CreditCard c WHERE c.CreditCardId = " + nCreditCard).list(); 
	         for (Iterator iterator = creditcard.iterator(); iterator.hasNext();){
	        	CreditCard creditcards = (CreditCard) iterator.next();
	            System.out.print("CardNumber: " + creditcards.getCardNumber()); 
	            System.out.println("  CardHolder: " + creditcards.getCardHolder());
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
