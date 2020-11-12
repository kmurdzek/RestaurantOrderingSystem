package ordering;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ControllerOne implements Initializable {

	@FXML
	private Button addSelected, clearButton;
	@FXML
	private ComboBox<String> comboBox;

	@FXML
	private ImageView image;
	

	@FXML
	private ListView<String> includedIngredients,ingredientSelection, extraIngredients;

	private static final Image chickenSandwich = new Image("chicken.jpg");
	private static final Image beefSandwich = new Image("beef.jpg");
	private static final Image fishSandwich = new Image("fish.jpg");

	ObservableList<String> ingredientSelect=FXCollections.observableArrayList();
	ObservableList<String> extrasSelected = FXCollections.observableArrayList();
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		//Intializes the display to start off with chicken as the selected item
		ObservableList<String> items = FXCollections.observableArrayList("Chicken", "Beef", "Fish");
		comboBox.setItems(items);
		comboBox.setValue("Chicken");
		ObservableList<String> chickenIngredients = FXCollections.observableArrayList("Chicken", "Spicy Sauce",
				"Pickles");
		includedIngredients.setItems(chickenIngredients);
		image.setImage(chickenSandwich);
		
	
		ingredientSelect.addAll("Bacon", "Cheddar", "Ketchup", "Lettuce", "Mayonaise",
						"Mushrooms", "Onion", "Peppers", "Spinach", "Tomatos");
		
		ingredientSelection.setItems(ingredientSelect);
		extraIngredients.setItems(extrasSelected);
		
		// this works when you press ctrl and select and item but it doesnt seem to work properly 
		//so lets jus ignore it for now
		//ingredientSelection.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

	}

	@FXML
	void changeSandwich(ActionEvent event) {
		String value = comboBox.getValue();
		//System.out.println(value);
		switch (value) {

		case "Chicken":
			image.setImage(chickenSandwich);
			
			ObservableList<String> chickenIngredients = FXCollections.observableArrayList("Chicken", "Spicy Sauce",
					"Pickles");
			includedIngredients.setItems(chickenIngredients);
			
			//includedIngredients.setText("Chicken\nSpicy Sauce\nPickles");
			break;

		case "Beef":
			image.setImage(beefSandwich);
			
			ObservableList<String> beefIngredients = FXCollections.observableArrayList("Roast Beef", "Provolone Cheese",
					"Mustard");
			includedIngredients.setItems(beefIngredients);
			
			//includedIngredients.setText("Roast Beef\nProvolone Cheese\nMustard");
			break;

		case "Fish":
			image.setImage(fishSandwich);
			
			ObservableList<String> fishIngredients = FXCollections.observableArrayList("Grilled Snapper", "Cilantro",
					"Lime");
			includedIngredients.setItems(fishIngredients);
			
			//includedIngredients.setText("Grilled Snapper\nCilantro\nLime");
			break;
		}
	}

	@FXML
	void addtoExtra(ActionEvent event) {
		if (extrasSelected.contains(ingredientSelection.getSelectionModel().getSelectedItem()) != true) {
			extrasSelected.add(ingredientSelection.getSelectionModel().getSelectedItem());
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Invalid");
			alert.setHeaderText("Duplicate Selection");
			alert.setContentText("This item has already been added");
			alert.showAndWait();
		}
	}

	@FXML
	void removeExtra(ActionEvent event) {
		extrasSelected.remove(extraIngredients.getSelectionModel().getSelectedItem());
		//System.out.println(extraIngredients.getItems());
	}

	@FXML
	void clearAll(ActionEvent event) {
		extrasSelected.clear();
	}
	
}
