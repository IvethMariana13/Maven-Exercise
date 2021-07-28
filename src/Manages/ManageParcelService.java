package Manages;
import java.util.List; 
import java.util.Date;
import java.util.Iterator; 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import clases.ParcelService;


public class ManageParcelService {
	
	   /* Method to CREATE an employee in the database */
	   public Integer addParcelService(SessionFactory factory, String name){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      Integer ParcelServiceId = null;
	      
	      try {
	         tx = session.beginTransaction();
	         ParcelService parcelservice = new ParcelService(name);
	         ParcelServiceId = (Integer) session.save(parcelservice); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return ParcelServiceId;
	   }
	   
	   /* Method to  READ all the ParcelService */
	   public void listParcelServices( SessionFactory factory, String Name){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         List parcelservices = session.createQuery("FROM ParcelService").list(); 
	         for (Iterator iterator = parcelservices.iterator(); iterator.hasNext();){
	            ParcelService parcelservice = (ParcelService) iterator.next(); 
	            System.out.print("Name: " + parcelservice.getName()); 
	            
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	   
	   /* Method to UPDATE salary for an employee
	   public void updateParcelService(Integer ParcelServiceId, String Name ){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         ParcelService parcelservice = (ParcelService)session.get(ParcelService.class, ParcelServiceId); 
	         parcelservice.setName(Name);
			 session.update(parcelservice); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }*/
	   
	   /* Method to DELETE an employee from the records */
	   public void deleteParcelService(SessionFactory factory, Integer ParcelServiceId){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         ParcelService parcelservice = (ParcelService)session.get(ParcelService.class,ParcelServiceId ); 
	         session.delete(parcelservice); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	}


