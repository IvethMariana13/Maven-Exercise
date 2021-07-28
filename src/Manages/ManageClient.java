package Manages;
import java.util.List; 
import java.util.Date;
import java.util.Iterator; 
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import clases.Client;

public class ManageClient {

   /* Method to CREATE a client in the database */
   public Integer addClient(SessionFactory factory,String name, String lname, String usname, String pwd, String email){
      Session session = factory.openSession();
      Transaction tx = null;
      Integer ClientId = null;
      
      try {
         tx = session.beginTransaction();
         Client client = new Client(name, lname, usname, pwd, email);
         ClientId = (Integer) session.save(client); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
      return ClientId;
   }
   
   /* Method to  READ all the client */
   public void listClients(SessionFactory factory, String name, String lname, String usname, String pwd, String email ){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         List clients = session.createQuery("FROM Client").list(); 
         for (Iterator iterator = clients.iterator(); iterator.hasNext();){
            Client client = (Client) iterator.next(); 
            
            System.out.print("Name: " + client.getName()); 
            System.out.print("Last Name: " + client.getLastName()); 
            System.out.println("Username: " + client.getUserName());
            System.out.print("Password: " + client.getPassword());
            System.out.println("  Email: " + client.getEmail()); 
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }
   

   public void deleteClient(SessionFactory factory, Integer ClientId){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         Client client = (Client)session.get(Client.class, ClientId); 
         session.delete(client); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }

}
