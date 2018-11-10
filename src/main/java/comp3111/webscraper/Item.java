package comp3111.webscraper;

import javafx.scene.control.Hyperlink;

public class Item {
	private String postdate;//basic 4 ,posted date
	private String title ; 
	private double price ;
	private String url ;
	private Hyperlink hyperlink;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPostdate() {//basic 4
		return postdate;
	}
	public void setPostdate(String postdate) {//basic 4
		this.postdate = postdate;
	}
	public Hyperlink getHyperlink() {//basic 4
		return hyperlink;
	}
	public void setHyperlink(String hyperlink) {//basic 4
		this.hyperlink = new Hyperlink(hyperlink);
	}
	
	

}
