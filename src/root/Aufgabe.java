package root;

public class Aufgabe {
	
	private int firstNumber;
	private int secondNumber;
	private int difficulty;

	public Aufgabe(int fn, int sn) {
		firstNumber = fn;
		secondNumber = sn;
		setDifficulty(0);
	}
	
	public Aufgabe(int fn, int sn, int d) {
		firstNumber = fn;
		secondNumber = sn;
		setDifficulty(d);
	}
	
	//Faktoren & Ergebnis
	public int getFirstNumber() {
		return firstNumber;
	}

	public int getSecondNumber() {
		return secondNumber;
	}	
	
	public int getErgebnis() {
		return firstNumber * secondNumber;
	}
	
	//Schwierigkeit
	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	
	//Gleichheit überprüfen
	public boolean equals(Aufgabe b) {
		if( (this.firstNumber == b.firstNumber) && (this.secondNumber == b.secondNumber) )
			return true;
		else 
			return false;
	}
	
}
