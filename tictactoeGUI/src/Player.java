import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class Player implements ActionListener{
	
	private Board board;
	
	private Character letter;
	
	public Player(){ }
	
	public Player(Character letter, Board board){
		this.letter = letter;
		this.board = board;
	}
	
	public void turn(){
		board.setSpot(board.getSpot(), this.letter, board);
		
		for(int i = 0; i < board.getSpot().length; i++){
			board.getSpot(i).addActionListener(board);
		}
	}
	
	public char getLetter(){
		return this.letter;
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
		}
	}
}
