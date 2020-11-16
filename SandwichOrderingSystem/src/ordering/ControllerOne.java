package ordering;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * ControllerOne class handles GUI functionality of the the customizable
 * sandwich interface. This class gives users functionality to create a Chicken,
 * Beef, or Fish sandwich, with up to six extra ingredients along with the three
 * base ingredients of each sandwich. ControllerOne is capable of adding and
 * removing ingredients from a sandwich as well as completing and showing an
 * order. Price for the sandwich is automatically updated when ingredients are
 * added and removed. When sandwich is complete, user can add it to the order
 * and show the order or can continue to make and add sandwiches.
 * 
 * @author Kacper Murdzek, Taranvir Singh
 *
 */
public class ControllerOne implements Initializable {

	Order order = new Order();

	@FXML
	private Button addSelected, clearButton, showOrder;
	@FXML
	private ComboBox<String> comboBox;

	@FXML
	private ImageView image;

	@FXML
	private TextField priceDisplay;

	@FXML
	private ListView<String> includedIngredients, ingredientSelection, extraIngredients;

	private static final Image chickenSandwich = new Image("chicken.jpg");
	private static final Image beefSandwich = new Image("beef.jpg");
	private static final Image fishSandwich = new Image("fish.jpg");

	ObservableList<String> ingredientSelect = FXCollections.observableArrayList();
	ObservableList<String> extrasSelected = FXCollections.observableArrayList();

	/**
	 * sendToView2 method is activated when user wants to show the order. The method
	 * takes the order and displays it in a new window, from there the order can be
	 * modified by duplicating or removing orders. Method gives the Show Order
	 * button functionality.
	 * 
	 * @param event on action button clicked
	 */
	@FXML
	void sendToView2(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewTwo.fxml"));
			Parent root = (Parent) loader.load();
			ControllerTwo controller2 = loader.getController();
			controller2.setView1Controller(this);
			Scene newScene = new Scene(root);
			Stage newStage = new Stage();
			newStage.setScene(newScene);
			newStage.setTitle("Order Summary");
			newStage.show();

			controller2.outputOrder(order);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * initialize method sets the display for the user interface. Method allows user
	 * to see data on the interface.
	 * 
	 * @param URL, ResourceBundle
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		ObservableList<String> items = FXCollections.observableArrayList("Chicken", "Beef", "Fish");
		comboBox.setItems(items);
		comboBox.setValue("Chicken");
		ObservableList<String> chickenIngredients = FXCollections.observableArrayList("Chicken", "Spicy Sauce",
				"Pickles");
		includedIngredients.setItems(chickenIngredients);
		image.setImage(chickenSandwich);
		setThePrice();

		for (Extra ingredients : Extra.values()) {
			ingredientSelect.add(ingredients.toString());
		}

		ingredientSelect.setAll(ingredientSelect.sorted());
		ingredientSelection.setItems(ingredientSelect);
		extraIngredients.setItems(extrasSelected);

	}

	/**
	 * addToOrder method is adds the created sandwich to the whole order with
	 * selected ingredients. Method adds the order to a list of orders based on user
	 * input. Gives the add to order button functionality.
	 * 
	 * @param event
	 */
	@FXML
	void addToOrder(ActionEvent event) {

		String value = comboBox.getValue();
		OrderLine orderLine;
		switch (value) {

		case "Chicken":

			ChickenSandwich chickenSandwich = new ChickenSandwich();
			for (int i = 0; i < extrasSelected.size(); i++) {
				chickenSandwich.add(extrasSelected.get(i));
			}

			orderLine = new OrderLine(order.size() + 1, chickenSandwich, chickenSandwich.price());
			order.add(orderLine);

			break;

		case "Beef":
			BeefSandwich beefSandwich = new BeefSandwich();
			for (int i = 0; i < extrasSelected.size(); i++) {
				beefSandwich.add(extrasSelected.get(i));
			}

			orderLine = new OrderLine(order.size() + 1, beefSandwich, beefSandwich.price());
			order.add(orderLine);
			break;

		case "Fish":
			FishSandwich fishSandwich = new FishSandwich();
			for (int i = 0; i < extrasSelected.size(); i++) {
				fishSandwich.add(extrasSelected.get(i));
			}

			orderLine = new OrderLine(order.size() + 1, fishSandwich, fishSandwich.price());
			order.add(orderLine);
			break;
		}
		ingredientSelect.addAll(extrasSelected);
		ingredientSelect.setAll(ingredientSelect.sorted());
		extrasSelected.clear();
		setThePrice();
	}

	/**
	 * changeSandwich method changes the view for each type of sandwich that the
	 * user selects. Resets the ingredients selected as well as changes the sandwich
	 * picture. Method is dependent on what is selected on the comboBox.
	 * 
	 * @param event sandwich is changed.
	 */
	@FXML
	void changeSandwich(ActionEvent event) {
		ingredientSelect.addAll(extrasSelected);
		ingredientSelect.setAll(ingredientSelect.sorted());
		extrasSelected.clear();
		setThePrice();
		String value = comboBox.getValue();
		switch (value) {

		case "Chicken":
			image.setImage(chickenSandwich);

			ObservableList<String> chickenIngredients = FXCollections.observableArrayList("Chicken", "Spicy Sauce",
					"Pickles");
			includedIngredients.setItems(chickenIngredients);
			setThePrice();
			break;

		case "Beef":
			image.setImage(beefSandwich);

			ObservableList<String> beefIngredients = FXCollections.observableArrayList("Roast Beef", "Provolone Cheese",
					"Mustard");
			includedIngredients.setItems(beefIngredients);
			setThePrice();
			break;

		case "Fish":
			image.setImage(fishSandwich);

			ObservableList<String> fishIngredients = FXCollections.observableArrayList("Grilled Snapper", "Cilantro",
					"Lime");
			includedIngredients.setItems(fishIngredients);
			setThePrice();
			break;
		}
	}

	/**
	 * addToExtra method adds the selected ingredient to the ingredients included in
	 * the sandwich. Method also takes out the ingredient from the ingredient
	 * selection. Makes the add selected button functional.
	 * 
	 * @param event ingredient selected and added
	 */
	@FXML
	void addtoExtra(ActionEvent event) {
		if (ingredientSelection.getSelectionModel().getSelectedItem() != null
				&& !extrasSelected.contains(ingredientSelection.getSelectionModel().getSelectedItem())) {

			if (extrasSelected.size() < Sandwich.MAX_EXTRAS) {

				extrasSelected.add(ingredientSelection.getSelectionModel().getSelectedItem());
				ingredientSelect.remove(ingredientSelection.getSelectionModel().getSelectedItem());
				setThePrice();

			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Invalid");
				alert.setHeaderText("Too Many Extra Ingredients");
				alert.setContentText("No more than six ingredients can be added");
				alert.showAndWait();
			}
		}
	}

	/**
	 * removeExtra method removes the selected extra ingredient from the ingredients
	 * included list view. Method makes it possible to remove an ingredient that has
	 * been added, when an extra is removed, it is added back to the ingredient
	 * selection list view.
	 * 
	 * @param event ingredient selected and removed
	 */
	@FXML
	void removeExtra(ActionEvent event) {
		if (extraIngredients.getSelectionModel().getSelectedItem() != null
				&& extrasSelected.contains(extraIngredients.getSelectionModel().getSelectedItem())) {

			ingredientSelect.add(extraIngredients.getSelectionModel().getSelectedItem());
			extrasSelected.remove(extraIngredients.getSelectionModel().getSelectedItem());
			ingredientSelect.setAll(ingredientSelect.sorted());
			setThePrice();
		}

	}

	/**
	 * setThePrice method sets the price of the sandwich so user is aware of
	 * sandwich costs. As ingredients are added and removed prices are changed
	 * accordingly.
	 * 
	 */
	@FXML
	void setThePrice() {
		int size = extrasSelected.size();
		DecimalFormat df = new DecimalFormat("#,###,##0.00");
		if (comboBox.getValue().equals("Chicken")) {
			double price = 8.99 + size * 1.99;
			priceDisplay.setText(String.valueOf(df.format(price)));
		} else if (comboBox.getValue().equals("Beef")) {
			double price = 10.99 + size * 1.99;
			priceDisplay.setText(String.valueOf(df.format(price)));
		} else {
			double price = 12.99 + size * 1.99;
			priceDisplay.setText(String.valueOf(df.format(price)));
		}
	}

	/**
	 * clearAll method clears all the ingredients from the ingredients selected list
	 * view.
	 * 
	 * @param event
	 */
	@FXML
	void clearAll(ActionEvent event) {
		ingredientSelect.addAll(extrasSelected);
		ingredientSelect.setAll(ingredientSelect.sorted());
		extrasSelected.clear();

		setThePrice();
	}

}
