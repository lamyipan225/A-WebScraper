package comp3111.webscraper;

import javafx.scene.control.Hyperlink;
/**
 * 
 * To store the information of one particular search result.
 * @author cmleungah
 *
 */
public class Item {
	/**
	 * The posted date of the item
	 * @author cnleungah
	 */
	private String postdate;//basic 4 ,posted date
	/**
	 * The Title of the item
	 * @author cnleungah
	 */
	private String title ; 
	/**
	 * The Price of the item
	 * @author cnleungah
	 */
	private double price ;
	/**
	 * The URL of the item
	 * @author cnleungah
	 */
	private String url ;
	/**
	 * The hyperlink of the item
	 * @author cnleungah
	 */
	private Hyperlink hyperlink;
	
	/**
	 * To get the Title of the item
	 * @return - the title of the item
	 * @author cnleungah
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * To change the Title of the item 
	 * @param title - The new title
	 * @author cnleungah
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * To get the Price of the item
	 * @return - the price of the item
	 * @author cnleungah
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * To change the Price of the item 
	 * @param price - The new price
	 * @author cnleungah
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * To get the URL of the item
	 * @return - the url of the item
	 * @author cnleungah
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * To change the URL of the item 
	 * @param url - The new url
	 * @author cnleungah
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * To get the Posted Date of the item
	 * @return - the posted date of the item
	 * @author cnleungah
	 */
	public String getPostdate() {//basic 4
		return postdate;
	}
	/**
	 * To change the Posted Date of the item 
	 * @param postdate - The new posted date
	 * @author cnleungah
	 */
	public void setPostdate(String postdate) {//basic 4
		this.postdate = postdate;
	}
	/**
	 * To get the Hyperlink of the item
	 * @return - the hyperlink of the item
	 * @author cnleungah
	 */
	public Hyperlink getHyperlink() {//basic 4
		return hyperlink;
	}
	/**
	 * To change the Hyperlink of the item 
	 * @param hyperlink - The new hyperlink
	 * @author cnleungah
	 */
	public void setHyperlink(String hyperlink) {//basic 4
		this.hyperlink = new Hyperlink(hyperlink);
	}
	
	

}
