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
    	for (int i =0;i<5;i++){
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
	
}
