package comp3111.webscraper;
import org.junit.Test;
import static org.junit.Assert.*;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.util.Vector;
import java.util.List;
public class WebscraperTest{
	@Test
	public void TestScrape(){
		WebScraper a =new WebScraper();
		List<Item> items=a.scrape("ps4");
		assertNotEquals(items,null);
		List<Item> items_2=a.scrape("ps4444444444444444444");
		assertNotEquals(items_2,null);
	}
	
	
}
