import java.util.Random;
public class Computer {

	private String possibleLetters;
	private int correspondingnumbers;
	protected Man man;
	protected Extension extension;
	
	public Computer() {
		possibleLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		this.man = new Man();
		this.extension = new Extension();
	}
	
	public char computerGuess() {
		Random rand = new Random();
		char guess = possibleLetters.charAt(rand.nextInt(26));
		return guess;
	}
	

public String displayMessage() {
	if (Hangman.lettersLeftToGuess == 0) {
		return "Computer won!";
	} else {
		return "You stumped the computer!";
	}
}
}
