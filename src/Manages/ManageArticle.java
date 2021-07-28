package Manages;

import java.util.List; 
import java.util.Iterator; 
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import clases.Article;

public class ManageArticle {
	

	   /* Method to CREATE an Article in the database */
	   public Integer addArticle(SessionFactory factory, String A_name, String description,double price, int stock){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      Integer ArticleId = null;
	      
	      try {
	         tx = session.beginTransaction();
	         Article articles = new Article(A_name,description,price,stock );
	         ArticleId = (Integer) session.save(articles); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return ArticleId;
	   }
	   
	   /* Method to  READ all the articles */
	   public void listArticles( SessionFactory factory, String A_name, String description,double price, int stock){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         List articles = session.createQuery("FROM Article").list(); 
	         for (Iterator iterator = articles.iterator(); iterator.hasNext();){
	            Article article = (Article) iterator.next(); 
	            System.out.print("Article Name: " + article.getArticleName()); 
	            System.out.print("  Description: " + article.getDescription()); 
	            System.out.println("  Price: " + article.getPrice()); 
	            System.out.print("Stock: " + article.getStock());
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	   
	   /* Method to UPDATE stack for an article 
	   public void updateArticle(Integer ArticleID, int stock ){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         Article article = (Article)session.get(Article.class, ArticleID); 
	         article.setStock( stock );
			 session.update(article); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	   
	   /* Method to DELETE an employee from the records 
	   public void deleteArticle(Integer ArticleID){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         Article article = (Article)session.get(Article.class, ArticleID); 
	         session.delete(article); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }*/

}
