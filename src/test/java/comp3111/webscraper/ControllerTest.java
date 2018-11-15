package comp3111.webscraper;


import org.junit.Test;
import static org.junit.Assert.*;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.collections.*;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
public class ControllerTest extends Application {
	@Override
	public void start(Stage stage)throws Exception {
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
	    	loader.setLocation(getClass().getResource("/ux.fxml"));
	    	VBox root = (VBox) loader.load();
	   		Scene scene =  new Scene(root);
	    	Controller controller=loader.getController();
	    	controller.setstage(stage);
	    	assertEquals(controller.getStage(),stage);
		
		
	}
}
