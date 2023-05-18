package graphicEditor;



import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

public class MiniMal extends Application{

	@Override
	public void start(Stage meinStage) throws Exception {
		
		
		Parent rootNode = FXMLLoader.load(getClass().getResource("sb_minimal.fxml"));
		Scene meinScene = new Scene(rootNode, 800, 600);
		meinStage.setScene(meinScene);
		meinStage.setTitle("MiniMal");
		meinStage.show();
	}
	
		
		
	public static void main(String[] args) {
		launch(args);
	}

}
