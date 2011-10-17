import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class Player implements ActionListener{
	
	private Board board;
	
	private Character letter;
	private boolean turnOver;
	
	public Player(){ }
	
	public Player(Character letter, Board board){
		this.letter = letter;
		this.board = board;
	}
	
	public void turn(){
		for(int i = 0; i < board.getSpot().length; i++){
			board.getSpot(i).addActionListener(this); //get a copy of the board's buttons to listen to this class
		}
		
		this.turnOver = false;
	}
	
	public Character getLetter(){
		return this.letter;
	}
	
	public boolean getTurn() {
		return this.turnOver;
	}
	
	public void setTurn(boolean turn) {
		this.turnOver = turn;
	}
	
	public boolean isValidLetter(char letter){
		return (letter == 'O' ^ letter == 'X');
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String buttonText = e.getActionCommand();
		JButton source = (JButton) e.getSource();
		
		if(buttonText.equals("-")){
			source.setText(this.letter.toString());
			source.setEnabled(false);
		}
	}
}
