package ordering;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * ControllerTwo class handles GUI functionality of the the customizable
 * sandwich order summary interface. This is the second of two controllers and
 * handles the ActionEvents of the order summary. This class makes it possible
 * to show an order,duplicate or remove a sandwich, and export an order to a
 * selected file.
 * 
 * @author Kacper Murdzek, Taranvir Singh
 *
 */
public class ControllerTwo implements Initializable {

	private ControllerOne controllerOne;
	@FXML
	private ListView<String> orderOutput;
	@FXML
	Button back, removeOrderButton, clearOrderButton, duplicateOrderButton, saveOrder;
	@FXML
	TextField orderTotal;

	ObservableList<String> orderStrings = FXCollections.observableArrayList();

	/**
	 * Initialize method that sets the ListView object to the order items.
	 * 
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		orderOutput.setItems(orderStrings);
	}

	/**
	 * outputOrder method takes an order and turns its sandwiches into strings. Adds
	 * the strings to an arrayList that stores the order as a string.
	 * 
	 * @param input order
	 */
	void outputOrder(Order input) {

		for (int i = 0; i < input.size(); i++) {
			orderStrings.add(input.getOrderLines().get(i).toString());
		}
	}

	/**
	 * setView1Controller method sets the ControllerOne instance variable in
	 * ControllerTwo class to the ControllerOne. Method makes data transfer possible
	 * between the two controllers.
	 * 
	 * @param controllerOne Controller
	 */
	public void setView1Controller(ControllerOne controllerOne) {
		this.controllerOne = controllerOne;
		calculateTotal();
	}

	/**
	 * 
	 * goBack method allows user to close the window without having to hit the X
	 * button. Gives the back button functionality.
	 * 
	 * @param event activated when button is clicked
	 */
	@FXML
	void goBack(ActionEvent event) {
		Stage stage = (Stage) back.getScene().getWindow();
		stage.close();
	}

	/**
	 * removeOrder method removes the selected order from the whole order. It then
	 * renumbers the orders numbers to the correct order. Gives the remove order
	 * line button functionality.
	 * 
	 * @param event activated when button is clicked
	 */
	@FXML
	void removeOrder(ActionEvent event) {
		if (orderOutput.getSelectionModel().getSelectedItem() != null) {

			int index = orderStrings.indexOf(orderOutput.getSelectionModel().getSelectedItem());
			ArrayList<OrderLine> order = controllerOne.order.getOrderLines();
			order.remove(index);

			for (int i = index; i < order.size(); i++) {
				OrderLine meal = order.get(i);
				meal.setLineNumber(i + 1);
			}

			orderOutput.getItems().clear();
			outputOrder(controllerOne.order);
			calculateTotal();
		}
	}

	/**
	 * duplicateOrder method duplicates the selected order and gives the order its
	 * own serial number. It then renumbers the orders to the correct order.
	 * 
	 * @param event activated when button is clicked
	 */
	@FXML
	void duplicateOrder(ActionEvent event) {
		if (orderOutput.getSelectionModel().getSelectedItem() != null) {

			int index = orderStrings.indexOf(orderOutput.getSelectionModel().getSelectedItem());
			ArrayList<OrderLine> order = controllerOne.order.getOrderLines();
			OrderLine orderLineToBeCopied = order.get(index);
			int line = order.size() + 1;

			if (orderLineToBeCopied.getSandwich() instanceof ChickenSandwich) {

				ChickenSandwich chicken = (ChickenSandwich) orderLineToBeCopied.getSandwich();
				OrderLine duplicate = new OrderLine(line, orderLineToBeCopied.getSandwich(),
						orderLineToBeCopied.getPrice());
				ArrayList<Extra> extras = orderLineToBeCopied.getSandwich().extras;
				chicken.extras = extras;
				controllerOne.order.add(duplicate);

			} else if (orderLineToBeCopied.getSandwich() instanceof BeefSandwich) {

				BeefSandwich beef = (BeefSandwich) orderLineToBeCopied.getSandwich();
				OrderLine duplicate = new OrderLine(line, orderLineToBeCopied.getSandwich(),
						orderLineToBeCopied.getPrice());
				ArrayList<Extra> extras = orderLineToBeCopied.getSandwich().extras;
				beef.extras = extras;
				controllerOne.order.add(duplicate);

			} else if (orderLineToBeCopied.getSandwich() instanceof FishSandwich) {

				FishSandwich fish = (FishSandwich) orderLineToBeCopied.getSandwich();
				OrderLine duplicate = new OrderLine(line, orderLineToBeCopied.getSandwich(),
						orderLineToBeCopied.getPrice());
				ArrayList<Extra> extras = orderLineToBeCopied.getSandwich().extras;
				fish.extras = extras;
				controllerOne.order.add(duplicate);
			}

			orderOutput.getItems().clear();
			outputOrder(controllerOne.order);
			calculateTotal();
		}
	}

	/**
	 * clearOrder method clears the whole order. Gives the clear order button
	 * functionality.
	 * 
	 * @param event activated when button is clicked
	 */
	@FXML
	void clearOrder(ActionEvent event) {

		orderStrings.clear();
		controllerOne.order.getOrderLines().clear();
		calculateTotal();
	}

	/**
	 * saveOrderToFile method writes the whole order to a specified file. When the
	 * order is successfully exported a window pops up to confirm. Gives the export
	 * order button functionality.
	 * 
	 * @param event activated when button is clicked
	 */
	@FXML
	void saveOrderToFile(ActionEvent event) {

		FileChooser chooser = new FileChooser();
		chooser.setTitle("Open Source File for the Import");
		chooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"),
				new ExtensionFilter("All Files", "*.*"));
		Stage stage = new Stage();
		File targetFile = chooser.showSaveDialog(stage);
		FileWriter document;

		try {

			document = new FileWriter(targetFile, true);

			for (int i = 0; i < orderStrings.size(); i++) {
				document.write(orderStrings.get(i));
				document.write("\n");
			}
			document.flush();
			document.close();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Success");
			alert.setHeaderText("File was successfully exported.");
			alert.setContentText("Congratulations!");
			alert.showAndWait();

		} catch (IOException e) {

		} catch (NullPointerException e) {

		}
	}

	/**
	 * calculateTotal method calculates the total of the order that is to displayed
	 * as the price. Price updates when orders are added and removed.
	 * 
	 */
	private void calculateTotal() {
		ArrayList<OrderLine> order = controllerOne.order.getOrderLines();
		DecimalFormat df = new DecimalFormat("#,###,##0.00");
		double totalPrice = 0;
		for (int i = 0; i < order.size(); i++) {
			totalPrice += order.get(i).getPrice();
		}
		orderTotal.setText(df.format(totalPrice));
	}
}
