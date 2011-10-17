import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Enemy implements ActionListener{
	
	private Board board;
	
	private Character letter;
	private boolean isTurnOver;
	
	public Enemy(Board board){
		this.board = board;
		isTurnOver = true;
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
