package root;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class AufgabenManager {
	
	private final String aufgabendateiname = "." + File.separator +"aufgaben.dat";
	private File aufgabendatei;
	
	private Aufgabe[] aufgaben;
	private Aufgabe[] aufgabenCurrentRound;
	private int currentAufgabe;
	
	public AufgabenManager()  {
		currentAufgabe = 0;
		aufgaben = new Aufgabe[100];
		
		//Aufgaben laden
		aufgabendatei = new File(aufgabendateiname);
		
		if(!aufgabendatei.exists()) {
			try {
				aufgabendatei.createNewFile();
				generateAufgaben();
				saveAufgaben();
			} catch (IOException e) {}
		} else {
			loadAufgaben();
		}
		
	}
	
	//Wenn Aufgabendatei noch nicht existiert, müssen die Aufgaben einmalig generiert werden
	private void generateAufgaben() {
		int aufgabenNr = 0;
		
		for(int fn = 1; fn <= 10; fn++) {
			for(int sn = 11; sn <= 20; sn++) {
				aufgaben[aufgabenNr] = new Aufgabe(fn, sn); //Standardschwierigkeit 0
				aufgabenNr += 1;
			}
		}
	}
	
	//Alle Aufgaben im aufgaben-Array in aufgaben.dat abspeichern
	private void saveAufgaben() {
		PrintWriter out = null;
		
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter(aufgabendatei)));
			for(Aufgabe a : aufgaben) {
				out.println(a.getFirstNumber() + ";" + a.getSecondNumber() + ";" + a.getDifficulty());
			}
		} catch (IOException e) {}
		finally {
			if(out != null) {
				out.close();
			}
		}
	}
	
	//Einlesen und Erzeugen der Aufgaben des aufgaben-Arrays durch einlesen von aufgaben.dat
	private void loadAufgaben() {
		BufferedReader in = null;
		String zeile;
		int aufgabenNr = 0;
		
		try {
			in = new BufferedReader(new FileReader(aufgabendatei));
			while((zeile = in.readLine()) != null) {
				
				//Werte aus Zeile auslesen
				int faktor1 = Integer.parseInt( zeile.substring(0, zeile.indexOf(";")) );
				zeile = zeile.substring(zeile.indexOf(";") + 1);
				int faktor2 = Integer.parseInt( zeile.substring(0, zeile.indexOf(";")) );
				zeile = zeile.substring(zeile.indexOf(";") + 1);
				int difficulty = Integer.parseInt(zeile);
				
				//In Aufgabe abspeichern
				aufgaben[aufgabenNr] = new Aufgabe(faktor1, faktor2, difficulty);
				aufgabenNr++;
			}
			
		} catch (IOException e) {}
		finally {
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {}
			}
		}
	}
	
	//Aufgaben für aktuelle Runde wählen
	private void chooseAufgaben(int anzahl) {
		//Arrays für  Schwierigkeitsstufen
		ArrayList<Aufgabe> level0 = new ArrayList<Aufgabe>();
		ArrayList<Aufgabe> level1 = new ArrayList<Aufgabe>();
		ArrayList<Aufgabe> level2 = new ArrayList<Aufgabe>();
		
		//Zuweisung der Aufgaben zu den jeweiligen Schwierigkeitsstufen
		
		for(int i = 0; i < aufgaben.length; i++) {
			Aufgabe currentAufgabe = aufgaben[i];
			
			switch(currentAufgabe.getDifficulty()) {
				case 0:
					level0.add(currentAufgabe);
					break;
				case 1:
					level1.add(currentAufgabe);
					break;
				case 2:
					level2.add(currentAufgabe);
					break;
			}
		}
		
		//Prozentsatz der Aufgaben einer gewissen Schwierigkeitsstufe an der Gesamtaufgabenzahl festlegen
		double percentage0 = 0.25;
		double percentage1 = 0.35;
		double percentage2 = 0.40;
		
		//tatsächliche Anzahl der Aufgaben einer gewissen Schwierigkeitsstufe an der Gesamtaufgabenzahl festlegen
		int ueberschuessigeAufgaben = 0;
		int vorgesehen;
		
		//Anzahl Schwierigkeit 2
		int anzahl2;
		vorgesehen = (int) Math.round(anzahl * percentage2);
		if(vorgesehen <= level2.size()) {
			anzahl2 = vorgesehen;
		} else {
			anzahl2 = level2.size();
			System.out.println(anzahl2);
			ueberschuessigeAufgaben = vorgesehen - anzahl2;
		}
		//Anzahl Schwierigkeit 1
		int anzahl1;
		vorgesehen = (int) Math.round(anzahl * percentage1) + ueberschuessigeAufgaben;
		if(vorgesehen <= level1.size()) {
			anzahl1 = vorgesehen;
		} else {
			anzahl1 = level1.size();
			ueberschuessigeAufgaben = vorgesehen - anzahl1;
		}
		
		//Anzahl Schwierigkeit 1
		int anzahl0 = ueberschuessigeAufgaben;
		
		
		//aufgabenCurrentRound Aufgaben je nach Anzahl zuweisen
		for(int i = 0; i < anzahl; i++) {
			Random r = new Random();
			int randomInt;

			if(i < anzahl2 && anzahl2 > 0) {
				randomInt = r.nextInt(level2.size());
				if(randomInt != 0 )
					randomInt--;
				aufgabenCurrentRound[i] = level2.get(randomInt);
			} else if( (i < anzahl1 + anzahl2) && (anzahl1 > 0) ) {
				randomInt = r.nextInt(level1.size());
				if(randomInt != 0 )
					randomInt--;
				aufgabenCurrentRound[i] = level1.get(randomInt);
			} else {
				randomInt = r.nextInt(level0.size());
				if(randomInt != 0 )
					randomInt--;
				aufgabenCurrentRound[i] = level0.get(randomInt);
			}
			
			
		}
	}

	private void mixExercises(Aufgabe[] aufgaben) {
		Random r = new Random();
		Aufgabe[] swappies = new Aufgabe[2];
		
		for(int i = 0; i <= aufgaben.length; i++) {
			int n1 = r.nextInt(aufgaben.length-1);
			int n2 = r.nextInt(aufgaben.length-1);
			
			swappies[0] = aufgaben[n1];
			swappies[1] = aufgaben[n2];
			
			aufgaben[n1] = swappies[1];
			aufgaben[n2] = swappies[0];
		}
		
		System.out.println("Mixen successful!");
	}

	public int getCurrentAufgabe() {
		return currentAufgabe;
	}
	
	public void neueRunde(int anzahlAufgaben) {
		currentAufgabe = 0;
		aufgabenCurrentRound = new Aufgabe[anzahlAufgaben];
		chooseAufgaben(anzahlAufgaben);
		mixExercises(aufgabenCurrentRound);

	}
	
	public Aufgabe getNextAufgabe() {
		currentAufgabe++;
		return aufgabenCurrentRound[currentAufgabe-1];
	}
	
	public boolean isRoundOver() {
		if(currentAufgabe >= aufgabenCurrentRound.length)
			return true;
		else
			return false;
	}
	
	public int getAnzahlAufgaben() {
		return aufgabenCurrentRound.length;
	}
	
	public void rankAufgaben(ArrayList<Aufgabe> wrongAnswers ,ArrayList<Aufgabe> rightAnswers) {
		
		//Schwierigkeit der falschen erhöhen
		for(Aufgabe wrongAnswer : wrongAnswers) {
			for(int i = 0; i < aufgaben.length; i++) {
				if(aufgaben[i].equals(wrongAnswer) && (aufgaben[i].getDifficulty() < 2) ) {
					aufgaben[i].setDifficulty(aufgaben[i].getDifficulty() + 1);
				}
			}
		}
		
		//Schwierigkeit richtige runtersetzen
		for(Aufgabe rightAnswer : rightAnswers) {
			for(int i = 0; i < aufgaben.length; i++) {
				if(aufgaben[i].equals(rightAnswer) && (aufgaben[i].getDifficulty() > 0) ) {
					aufgaben[i].setDifficulty(aufgaben[i].getDifficulty() - 1);
				}
			}
		}
		
		//Aufgaben mit neuem Schwierigkeitsgrad abspeichern
		saveAufgaben();
	}


}
