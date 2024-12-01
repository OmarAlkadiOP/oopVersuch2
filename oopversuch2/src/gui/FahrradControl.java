package gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import business.Fahrrad;
import business.FahrradModel;
import javafx.stage.Stage;

public class FahrradControl {
	private FahrradView fahrradView;
	private FahrradModel fahrradModel;
	private Fahrrad fahrrad;
	
	public FahrradControl(Stage primaryStage) {
		this.fahrradModel = new FahrradModel();
		this.fahrradView = new FahrradView(this, primaryStage, fahrradModel);
	}
	public void nehmeFahrradAuf(){
    	try{
    		this.fahrradModel.setFahrrad(new Fahrrad(
    			fahrradView.getTxtName().getText(), 
   	            Float.parseFloat(fahrradView.getTxtRahmennummer().getText()),
   	            fahrradView.getTxtDhk().getText(),
   	            Float.parseFloat(fahrradView.getTxtFahrradtyp().getText()),
   	         	fahrradView.getTxtVorhandeneGroessen().getText().split(";")));
    			fahrradView.zeigeInformationsfensterAn("Das Fahrrad wurde aufgenommen!");
       	}
       	catch(Exception exc){
       		fahrradView.zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
    }

	public void leseAusDatei(String typ) {
		try {
			this.fahrradModel.leseAusDatei(typ);
			this.fahrradView.zeigeInformationsfensterAn("Fahrrad wurde aufgenommen");
		} catch (IOException exc) {
			this.fahrradView.zeigeFehlermeldungsfensterAn("IOException beim Lesen!");
		} catch (Exception exc) {
			this.fahrradView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Lesen!" + exc.getMessage());
			// exc.printStackTrace(); // Detaillierte Ausgabe des Fehlers in der Konsole
		}
	}

	public void schreibeFahrradInCsvDatei() {
		try {
			this.fahrradModel.schreibeFahrradInCsvDatei();
			this.fahrradView.zeigeInformationsfensterAn("Das Fahrrad wurden gespeichert!");
		} catch (IOException exc) {
			this.fahrradView.zeigeFehlermeldungsfensterAn("IOException beim Speichern!");
		} catch (Exception exc) {
			this.fahrradView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!");
		}
	}
    
	
	
	
}
