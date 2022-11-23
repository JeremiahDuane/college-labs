package gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * Public class Main is the central app launcher. Use to launch the Toy Inspection Program. 
 * @author 191852
 *
 */
public class Main extends Application {

	@Override
	public final void start(final Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/gui/view/text.fxml"));
		primaryStage.setTitle("Toy Inspection Software");
		primaryStage.setScene(new Scene(root));
		primaryStage.setResizable(false);
		primaryStage.show();
}

	/**
	 * Launches the program. 
	 *@param args the arguments that parameterize the methods. 
	 */
	public static void main(final String[] args) {
		launch(args);
	}
}

