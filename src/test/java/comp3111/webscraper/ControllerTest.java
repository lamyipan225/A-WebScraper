package comp3111.webscraper;


import org.junit.Test;
import static org.junit.Assert.*;
import javafx.scene.control.Hyperlink;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
public class ControllerTest  {
	@Test
	public void testReturnLatestDate() throws Exception {
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/ui.fxml"));	    	
    	VBox root = (VBox) loader.load();
   		Scene scene =  new Scene(root);
    	Controller controller=loader.getController();
		assertEquals("JAN 1", controller.returnLatestDate("JAN 1","JAN 1")); // month equal
		assertEquals("JAN 11", controller.returnLatestDate("JAN 1","JAN 11"));
		assertEquals("JAN 11", controller.returnLatestDate("JAN 10","JAN 11"));
		assertEquals("JAN 21", controller.returnLatestDate("JAN 21","JAN 11"));

		assertEquals("JUN 21", controller.returnLatestDate("JUN 21","JAN 11"));
		assertEquals("JUL 11", controller.returnLatestDate("JUN 21","JUL 11"));
		assertEquals("JUN 21", controller.returnLatestDate("JUN 21","JUN 11"));
		
		
		assertEquals("JUN 11", controller.returnLatestDate("JAN 1","JUN 11"));
		assertEquals("JUN 1", controller.returnLatestDate("JAN 11","JUN 1"));
		assertEquals("JUN 14", controller.returnLatestDate("JAN 11","JUN 14"));
		assertEquals("JUN 11", controller.returnLatestDate("JAN 14","JUN 11"));
		assertEquals("JUN 21", controller.returnLatestDate("JAN 11","JUN 21"));
		assertEquals("JUN 11", controller.returnLatestDate("JAN 21","JUN 11"));
		assertEquals("JUN 11", controller.returnLatestDate("JAN 11","JUN 11"));

		assertEquals("MAY 11", controller.returnLatestDate("MAR 1","MAY 11"));
		assertEquals("MAY 1", controller.returnLatestDate("MAR 11","MAY 1"));
		assertEquals("MAY 14", controller.returnLatestDate("MAR 11","MAY 14"));
		assertEquals("MAY 11", controller.returnLatestDate("MAR 14","MAY 11"));
		assertEquals("MAY 21", controller.returnLatestDate("MAR 11","MAY 21"));
		assertEquals("MAY 11", controller.returnLatestDate("MAR 21","MAY 11"));
		assertEquals("MAY 11", controller.returnLatestDate("MAR 11","MAY 11"));
		
		assertEquals("AUG 11", controller.returnLatestDate("APR 1","AUG 11"));
		assertEquals("AUG 1", controller.returnLatestDate("APR 11","AUG 1"));
		assertEquals("AUG 14", controller.returnLatestDate("APR 11","AUG 14"));
		assertEquals("AUG 11", controller.returnLatestDate("APR 14","AUG 11"));
		assertEquals("AUG 21", controller.returnLatestDate("APR 11","AUG 21"));
		assertEquals("AUG 11", controller.returnLatestDate("APR 21","AUG 11"));
		assertEquals("AUG 11", controller.returnLatestDate("APR 11","AUG 11"));
		
		assertEquals("OCT 11", controller.returnLatestDate("JAN 1","OCT 11"));
		
		
		assertEquals("FEB 1", controller.returnLatestDate("FEB 1","JAN 11"));
		assertEquals("FEB 1", controller.returnLatestDate("FEB 1","JAN 1"));
		assertEquals("JUN 11", controller.returnLatestDate("FEB 1","JUN 11"));
		assertEquals("JUN 14", controller.returnLatestDate("FEB 14","JUN 14"));
		assertEquals("JUN 14", controller.returnLatestDate("FEB 24","JUN 14"));

		assertEquals("MAR 1", controller.returnLatestDate("MAR 1","FEB 11"));
		assertEquals("MAR 1", controller.returnLatestDate("MAR 1","FEB 1"));
		assertEquals("MAR 11", controller.returnLatestDate("MAR 11","FEB 11"));
		assertEquals("MAR 21", controller.returnLatestDate("MAR 21","FEB 11"));
		assertEquals("MAR 11", controller.returnLatestDate("MAR 11","FEB 1"));
		
		assertEquals("APR 1", controller.returnLatestDate("APR 1","FEB 11"));
		assertEquals("APR 1", controller.returnLatestDate("APR 1","FEB 1"));
		assertEquals("APR 11", controller.returnLatestDate("APR 11","FEB 11"));
		assertEquals("APR 21", controller.returnLatestDate("APR 21","FEB 11"));
		assertEquals("APR 11", controller.returnLatestDate("APR 11","FEB 1"));
		
		assertEquals("MAY 1", controller.returnLatestDate("MAY 1","MAR 11"));
		assertEquals("MAY 1", controller.returnLatestDate("MAY 1","FEB 1"));
		assertEquals("MAY 11", controller.returnLatestDate("MAY 11","MAR 11"));
		assertEquals("MAY 21", controller.returnLatestDate("MAY 21","FEB 11"));
		assertEquals("MAY 11", controller.returnLatestDate("MAY 11","MAR 1"));

		assertEquals("JUN 1", controller.returnLatestDate("JUN 1","MAY 11"));
		assertEquals("JUL 11", controller.returnLatestDate("JUN 1","JUL 11"));
		
		
		assertEquals("JUL 1", controller.returnLatestDate("JUL 1","JUN 11"));
		assertEquals("AUG 11", controller.returnLatestDate("JUL 1","AUG 11"));

		assertEquals("AUG 1", controller.returnLatestDate("AUG 1","JUL 11"));
		assertEquals("SEP 11", controller.returnLatestDate("AUG 1","SEP 11"));

		
		assertEquals("SEP 1", controller.returnLatestDate("SEP 1","AUG 11"));
		assertEquals("OCT 11", controller.returnLatestDate("SEP 1","OCT 11"));

		
		assertEquals("NOV 11", controller.returnLatestDate("OCT 1","NOV 11"));
		assertEquals("OCT 1", controller.returnLatestDate("OCT 1","SEP 11"));

		
		assertEquals("DEC 11", controller.returnLatestDate("NOV 1","DEC 11"));
		assertEquals("NOV 1", controller.returnLatestDate("NOV 1","OCT 11"));


	}
	@Test
	public void TestShowinfo()throws Exception {
		com.sun.javafx.application.PlatformImpl.startup(()->{});
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/ui.fxml")); 	
   		VBox root = (VBox) loader.load();
   		Scene scene =  new Scene(root);
    	Controller controller=loader.getController();
		ObservableList<Item> items=FXCollections.observableArrayList();
		Item a=new Item();
		a.setHyperlink("www.google.com");
		a.setPostdate("Nov 11");
		a.setPrice(10.0);
		a.setTitle("Google");
		a.setUrl("www.google.com");
		items.add(a);
		controller.showinfo(items);	
		assertEquals(controller.getTable().getItems(),items);
		//com.sun.javafx.application.PlatformImpl.exit();
	}
	@Test
	public void Testsetstage() throws Exception {
			com.sun.javafx.application.PlatformImpl.startup(()->{});
			FXMLLoader loader = new FXMLLoader();
	    	loader.setLocation(getClass().getResource("/ui.fxml"));	    	
	    	VBox root = (VBox) loader.load();
	   		Scene scene =  new Scene(root);
	    	Controller controller=loader.getController();
	    	controller.setstage(null);
	    	assertEquals(controller.getStage(),null);
		
		
	}
	@Test
	public void TestClickableURL()throws Exception{
		com.sun.javafx.application.PlatformImpl.startup(()->{});
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/ui.fxml"));	    	
    	VBox root = (VBox) loader.load();
   		Scene scene =  new Scene(root);
    	Controller controller=loader.getController();
    	Hyperlink hyperlink=new Hyperlink("www.google.com");
    	controller.clickableURL(hyperlink);
    	hyperlink.fire();
    	assertNotEquals(hyperlink.getOnAction(),null);
	}
	@Test
	public void TestactionLastSearch()throws Exception{
		com.sun.javafx.application.PlatformImpl.startup(()->{});
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/ui.fxml"));	    	
    	VBox root = (VBox) loader.load();
   		Scene scene =  new Scene(root);
    	Controller controller=loader.getController();
    	controller.previoussearch="apple";
    	controller.getlastsearch().fire();
    	assertEquals(controller.getlastsearch().isDisable(),true);
	}
	@Test
	public void TestactionSearch()throws Exception{
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/ui.fxml"));	    	
    	VBox root = (VBox) loader.load();
   		Scene scene =  new Scene(root);
    	Controller controller=loader.getController();
    	controller.settextfield("apple");
    	for (int i =0;i<2;i++){
    		controller.getbutton().fire();
    	}
    	assertEquals(controller.getlastsearch().isDisable(),false);
	}
	@Test
	public void TestActionhelp()throws Exception{
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/ui.fxml"));	    	
    	VBox root = (VBox) loader.load();
   		Scene scene =  new Scene(root);
    	Controller controller=loader.getController();
    	Platform.runLater(
    			  () -> {
    				  controller.gethelp().fire();
    				  assertEquals(controller.alert.getTitle(),"About your team");
    			  }
    			);
    	
	}
	@Test
	public void TestActionClose()throws Exception{
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/ui.fxml"));	    	
    	VBox root = (VBox) loader.load();
   		Scene scene =  new Scene(root);
   		Platform.runLater(
  			  () -> {
  				  Stage stage =new Stage();
  				  stage.setScene(scene);
  				  Controller controller=loader.getController();
  				  controller.setstage(stage);
  				  controller.getclose().fire();
  				  assertEquals(controller.currentsearch,"");
  			 }
    			);

	}
	@Test
	public void TestActionQuit()throws Exception{
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/ui.fxml"));	    	
    	VBox root = (VBox) loader.load();
   		Scene scene =  new Scene(root);
   		Platform.runLater(
    			  () -> {
    				  Stage stage =new Stage();
    				  stage.setScene(scene);
    				  Controller controller=loader.getController();
    				  controller.setstage(stage);
    				  controller.getquit().fire();
    				  assertEquals(stage.isShowing(),false);
    			  }
    			);
	}
	@Test
	public void TestactionRefine()throws Exception{
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/ui.fxml"));	    	
    	VBox root = (VBox) loader.load();
   		Scene scene =  new Scene(root);
    	Controller controller=loader.getController();
    	controller.currentsearch="apple";
    	controller.settextfield("iphone");
    	controller.getRefine().setDisable(false);
    	controller.getRefine().fire();
    	assertEquals(controller.getRefine().isDisable(),true);
	}
	
}
