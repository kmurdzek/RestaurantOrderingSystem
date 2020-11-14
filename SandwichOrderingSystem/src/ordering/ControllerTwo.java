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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;


public class ControllerTwo implements Initializable {
	
	private ControllerOne controllerOne;
	@FXML
    private ListView<String> orderOutput;
	@FXML
	Button back, removeOrder, clearOrderButton, duplicateOrderButton, saveOrder;
	@FXML
	TextField orderTotal;
	
	ObservableList<String> orderStrings = FXCollections.observableArrayList();



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {	
		orderOutput.setItems(orderStrings);
		
		
	}

	void outputStuff(Order input) {
		
		for(int i =0; i<input.size();i++) {
			orderStrings.add(input.getOrder().get(i).toString());
		}
	}
	
	//Idk if this is how were supposed to do it made a controller instance variable It works tho
	public void setView1Controller(ControllerOne controllerOne) {
		this.controllerOne = controllerOne;
		calculateTotal();
	}
	
	@FXML
	void goBack(ActionEvent event) {
		Stage stage = (Stage) back.getScene().getWindow();
		stage.close();
	}
	
	@FXML 
	void removeOrder(ActionEvent event) {
		if(orderOutput.getSelectionModel().getSelectedItem()!=null) {
			int index =  orderStrings.indexOf(orderOutput.getSelectionModel().getSelectedItem());
			ArrayList<OrderLine> order = controllerOne.order.getOrderLines();
			OrderLine deleteThis = order.get(index);
			order.remove(index);
			for(int i = index; i<order.size(); i++) {
				OrderLine meal = order.get(i);
				meal.setLineNumber(i+1);
			}
			orderOutput.getItems().clear();
			outputStuff(controllerOne.order);
			calculateTotal();
		}
	}
	
	@FXML
	void duplicateOrder(ActionEvent event) {
		if(orderOutput.getSelectionModel().getSelectedItem()!=null) {
			int index =  orderStrings.indexOf(orderOutput.getSelectionModel().getSelectedItem());
			ArrayList<OrderLine> order = controllerOne.order.getOrderLines();
			OrderLine copyThis = order.get(index);
			int line = order.size()+1;
			
			if(copyThis.getSandwich() instanceof ChickenSandwich) {
				ChickenSandwich chicken = (ChickenSandwich) copyThis.getSandwich();
				OrderLine dup = new OrderLine(line, copyThis.getSandwich(), copyThis.getPrice()); 
				ArrayList<Extra> extras = copyThis.getSandwich().extras;
				chicken.extras = extras;
				controllerOne.order.add(dup);
			}else if (copyThis.getSandwich() instanceof BeefSandwich) {
				BeefSandwich beef = (BeefSandwich) copyThis.getSandwich();
				OrderLine dup = new OrderLine(line, copyThis.getSandwich(), copyThis.getPrice()); 
				ArrayList<Extra> extras = copyThis.getSandwich().extras;
				beef.extras = extras;
				controllerOne.order.add(dup);
				
			}else if(copyThis.getSandwich() instanceof FishSandwich) {
				FishSandwich fish = (FishSandwich) copyThis.getSandwich();
				OrderLine dup = new OrderLine(line, copyThis.getSandwich(), copyThis.getPrice()); 
				ArrayList<Extra> extras = copyThis.getSandwich().extras;
				fish.extras = extras;
				controllerOne.order.add(dup);
			}
			
			orderOutput.getItems().clear();
			outputStuff(controllerOne.order);
			calculateTotal();
		}
	}
	
	@FXML
	void clearOrder(ActionEvent event) {
		orderStrings.clear();
		controllerOne.order.getOrderLines().clear(); 
		calculateTotal();
	}
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
		
		for(int i =0; i<orderStrings.size();i++) {
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
	
	private void calculateTotal() {
		ArrayList<OrderLine> order = controllerOne.order.getOrderLines();
		DecimalFormat df = new DecimalFormat("#,###,##0.00");
		double totalPrice = 0;
		for(int i = 0; i<order.size();i++) {
			totalPrice += order.get(i).getPrice();
		}
		orderTotal.setText(df.format(totalPrice));
	}
	

	
	

}
