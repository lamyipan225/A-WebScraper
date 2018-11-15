package comp3111.webscraper;


import org.junit.Test;
import static org.junit.Assert.*;

public class ItemTest {

	@Test
	public void testSetTitle() {
		Item i = new Item();
		i.setTitle("ABCDE");
		assertEquals(i.getTitle(), "ABCDE");
	}
	@Test
	public void testSetPrice() {
		
		Item i = new Item();
		i.setPrice(10.0);
		assertEquals(i.getPrice(), 10.0,0.01);
	}
	@Test
	public void testSetUrl() {
		Item i = new Item();
		i.setUrl("www.google.com");
		assertEquals(i.getUrl(), "www.google.com");
	}
	@Test
	public void testSetPostdate() {
		Item i = new Item();
		i.setPostdate("Nov 11");
		assertEquals(i.getPostdate(), "Nov 11");
	}
	
	@Test
	public void testSetHyperlink() {
		com.sun.javafx.application.PlatformImpl.startup(()->{});
		Item i = new Item();
		i.setHyperlink("www.google.com");
		assertEquals(i.getHyperlink().getText(), "www.google.com");
		//com.sun.javafx.application.PlatformImpl.exit();
	}
	
}

