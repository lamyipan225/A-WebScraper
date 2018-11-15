/**
 * 
 */
package comp3111.webscraper;


import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.util.List;
import javafx.scene.control.TableColumn;//for basic 4
import javafx.scene.control.TableView;//basic 4
import javafx.scene.control.cell.PropertyValueFactory;//basic 4
import javafx.collections.*;//basic 4
import javafx.event.ActionEvent;//basic 4
import javafx.event.EventHandler;//basic 4
import javafx.application.Application;//basic 4
import javafx.stage.Stage;//basic 4
import javafx.scene.control.Alert;//basic 6
import javafx.scene.control.Alert.AlertType;//basic 6
import javafx.fxml.FXMLLoader;//Basic 6
import javafx.scene.layout.VBox;//Basic 6
import javafx.scene.Scene;//Basic 6
import javafx.scene.control.MenuItem;//Basic 6
/**
 * 
 * @author kevinw
 *
 *
 * Controller class that manage GUI interaction. Please see document about JavaFX for details.
 * 
 */
public class Controller {
    @FXML 
    private Label labelCount; 
    @FXML 
    private Label labelPrice; 
    @FXML 
    private Hyperlink labelMin; 
    @FXML 
    private Hyperlink labelLatest; 
    @FXML
    private TextField textFieldKeyword;
    @FXML
    private TextArea textAreaConsole;
    @FXML
    private TableView<Item> table;//basic 4
    @FXML
    private TableColumn<Item, String> titlecol;//basic 4
    @FXML
    private TableColumn<Item, Double> pricecol;//basic 4
    @FXML
    private TableColumn<Item, Hyperlink> urlcol;//basic 4
    @FXML
    private TableColumn<Item, String> postcol;//basic 4
    @FXML  
    private BarChart<?, ?> barChartHistogram;
    private int count;//Basic 6
    private String currentsearch="";//Basic 6
    private String previoussearch;//Basic 6
    @FXML
    private MenuItem lastsearch;//Basic 6
    private Stage mystage;//basic 6
    //Basic 6,helper function
    public void setstage(Stage stage){
    	mystage=stage;
    }
    //helper function for unit testing
    public Stage getStage() {
    	return mystage;
    }
    //help function for unit testing.
    public TableView<?> getTable() {
    	return table;
    }
    private WebScraper scraper;
    //basic 4,Show the correct information in the tab Table
    public void showinfo(ObservableList<Item> items){
    	titlecol.setCellValueFactory(new PropertyValueFactory<>("title"));
    	pricecol.setCellValueFactory(new PropertyValueFactory<>("price"));
    	urlcol.setCellValueFactory(new PropertyValueFactory<>("hyperlink"));
    	postcol.setCellValueFactory(new PropertyValueFactory<>("postdate"));
    	table.setItems(items);	
    }
    //this is for basic 4. To make the URL clickable to open a webpage
    public void clickableURL(Hyperlink hyperlink){
    	hyperlink.setOnAction(new EventHandler<ActionEvent>() {
			Application a = new Application() {

                @Override
                public void start(Stage stage)
                {             	
                }
            };
            @Override
            public void handle(ActionEvent t) {
				a.getHostServices().showDocument(hyperlink.getText());
            }
		});
    }
    /**
     * Default controller
     */
    public Controller() {
    	scraper = new WebScraper();
    }

    /**
     * Default initializer. It is empty.
     */
    @FXML
    private void initialize() {
    	
    }
    
    /**
     * Called when the search button is pressed.
     */
    @FXML
    private void actionSearch() {
	    	ObservableList<Item> items=FXCollections.observableArrayList();
	    	System.out.println("actionSearch: " + textFieldKeyword.getText());
	    	List<Item> result = scraper.scrape(textFieldKeyword.getText());
	    	String output = "";
	    	for (Item item : result) {
	    		output += item.getTitle() + "\t" + item.getPrice() + "\t" + item.getUrl() +"\t"+item.getPostdate()+ "\n";
	    		item.setHyperlink(item.getUrl());//basic 4,set item's url to hyperlink
	    		clickableURL(item.getHyperlink());//basic 4
	    		items.add(item);//basic 4
	    	}
	    	showinfo(items);//basic 4
	    	textAreaConsole.setText(output);
	    	if (count==0){
		    	currentsearch=textFieldKeyword.getText(); 
		    	previoussearch=currentsearch;	
	    	}
	    	else if (count>0){
	    		previoussearch=currentsearch;
	    		currentsearch=textFieldKeyword.getText();
	    	}	
	    	count++;
	    	lastsearch.setDisable(false);
    }
    //Basic 6 Last search
    @FXML
    void actionLastSearch(ActionEvent event) {
    	ObservableList<Item> items=FXCollections.observableArrayList();
    	System.out.println("LastSearch: " + previoussearch);
    	List<Item> result = scraper.scrape(previoussearch);
    	String output = "";
    	for (Item item : result) {
    		output += item.getTitle() + "\t" + item.getPrice() + "\t" + item.getUrl() +"\t"+item.getPostdate()+ "\n";
    		item.setHyperlink(item.getUrl());
    		clickableURL(item.getHyperlink());
    		items.add(item);
    	}
    	showinfo(items);
    	textAreaConsole.setText(output);
    	String temp=previoussearch;
    	previoussearch=currentsearch;
    	currentsearch=temp;
    	lastsearch.setDisable(true);
    }
    //Basic 6,About your team.
    @FXML
    void ActionHelp(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("About your team");
    	alert.setHeaderText(null);
    	alert.setContentText("Name: Leung Chi Ming\nITSC:cmleungah@connect.ust.hk\nGithub:Dominic852\n\nName:Fok Chun Yin \nITSC: cyfok@connect.ust.hk \nGithub: cyfok4444\n\nName: Lam Yi Pan \nITSC: yplamae@connect.ust.hk\nGithub: lamyipan225");
    	alert.showAndWait();
    }
    //Basic 6,Quit the program
    @FXML
    void ActionQuit(ActionEvent event) {
    	mystage.close();
    }
    //Basic 6,Close the cuurent search Record
    @FXML
    void ActionClose(ActionEvent event)throws Exception {
    	WebScraperApplication a =new WebScraperApplication();
    	a.start(mystage);
    }
}

