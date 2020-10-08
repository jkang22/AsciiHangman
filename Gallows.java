import java.util.Arrays;

public class Gallows {
	
	/* Gallows look like this:
	 *    ____
	 *   |    |
	 *   |    O
	 *   |   \|/
	 *   |   / \
	 * __|__
	 */
	
	protected Man man;
	protected char[] frame;

	public Gallows() {
		this.man = new Man();
		this.frame = new char[60];
		for (int i = 0; i< frame.length; i++) {
			this.frame[i] = ' ';
		}
		
		for (int i = 0; i < 6; i++) {
			this.frame[i*10] = '\n';
			
		}
		
		
		makeBase();
		makeCenterPost();
		makeBeam();
		makeRope();
		
	}
	
	public void makeCenterPost() {
		for (int i =1; i<6 ; i++) {
			this.frame[i*10+3] = '|';
		}
	}
	
	public void makeBeam() {
		for (int i = 4; i <= 7; i++) {
			this.frame[i] = '_';
			
		}
		
	}
	
	public void makeBase() {
		for (int i = 51; i<=55; i++) {
			this.frame[i] = '_';
			
		}
	}
	
	public void makeRope() {
		this.frame[18]='|';
		
	}
	
	public void hang() {
		this.man.hang();
	}
	
	public boolean isAlive() {
		return(this.man.isAlive());
	}
	
	public String toString() {
		char[] manArray = this.man.toCharArray();
		String s = "";
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 10; j++) {
				if (i>1 && i < 5 && j > 6 ) {
					s += manArray[(i-2) * 4 + j - 7];
				} else {
					s +=frame[i*10+j];
				}
			}
		}
		return s;
	}
	
	/* This code is included to allow you to test the
	 * Gallows independently from the Hangman code. 
	 */
	public static void main(String[] args) {
		Gallows g = new Gallows();
		System.out.println(g);
		for(int i=0; i< Man.MAX_INCORRECT; i++) {
			g.hang();
			System.out.print(g);
			
		}
	}
}
