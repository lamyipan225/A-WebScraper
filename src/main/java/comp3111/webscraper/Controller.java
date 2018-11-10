/**
 * 
 */
package comp3111.webscraper;


import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;//for basic 4
import javafx.scene.control.TableView;//basic 4
import javafx.scene.control.cell.PropertyValueFactory;//basic 4
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.util.List;
import javafx.collections.*;//basic 4
import javafx.event.ActionEvent;//basic 4
import javafx.event.EventHandler;//basic 4
import javafx.application.Application;//basic 4
import javafx.stage.Stage;


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
    
  
    
  //A list to use to store the item,pass this to the showinfo function basic 4
    private WebScraper scraper;
    //please call this function when searching items using basic search or refine search,basic 4
    public void showinfo(ObservableList<Item> items){
    	titlecol.setCellValueFactory(new PropertyValueFactory<>("title"));
    	pricecol.setCellValueFactory(new PropertyValueFactory<>("price"));
    	urlcol.setCellValueFactory(new PropertyValueFactory<>("hyperlink"));
    	postcol.setCellValueFactory(new PropertyValueFactory<>("postdate"));
    	table.setItems(items);	
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
    		//this is for basic 4. To make the URL clickable to open a webpage
    		item.setHyperlink(item.getUrl());
    		item.getHyperlink().setOnAction(new EventHandler<ActionEvent>() {
    			Application a = new Application() {

                    @Override
                    public void start(Stage stage)
                    {
                    }
                };
                @Override
                public void handle(ActionEvent t) {
    				a.getHostServices().showDocument(item.getHyperlink().getText());
                }
    		});
    		////////////////////////////////////////////////
    		items.add(item);//basic 4
    	}
    	showinfo(items);//basic 4
    	textAreaConsole.setText(output);

  
    }
    
    /**
     * Called when the new button is pressed. Very dummy action - print something in the command prompt.
     */
    @FXML
    private void actionNew() {
    	System.out.println("actionNew");
    }
}

