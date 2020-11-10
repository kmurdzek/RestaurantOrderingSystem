package ordering;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ControllerOne implements Initializable{
	
    @FXML
    private ComboBox<String> comboBox;
    
    @FXML
    private ImageView image;
    
    @FXML
    private ListView<String> includedIngredients, ingredientSelection, extraIngredients ;
    
	private static final Image chickenSandwich = new Image("chicken.jpg");
	private static final Image beefSandwich = new Image("beef.jpg");
	private static final Image fishSandwich = new Image("fish.jpg");
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		

		ObservableList<String> items = FXCollections.observableArrayList("Chicken", "Beef", "Fish");
		comboBox.setItems(items);
		comboBox.setValue("Chicken");
  	    ObservableList<String> chickenIngredients = FXCollections.observableArrayList("Chicken", "Spicy Sauce", "Pickles");
  	    ObservableList<String> ingredientSelect = FXCollections.observableArrayList("Bacon", "Cheddar", "Ketchup", "Lettuce",
  	    		 "Mayonaise", "Mushrooms", "Onion", "Peppers", "Spinach", "Tomatos");
  	    ingredientSelection.setItems(ingredientSelect);
  	    //shit doesnt work idk why no multiple select
  	    ingredientSelection.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
  	    includedIngredients.setItems(chickenIngredients);
		image.setImage(chickenSandwich);
		
	}
	
	@FXML
	void changeSandwich(ActionEvent event) {
        String value = comboBox.getValue(); 
        System.out.println(value);
        switch(value) {
        
        case "Chicken":
      	  	image.setImage(chickenSandwich);
      	    ObservableList<String> chickenIngredients = FXCollections.observableArrayList("Chicken", "Spicy Sauce", "Pickles");
      	    includedIngredients.setItems(chickenIngredients);
      	 break;
      	 
        case "Beef":
        	image.setImage(beefSandwich);
        	ObservableList<String> beefIngredients = FXCollections.observableArrayList("Roast Beef", "Provolone Cheese", "Mustard");
        	includedIngredients.setItems(beefIngredients);
        break;
        
        case "Fish":
        	image.setImage(fishSandwich);
        	ObservableList<String> fishIngredients = FXCollections.observableArrayList("Grilled Snapper", "Cilantro", "Lime");
        	includedIngredients.setItems(fishIngredients);
        break;
        }
	}
}
