package clases;

public class Article {
	private int ArticleId;
	private String ArticleName;
	private String Description;
	private double Price;
	private int Stock;
	
	public Article () {}
	public Article (String A_name, String description,double price, int stock) {
		this.ArticleName = A_name;
		this.Description = description;
		this.Price = price;
		this.Stock = stock;
		
	}
	
	public int getArtId() {
		return ArticleId;
	}
	public void setArtId(int ArtId){
		this.ArticleId = ArtId;
	}
	
	public String getArticleName() {
	      return ArticleName;
	}
	public void setArticleName (String A_name) {
		this.ArticleName = A_name;
	}
	
	public String getDescription() {
	      return Description;
	}
	public void setDescription (String description) {
		this.Description = description;
	}
	
	public double getPrice() {
	      return Price;
	}
	public void setPrice (double price) {
		this.Price = price;
	}
	public int getStock() {
	      return Stock;
	}
	public void setStock (int stock) {
		this.Stock = stock;
	}
}
