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
import javafx.scene.control.Button;
/**
 * 
 * 
 *
 *
 * Controller class that manage GUI interaction. Please see document about JavaFX for details.
 * @author kevinw
 */
public class Controller {
	/**
	 * 
	 * The Button for search
	 * @author cmleungah
	 */
    @FXML
    private Button gobutton;
    @FXML
    private Button refinebotton;
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
    /**
     * The table view of the tab "table"
     * @author cmleungah
     */
    @FXML
    private TableView<Item> table;//basic 4
    /**
     * The column in the tab table named"Title"
     * @author cmleungah
     */
    @FXML
    private TableColumn<Item, String> titlecol;//basic 4
    /**
     * The column in the tab table named"Price"
     * @author cmleungah
     */
    @FXML
    private TableColumn<Item, Double> pricecol;//basic 4
    /**
     * The column in the tab table named"URL"
     * @author cmleungah
     */
    @FXML
    private TableColumn<Item, Hyperlink> urlcol;//basic 4
    /**
     * The column in the tab table named"Post Date"
     * @author cmleungah
     */
    @FXML
    private TableColumn<Item, String> postcol;//basic 4
    @FXML  
    private BarChart<?, ?> barChartHistogram;
    /**
     * To count the number of times that the user searches.
     * @author cmleungah
     */
    private int count;//Basic 6
    /**
     * To keep track of the current search keyword
     * @author cmleungah
     */
    public String currentsearch="";//Basic 6
    /**
     * To keep track of the last search keyword
     * @author cmleungah
     */
    public String previoussearch;//Basic 6
    /**
     * The menu item under menu-bar File named"Last search"
     * @author cmleungah
     */
    @FXML
    private MenuItem lastsearch;//Basic 6
    /**
     * The menu item under menu-bar File named"Close"
     * @author cmleungah
     */
    @FXML
    private MenuItem closemenu;//Basic 6
    /**
     * The menu item under menu-bar File named"Quit"
     * @author cmleungah
     */
    @FXML
    private MenuItem quitmenu;//Basic 6
    /**
     * The menu item under menu-bar Help named"About Your Team"
     * @author cmleungah
     */
    @FXML
    private MenuItem helpmenu;//Basic 6
    /**
     * To access the Stage of the Application.
     * @author cmleungah
     */
    private Stage mystage;//basic 6
    //Basic 6,helper function
    /**
     * 
     * 
     * To set the private attribute "mystage" to the Stage in the Application thread.
     * 
     * @param stage - The stage of the Application
     * @author cmleungah
     * 
     */
    public void setstage(Stage stage){
    	mystage=stage;
    }
    //helper function for unit testing
    /**
     * To get the control of the "Go" Button.
     * 
     * @return - the "Go" Button 
     * @author cmleungah
     */
    public Button getbutton(){
    	return gobutton;
    }
    //helper function for unit testing
    /**
     * A helper function for unit testing which set the keyword int the textfield to a string.
     * 
     * @param x - The keyword you want to search
     * @author cmleungah
     */
    public void settextfield(String x){
    	textFieldKeyword.setText(x);
    }
    //helper function for unit testing
    /**
     *  A helper function in unit testing to get the control of the Stage in the Application thread
     * @return - The stage of the Application thread.
     * @author cmleungah
     */
    public Stage getStage() {
    	return mystage;
    }
  //helper function for unit testing
    /**
     *  A helper function in unit testing to get the control of the menu item named "Quit".
     * @return - the menu item named "Quit".
     * @author cmleungah
     */
    public MenuItem getquit(){
    	return quitmenu;
    }
  //helper function for unit testing
    /**
     *  A helper function in unit testing to get the control of the menu item named "About Your Team".
     * @return - the menu item named "About Your Team".
     * @author cmleungah
     */
    public MenuItem gethelp(){
    	return helpmenu;
    }
  //helper function for unit testing
    /**
     *  A helper function in unit testing to get the control of the menu item named "Close".
     * @return - the menu item named "Close".
     * @author cmleungah
     */
    public MenuItem getclose(){
    	return closemenu;
    }
    
  //helper function for unit testing
    /**
     *  A helper function in unit testing to get the control of the button named "refinebutton".
     * @return - the button named "refinebutton".
     * @author yplamae
     */
    public Button getRefine(){
    	return refinebotton;
    }
    
    //help function for unit testing.
    /**
     *  A helper function in unit testing to get the control of the Table view named"Table".
     * @return - the Table View named "Table".
     * @author cmleungah
     */
    public TableView<?> getTable() {
    	return table;
    }
    //helper function for testing
    /**
     *  A helper function in unit testing to get the control of the menu item named "Last Search".
     * @return - the menu item named "Last Search".
     * @author cmleungah
     */
    public MenuItem getlastsearch(){
    	return lastsearch;
    }
    /**
     * A variable to search the data. 
     */
    private WebScraper scraper;
    /**
     * A variable which can show a dialog
     * @author cmleungah
     */
    public Alert alert;//basic 6
    //basic 4,Show the correct information in the tab Table
    /**
     * To correctly show the search result in the Tab "Table".
     * 
     * @param items - A list of items which contain the information of the search result.
     * @author cmleungah
     */
    public void showinfo(ObservableList<Item> items){
    	titlecol.setCellValueFactory(new PropertyValueFactory<>("title"));
    	pricecol.setCellValueFactory(new PropertyValueFactory<>("price"));
    	urlcol.setCellValueFactory(new PropertyValueFactory<>("hyperlink"));
    	postcol.setCellValueFactory(new PropertyValueFactory<>("postdate"));
    	table.setItems(items);	
    }
    //this is for basic 4. To make the URL clickable to open a webpage
    /**
     * To make the url can be clicked by the user and open a browser of that url.
     * @param hyperlink - the hyperlink of a particular search Item.
     * @author cmleungah
     */
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
	    	previoussearch=currentsearch;
	    	currentsearch=textFieldKeyword.getText();
	    	count++;
	    	lastsearch.setDisable(false);
	    	refinebotton.setDisable(false);//basic5
    }
    //Basic 5 Refine search
    /**
     * This function will be called when "Refine" button is clicked and filter the searched data and keep those items 
     * with their titles containing the keywords typed in the text area.
     * @param event - The mouse click
     * @author yplamae
     */
    @FXML
    private void actionRefine(ActionEvent event) {
    	String keyword = textFieldKeyword.getText();
    	ObservableList<Item> items=FXCollections.observableArrayList();
    	List<Item> result = scraper.scrape(currentsearch);
    	String output = "";
    	for (Item item : result) {
    		if (item.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
    			output += item.getTitle() + "\t" + item.getPrice() + "\t" + item.getUrl() +"\t"+item.getPostdate()+ "\n";
    			item.setHyperlink(item.getUrl());
    			clickableURL(item.getHyperlink());
    			items.add(item);
    		}
    	}
    	showinfo(items);
    	textAreaConsole.setText(output);
    	refinebotton.setDisable(true);
    }
    
    //Basic 6 Last search
    /**
     * This function will be called when "Last Search" is clicked and will search the last keyword that user search.
     * @param event - The mouse click
     * @author cmleungah
     */
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
    /**
     * This function will be called when "About Your Team" is clicked and will display the information of our gropumates .
     * @param event - The mouse click
     * @author cmleungah
     */
    @FXML
    void ActionHelp(ActionEvent event) {
        alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("About your team");
    	alert.setHeaderText(null);
    	alert.setContentText("Name: Leung Chi Ming\nITSC:cmleungah@connect.ust.hk\nGithub:Dominic852\n\nName:Fok Chun Yin \nITSC: cyfok@connect.ust.hk \nGithub: cyfok4444\n\nName: Lam Yi Pan \nITSC: yplamae@connect.ust.hk\nGithub: lamyipan225");
    	alert.showAndWait();
    }
    //Basic 6,Quit the program
    /**
     * This function will be called when "Quit" is clicked and exit the program.
     * @param event - The mouse click
     * @author cmleungah
     */
    @FXML
    void ActionQuit(ActionEvent event) {
    	//mystage.close();
    	mystage.hide();
    }
    //Basic 6,Close the current search Record
    /**
     * This function will be called when "Close" is clicked and clear the current search record and initialize all tabs on the right to their initial stateh.
     * @param event - The mouse click
     * @author cmleungah
     */
    @FXML
    void ActionClose(ActionEvent event)throws Exception {
    	WebScraperApplication a =new WebScraperApplication();
    	a.start(mystage);
    }
}

