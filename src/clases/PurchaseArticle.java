package clases;
import java.util.HashSet;
import java.util.Set;
public class PurchaseArticle {
	private Integer PArticleId;
	private Set POrderId = new HashSet (0);
	private Set ArticleId = new HashSet (0);
	
	public PurchaseArticle() {
		
	}
	
	public PurchaseArticle (Integer PArticleId) {
		this.PArticleId = PArticleId;
	}
	public PurchaseArticle (Set POrderId, Set ArticleId) {
		this.ArticleId = ArticleId;
		this.POrderId = POrderId;

	}
	public Set getPOrderId () {
		return this.POrderId;
	}
	public void setPOrderId (Set POrderId) {
		this.POrderId = POrderId;
	}
	
	public Set getArticleId () {
		return this.ArticleId;
	}
	public void seArticleId (Set ArticleId) {
		this.ArticleId = ArticleId;
	}
	
	
	
	

}
