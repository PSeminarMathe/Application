package root;

import java.util.ArrayList;

public class StatistikManager {
	
	private ArrayList<Aufgabe> wrongAnswers;
	private ArrayList<Aufgabe> rightAnswers;
	
	public StatistikManager() {
		wrongAnswers = new ArrayList<Aufgabe>();
		rightAnswers = new ArrayList<Aufgabe>();
	}
	
	//Arrays zurückgeben
	public ArrayList<Aufgabe> getWrongAnswers() {
		return wrongAnswers;
	}
	
	public ArrayList<Aufgabe> getRightAnswers() {
		return rightAnswers;
	}
	
	//Neue Runde
	public void neueRunde() {
		wrongAnswers.clear();
		rightAnswers.clear();
	}
	
	//Hinzufügen
	public void addWrongAnswer(Aufgabe a) {
		wrongAnswers.add(a);
	}
	
	public void addRightAnswer(Aufgabe a) {
		rightAnswers.add(a);
	}
	
	//Berechnungen
	public int getAnzahlAufgaben() {
		return wrongAnswers.size() + rightAnswers.size();
	}
	
	public int getAnzahlFalsche() {
		return wrongAnswers.size();
	}
	
	public int getAnzahlRichtige() {
		return rightAnswers.size();
	}
	
	public double getWrongPercentage() {
		double percentage = ((double) wrongAnswers.size() / getAnzahlAufgaben()) * 100;
		System.out.println(percentage);
		return percentage;
	}
	
	public double getRightPercentage() {
		double percentage = ((double) rightAnswers.size() / getAnzahlAufgaben()) * 100;
		return percentage;
	}
}
