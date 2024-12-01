package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import factory.Creator;
import factory.Product;
import factory.ConcreteCreatorAB;;

public class FahrradModel {
	private Fahrrad fahrrad;
	
	 public Fahrrad getFahrrad() {
		return fahrrad;
	}
	public void setFahrrad(Fahrrad fahrrad) {
		this.fahrrad = fahrrad;
	}


	public void schreibeFahrradInCsvDatei() throws IOException{
		    BufferedWriter aus = new BufferedWriter(new FileWriter("FahrradAusgabe.csv", false));
		   	aus.write(this.fahrrad.gibFahrradZurueck(';'));
		    aus.close();
	 	}
	
	public void leseAusDatei(String typ) throws IOException {
		
		Creator creator = new ConcreteCreatorAB();
		Product reader = creator.factoryMethod(typ);
		
		String [] zeile = reader.leseAusDatei();
		
		this.fahrrad = new Fahrrad(zeile[0], Float.parseFloat(zeile[1]), zeile[2], Float.parseFloat(zeile[3]), zeile[4].split("_"));
		
		reader.schliesseDatei();
		
//		if ("csv".equals(typ)) {
//			BufferedReader ein = new BufferedReader(new FileReader("FahrradAusgabe.csv"));
//			String[] zeile = ein.readLine().split(";");
//			this.fahrrad = new Fahrrad(zeile[0], Float.parseFloat(zeile[1]), zeile[2], Float.parseFloat(zeile[3]), zeile[4].split(";"));
//			ein.close();
//		}
	}

}
