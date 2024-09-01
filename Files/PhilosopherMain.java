
import javafx.application.Application;
	import javafx.fxml.FXMLLoader;
	import javafx.scene.Parent;
	import javafx.scene.Scene;
	import javafx.stage.Stage;


	public class PhilosopherMain extends Application{ 
		
		public void start(Stage stage) throws Exception{ 
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("PhilosopherMain.fxml")); 
			Scene scene = new Scene(root); 
			stage.setTitle("PhilosopherMain"); 
			stage.setScene(scene); 
			stage.show(); 
		} 
		
		public static void main(String[] args) { 
			launch(args); 
			System.out.println();
		} 
	}


