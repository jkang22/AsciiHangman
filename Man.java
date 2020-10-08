import java.util.Arrays;
public class Man {
	
	/*  An ASCII Hangman looks like this:
	 *   O 
	 *  \|/
	 *  / \
	 */

	protected static final int MAX_INCORRECT = 6;
	protected int numIncorrect;
	protected char[] body=new char[12];
	
	
	public Man() {
		for (int i = 0; i < this.body.length; i++) {
			if (i % 4 == 3) {
				this.body[i] = '\n';
			} else {
				this.body[i] = ' ';
			}
		}
		}
	
	public boolean isAlive() {
		return (numIncorrect < MAX_INCORRECT);
	}
	
	public void hang() {
		this.numIncorrect++;
	
		if (numIncorrect == 1) {
			body[1] ='O';
		} else if (numIncorrect == 2) {
			body[5] = '|';
		} else if (numIncorrect == 3) {
			body[4]='\\';
		} else if (numIncorrect == 4) {
			body[6] = '/';
		} else if (numIncorrect == 5) {
			body[8] = '/';
		} else if (numIncorrect == 6) {
			body[10] = '\\';
		}
	}
	
	
	public String toString() {
		String s = "";
		for (int i = 0; i < 12; i++) {
			s += body[i];
		}
		return s;
	}
	
	protected char[] toCharArray() {
		return this.body;
	}
	
	public static void main(String[] args) {
		Man m = new Man();
		for(int i=0; i<Man.MAX_INCORRECT; i++) {
			m.hang();
			System.out.println(m);
		}
	}
	
}
