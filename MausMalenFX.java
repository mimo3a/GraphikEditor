package graphicEditor;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class MausMalenFX extends Application {

	private int xPos, yPos;

	@Override
	public void start(Stage meinStage) throws Exception {

		FlowPane rootNode = new FlowPane();
		Canvas meinCanvas = new Canvas(400, 400);
		rootNode.getChildren().add(meinCanvas);
		GraphicsContext gc = meinCanvas.getGraphicsContext2D();

		meinCanvas.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (event.getButton() == MouseButton.PRIMARY) {
					xPos = (int) event.getX();
					yPos = (int) event.getY();

				}

			}
		});

		meinCanvas.setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {

				if (event.getButton() == MouseButton.PRIMARY) {

					gc.strokeLine(xPos, yPos, event.getX(), event.getY());
				}

			}
		});

		Scene meinScene = new Scene(rootNode, 400, 400);
		meinStage.setTitle("Ein sehr anfaches Malprogramm");
		meinStage.setScene(meinScene);
		meinStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
