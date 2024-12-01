
package gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import business.Fahrrad;
import business.FahrradModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class FahrradView {
	private FahrradControl fahrradControl;
	private FahrradModel fahrradModel;
	private Fahrrad fahrrad;
	
	private Pane pane     					= new  Pane();
	private Label lblEingabe    	 		= new Label("Eingabe");
    private Label lblAnzeige   	 	    	= new Label("Anzeige");
    private Label lblName 					= new Label("Name:");
    private Label lblRahmennummer   			= new Label("Rahmennummer:");
    private Label lblDhk  	 			= new Label("Dhk:");
    private Label lblFahrradtyp   				= new Label("Fahrradtyp");
    private Label lblVorhandeneGroessen   			= new Label("VorhandeneGroessen :");
    private TextField txtName 	 			= new TextField();
    private TextField txtRahmennummer			= new TextField();
    private TextField txtDhk				= new TextField();
    private TextField txtFahrradtyp				= new TextField();
    private TextField txtVorhandeneGroessen 		= new TextField();
    private TextArea txtAnzeige  			= new TextArea();
    private Button btnEingabe 		 		= new Button("Eingabe");
    private Button btnAnzeige 		 		= new Button("Anzeige");
    private MenuBar mnbrMenuLeiste  		= new MenuBar();
    private Menu mnDatei             		= new Menu("Datei");
    private MenuItem mnItmCsvImport 		= new MenuItem("csv-Import");
    private MenuItem mnItmTxtImport 		= new MenuItem("txt-Import");
    private MenuItem mnItmCsvExport 		= new MenuItem("csv-Export");    
	
    public FahrradView(FahrradControl fahrradControl, Stage primaryStage, FahrradModel fahrradModel) {
    	this.fahrradControl = fahrradControl;	    	
     	this.fahrradModel = fahrradModel;
    	Scene scene = new Scene(this.pane, 700, 340);
	   	primaryStage.setScene(scene);
	   	primaryStage.setTitle("Verwaltung von Fahrrad");
	   	primaryStage.show();
		this.initKomponenten();
		this.initListener();
	}
    
	public Label getLblEingabe() {
		return lblEingabe;
	}
	public void setLblEingabe(Label lblEingabe) {
		this.lblEingabe = lblEingabe;
	}
	public Label getLblAnzeige() {
		return lblAnzeige;
	}
	public void setLblAnzeige(Label lblAnzeige) {
		this.lblAnzeige = lblAnzeige;
	}
	public TextField getTxtName() {
		return txtName;
	}
	public void setTxtName(TextField txtName) {
		this.txtName = txtName;
	}
	public TextField getTxtRahmennummer() {
		return txtRahmennummer;
	}
	public void setTxtRahmennummer(TextField txtRahmennummer) {
		this.txtRahmennummer = txtRahmennummer;
	}
	public TextField getTxtDhk() {
		return txtDhk;
	}
	public void setTxtDhk(TextField txtDhk) {
		this.txtDhk = txtDhk;
	}
	public TextField getTxtFahrradtyp() {
		return txtFahrradtyp;
	}
	public void setTxtFahrradtyp(TextField txtFahrradtyp) {
		this.txtFahrradtyp = txtFahrradtyp;
	}
	public TextField getTxtVorhandeneGroessen() {
		return txtVorhandeneGroessen;
	}
	public void setTxtVorhandeneGroessen(TextField txtVorhandeneGroessen) {
		this.txtVorhandeneGroessen = txtVorhandeneGroessen;
	}
	
	private void initKomponenten(){
       	// Labels
    	lblEingabe.setLayoutX(20);
    	lblEingabe.setLayoutY(40);
    	Font font = new Font("Arial", 24); 
    	lblEingabe.setFont(font);
    	lblEingabe.setStyle("-fx-font-weight: bold;"); 
    	lblAnzeige.setLayoutX(400);
    	lblAnzeige.setLayoutY(40);
      	lblAnzeige.setFont(font);
       	lblAnzeige.setStyle("-fx-font-weight: bold;"); 
       	lblName.setLayoutX(20);
    	lblName.setLayoutY(90);
    	lblRahmennummer.setLayoutX(20);
    	lblRahmennummer.setLayoutY(130);
    	lblDhk.setLayoutX(20);
    	lblDhk.setLayoutY(170);
    	lblFahrradtyp.setLayoutX(20);
    	lblFahrradtyp.setLayoutY(210);
    	lblVorhandeneGroessen .setLayoutX(20);
    	lblVorhandeneGroessen .setLayoutY(250);    	
       	pane.getChildren().addAll(lblEingabe, lblAnzeige, 
       		lblName, lblRahmennummer, lblDhk,
       		lblFahrradtyp, lblVorhandeneGroessen );
    
    	// Textfelder
     	txtName.setLayoutX(170);
    	txtName.setLayoutY(90);
    	txtName.setPrefWidth(200);
    	txtRahmennummer.setLayoutX(170);
    	txtRahmennummer.setLayoutY(130);
    	txtRahmennummer.setPrefWidth(200);
    	txtDhk.setLayoutX(170);
    	txtDhk.setLayoutY(170);
    	txtDhk.setPrefWidth(200);
      	txtFahrradtyp.setLayoutX(170);
    	txtFahrradtyp.setLayoutY(210);
    	txtFahrradtyp.setPrefWidth(200);
    	txtVorhandeneGroessen .setLayoutX(170);
    	txtVorhandeneGroessen .setLayoutY(250);
    	txtVorhandeneGroessen .setPrefWidth(200);
      	pane.getChildren().addAll( 
     		txtName, txtRahmennummer, txtDhk,
     		txtFahrradtyp, txtVorhandeneGroessen );
     	
        // Textbereich	
        txtAnzeige.setEditable(false);
     	txtAnzeige.setLayoutX(400);
    	txtAnzeige.setLayoutY(90);
     	txtAnzeige.setPrefWidth(270);
    	txtAnzeige.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeige); 
       	
        // Buttons
        btnEingabe.setLayoutX(20);
        btnEingabe.setLayoutY(290);
        btnAnzeige.setLayoutX(400);
        btnAnzeige.setLayoutY(290);
        pane.getChildren().addAll(btnEingabe, btnAnzeige); 
        
 		// Menue
  	    this.mnbrMenuLeiste.getMenus().add(mnDatei);
  	    this.mnDatei.getItems().add(mnItmCsvImport);
  	    this.mnDatei.getItems().add(mnItmTxtImport);
  	    this.mnDatei.getItems().add(new SeparatorMenuItem());
  	    this.mnDatei.getItems().add(mnItmCsvExport);
 	    pane.getChildren().add(mnbrMenuLeiste);
   }
   
	private void initListener() {
		btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				fahrradControl.nehmeFahrradAuf();
			}
		});
		btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				zeigeFahrradAn();
			}
		});
		mnItmCsvImport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				fahrradControl.leseAusDatei("csv");	
			}
		});
		mnItmTxtImport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
			    fahrradControl.leseAusDatei("txt");
			}
		});
		mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				fahrradControl.schreibeFahrradInCsvDatei();
			}
		});
	}
   private void zeigeFahrradAn() {
		if (this.fahrradModel.getFahrrad() != null) {
			txtAnzeige.setText(this.fahrradModel.getFahrrad().gibFahrradZurueck(' '));
		} else {
			zeigeInformationsfensterAn("Bisher wurde kein Fahrrad aufgenommen!");
		}
	}
   public void zeigeInformationsfensterAn(String meldung){
	   	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
	   		"Information", meldung).zeigeMeldungsfensterAn();
	   }	
	   
	   public void zeigeFehlermeldungsfensterAn(String meldung){
	      	new MeldungsfensterAnzeiger(AlertType.ERROR,
	       	"Fehler", meldung).zeigeMeldungsfensterAn();
	   }
   private void schreibeFahrradInCsvDatei() {
		try {
			BufferedWriter aus = new BufferedWriter(new FileWriter("FahrradsAusgabe.csv", true));
			aus.write(fahrrad.gibFahrradZurueck(';'));
			aus.close();
			zeigeInformationsfensterAn("Die Fahrraeder wurden gespeichert!");
		} catch (IOException exc) {
			zeigeFehlermeldungsfensterAn("IOException beim Speichern!");
		} catch (Exception exc) {
			zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!");
		}
	}
 
  
   private void leseAusDatei(String typ) {
		try {
			if ("csv".equals(typ)) {
				BufferedReader ein = new BufferedReader(new FileReader("Fahrrad.csv"));
				String[] zeile = ein.readLine().split(";");
				this.fahrrad = new Fahrrad(zeile[0], Float.parseFloat(zeile[1]), zeile[2], Float.parseFloat(zeile[3]), zeile[4].split("_"));
				ein.close();
				zeigeInformationsfensterAn("Die Fahrraeder wurden gelesen!");
			} else {
				zeigeInformationsfensterAn("Noch nicht implementiert!");
			}
		} catch (IOException exc) {
			zeigeFehlermeldungsfensterAn("IOException beim Lesen!");
		} catch (Exception exc) {
			zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Lesen!");
		}
	}
	
	
}
