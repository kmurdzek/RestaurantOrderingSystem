package ordering;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

	/**
	 * Main class sets the dimensions of the BorderPane and the characteristics.
	 * Main class is the running class of the project.
	 * 
	 * @author Kacper Murdzek, Taranvir Singh
	 *
	 */
	public class Main extends Application {

		/**
		 * Start Method starts the GUI, and sets it's characteristics.
		 * 
		 */
		@Override
		public void start(Stage primaryStage) {
			try {
				BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("ViewOne.fxml"));
				Scene scene = new Scene(root, 838, 541);
				primaryStage.setScene(scene);
				primaryStage.show();
				primaryStage.setTitle("Sandwich Order");

				
			} catch (Exception e) {
				e.printStackTrace();

			}
		}

		/**
		 * Main method launches the GUI.
		 * 
		 * @param args
		 */
		public static void main(String[] args) {
			launch(args);
		}
	}

