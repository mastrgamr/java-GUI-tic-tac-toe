import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Enemy implements ActionListener{
	
	private Board board;
	
	private Character letter;
	private boolean turnOver;
	
	public Enemy(Board board){
		this.board = board;
	}
	
	public void turn(){
		int spot = (int)(Math.random() * 9);
		
		board.setSpot(this.letter, spot);
		board.getSpot(spot).setEnabled(false);
		
		this.turnOver = true;
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
	
	public boolean getTurn() {
		return this.turnOver;
	}
	
	public void setTurn(boolean turn) {
		this.turnOver = turn;
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
