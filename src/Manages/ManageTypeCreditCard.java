package Manages;
import java.util.List; 
import java.util.Date;
import java.util.Iterator; 
 import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import clases.TypeCreditCard;


public class ManageTypeCreditCard {
   
	   /* Method to CREATE an typecreditcard in the database */
	   public Integer addTypeCreditCard (SessionFactory factory, String type){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      Integer TypeCardId = null;
	      
	      try {
	         tx = session.beginTransaction();
	         TypeCreditCard typecreditcard = new TypeCreditCard(type);
	         TypeCardId = (Integer) session.save(typecreditcard);
	          tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return TypeCardId;
	   }
	   
	   /* Method to  READ all the employees */
	   public void listTypeCreditCards( SessionFactory factory, String Type){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         List typecreditcards = session.createQuery("FROM TypeCreditCard").list(); 
	         for (Iterator iterator = typecreditcards.iterator(); iterator.hasNext();){
	            TypeCreditCard typecreditcard = (TypeCreditCard) iterator.next(); 
	            System.out.print("Type: " + typecreditcard.getType()); 
	          ; 
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	   
	   /* Method to UPDATE Type for an TypeCreditCard 
	   public void updateTypeCreditCard(Integer TypeCardId, String Type ){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         TypeCreditCard typecreditcard = (TypeCreditCard)session.get(TypeCreditCard.class, TypeCardId); 
	         typecreditcard.SetType(Type);
			 session.update(typecreditcard); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }*/
	   
	   /* Method to DELETE an TypeCreditCard from the records */
	   public void deleteTypeCreditCard(SessionFactory factory, Integer TypeCardId){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         TypeCreditCard typecreditcard = (TypeCreditCard)session.get(TypeCreditCard.class, TypeCardId); 
	         session.delete(typecreditcard); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
}
