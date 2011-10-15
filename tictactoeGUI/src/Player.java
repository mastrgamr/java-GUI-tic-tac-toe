
public class Player {
	
	private Board board;
	
	private char letter;
	
	public Player(char letter, Board board){
		this.letter = letter;
		this.board = board;
	}
	
	public void turn(){
		
	}
	
	public char getLetter(){
		return this.letter;
	}
	
	public boolean isValidLetter(char letter){
		return (letter == 'O' ^ letter == 'X');
	}
}
