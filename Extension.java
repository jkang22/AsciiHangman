import java.io.Console;
import java.util.Scanner;

public class Extension {
	protected static char[] letters;
	protected static int count;
	protected static int lettersLeftToGuess;
	protected static char[] displayLetters;
	
	public static void main(String[] args) {
		System.out.println("Welcome to the ASCII Version of Hangman!");
		System.out.println("Game mode: Multiplayer(1) or Computer(2) or Self (3)");
		
		
		Console c = System.console();
		Scanner s = new Scanner(System.in);
		Scanner z = new Scanner(System.in);
		int choice = z.nextInt();
		if (choice == 1) {
			System.out.println("You are playing multiplayer");
		
		String prompt = "Please enter a secret word: ";
		if(c != null) {
			letters = c.readPassword(prompt);
			for(int i=0; i<letters.length; i++) {
				letters[i] = Character.toUpperCase(letters[i]);
			}
		} else {
			System.out.println("For best results, please run this from the command line.");
			System.out.print(prompt);
			letters = s.nextLine().trim().toUpperCase().toCharArray();
			for(int i=0; i<10000; i++) System.out.println();
			
		}
		
		Computer e = new Computer();
		Gallows g = new Gallows();
		
		while(g.isAlive() && lettersLeftToGuess > 0) {
			
			System.out.println(g);
			System.out.println("Puzzle to solve: " + toString(displayLetters));
			System.out.print("Please guess a letter: ");
			Scanner d = new Scanner(System.in);
			char guess = d.nextLine().toUpperCase().charAt(0);
			System.out.println(guess);
			if (!checkGuess(guess)) {
				g.hang();
			} 
		
		}
		System.out.println(Message());
		}
		else if (choice == 2) {
			System.out.println("You are playing against a computer");
			String prompt = "Please enter a secret word: ";
			if(c != null) {
				letters = c.readPassword(prompt);
				for(int i=0; i<letters.length; i++) {
					letters[i] = Character.toUpperCase(letters[i]);
				}
			} else {
				System.out.println("For best results, please run this from the command line.");
				System.out.print(prompt);
				letters = s.nextLine().trim().toUpperCase().toCharArray();
				for(int i=0; i<10000; i++) System.out.println();
				
			}
			
			Gallows g = new Gallows();
			Computer ext = new Computer();
			
			while(g.isAlive() && lettersLeftToGuess > 0) {
				
				System.out.println(g);
				System.out.println("Puzzle to solve: " + toString(displayLetters));
				char compGuess = ext.computerGuess();
				System.out.println(compGuess);
				if (!checkGuess(compGuess)) {
					g.hang();
				} 
			}
			System.out.println(g);

			System.out.print(ext.displayMessage());
			
			}
			
		}

		
		// TODO: Write the code to play Hangman here.
	
		public static boolean checkGuess(char guess) {
			boolean foundLetter = false;
			for (int i = 0; i<letters.length; i++) {
				if (guess == letters[i] && displayLetters[i*2] != guess) {
					lettersLeftToGuess--;
					displayLetters[i*2] = guess;
					foundLetter = true;
				}
				}
			return foundLetter;
		}
		
		public static String Message() {
			if (lettersLeftToGuess ==0) {
				return ("Success!  Player 2 wins!");
			} else {
				return("Game over! Player 1 wins!");
			}
		}
		
		
		
		public Extension() {
			Gallows g = new Gallows();
			count = 0;
			lettersLeftToGuess = letters.length;
			displayLetters = new char[2*letters.length];
			for (int i=0; i < displayLetters.length; i+=2) {
				displayLetters[i]='_';
			}
			for (int i=1; i<displayLetters.length; i+=2) {
				displayLetters[i] =' ';
			}
			
		}
		
		public static String toString(char[] display) {
			String s = "";
			for (int i = 0; i < display.length; i++) {
				s += display[i];
			}
			return s;
		}

	}


