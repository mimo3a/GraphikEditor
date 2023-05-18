package graphicEditor;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class FXMLController {
	@FXML
	private Canvas zeichenflaeche;
	@FXML
	private ColorPicker farbauswahl;

	private GraphicsContext gc;
	private int xPos, yPos;
	private int werkzeug;
	private Color farbe;

	@FXML
	protected void beendenKlick(ActionEvent event) {
		Platform.exit();
	}

	@FXML
	void initialize() {
		farbe = Color.BLACK;
		farbauswahl.setValue(farbe);
		werkzeug = 1;
		gc = zeichenflaeche.getGraphicsContext2D();

	}

	@FXML
	protected void linieKlick(ActionEvent event) {
		werkzeug = 1;

	}

	@FXML
	protected void kreisKlick(ActionEvent event) {
		werkzeug = 2;

	}

	@FXML
	protected void rechteckKlick(ActionEvent event) {
		werkzeug = 3;

	}

	@FXML
	protected void kreisFillKlick(ActionEvent event) {
		werkzeug = 4;
	}

	@FXML
	protected void mausGedrueck(MouseEvent event) {

		if (event.getButton() == MouseButton.PRIMARY) {
			xPos = (int) event.getX();
			yPos = (int) event.getY();

		}
	}

	@FXML
	protected void mouseLos(MouseEvent event) {
		if (event.getButton() == MouseButton.PRIMARY) {
//			die Linie
			if (werkzeug == 1) {
				linie((int) event.getX(), (int) event.getY());
			}
//			ein Kreiz
			if (werkzeug == 2) {
				kreis((int) (event.getX() - xPos), (int) (event.getY() - yPos));
			}

//			das Rechteck
			if (werkzeug == 3) {
				rechteck((int) (event.getX() - xPos), (int) (event.getY() - yPos));
			}
//			ein gefuelter Kreis
			if(werkzeug == 4) {
				kreisGefuellt((int)(event.getX()-xPos), (int)(event.getY()-yPos));
			}
			
		}
	}

	@FXML
	protected void farbAuswahlZeigen() {
		farbe = farbauswahl.getValue();
		gc.setStroke(farbe);
		zeichenflaeche.setCursor(null);
	}

//	die Methode zeichnet ein Rechteck
	protected void rechteck(int breite, int hoehe) {
		gc.strokeRect(xPos, yPos, breite, hoehe);
	}

//	die Methode zeichnet ein Kreis
	protected void kreis(int breite, int hoehe) {
		gc.strokeOval(xPos, yPos, breite, hoehe);
		
	}
	
//	die Methode zeichnet ein gefuellter Kreis
	protected void kreisGefuellt(int breite, int hoehe) {
		gc.setFill(farbe);
		gc.fillOval(xPos, yPos, breite, hoehe);
		
	}

//	die Methode zeichnet eine Linie
	protected void linie(int x2, int y2) {
		gc.strokeLine(xPos, yPos, x2, y2);
	}

}
