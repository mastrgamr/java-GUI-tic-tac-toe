import javax.swing.JOptionPane;

public class Enemy {
	
	private Board board;
	
	private char letter;
	
	public Enemy(Board board){
		this.board = board;
	}
	
	public void turn(){
		
	}
	
	public void setLetter(char letter){
		switch(letter){
		case 'O':
			this.letter = 'X';
			break;
		case 'X':
			this.letter = 'O';
			break;
		default:
			JOptionPane.showMessageDialog(null, "Fatal Error: Can not set enemy letter!");
		}
	}
	
	public char getLetter(){
		return this.letter;
	}
}
