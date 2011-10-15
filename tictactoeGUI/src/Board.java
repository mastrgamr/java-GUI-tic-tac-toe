import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JFrame implements ActionListener{
	
	JButton[] spot = new JButton[9];
	
	public Board(){
		super("The Game of Tic-Tac-Toe");
		//setup frame defaults
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		clearBoard(); //setup board and set default values
	}
	
	public void clearBoard(){
		JPanel board = new JPanel();
		board.setLayout(new GridLayout(3, 3));
		
		for(int i = 0; i < spot.length; i++){
			spot[i] = new JButton();
			spot[i].setText("-");
			spot[i].setFont(new Font(this.getFont().getFontName(), this.getFont().getStyle(), 30));//used to change the font size
			//spot[i].addActionListener(this);
			board.add(spot[i]);
		}
		
		this.add(board, BorderLayout.CENTER);
	}
	
	public void checkWinner(){
		
	}
	
	//get a copy of a specific spot
	public JButton getSpot(int index){
		JButton[] spotCopy = new JButton[9];
		
		for(int i = 0; i < spotCopy.length; i++)
			spotCopy[i] = new JButton();
		
		System.arraycopy(this.spot, 0, spotCopy, 0, spot.length);
		
		return spotCopy[index];
	}
	
	//get a copy of the spots on the board
	public JButton[] getSpot(){
		JButton[] spotCopy = new JButton[9];
		
		for(int i = 0; i < spotCopy.length; i++)
			spotCopy[i] = new JButton();
		
		System.arraycopy(this.spot, 0, spotCopy, 0, spot.length);
		
		return spotCopy;
	}
	
	public void setSpot(JButton button, Character letter, ActionEvent e){
		button = (JButton)e.getSource();
		
		button.setText(letter.toString());
	}
	
	public void buttonPressed(ActionEvent e){
		JButton source = (JButton)e.getSource();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String buttonText = e.getActionCommand();
		JButton source = (JButton)e.getSource(); //get the value of the button that called this event
		
		if(buttonText.equals("-")){
			source.setText("X");
		}
	}

}
