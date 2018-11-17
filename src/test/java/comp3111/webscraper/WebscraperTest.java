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
		List<Item> items=a.scrape("apple");
		assertNotEquals(items,null);
	}
	
	
}