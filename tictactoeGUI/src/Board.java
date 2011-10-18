import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Board extends JFrame{
	
	JPanel infoPanel = new JPanel();
	JLabel info;
	JButton[] spot = new JButton[9];
	
	public Board(){
		super("The Game of Tic-Tac-Toe");
		//setup frame defaults
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		info = new JLabel("New Game");
		
		clearBoard(); //setup board and set default values
		
		infoPanel.add(info);
		this.add(infoPanel, BorderLayout.SOUTH);
	}
	
	public void clearBoard(){
		JPanel board = new JPanel();
		board.setLayout(new GridLayout(3, 3));
		
		for(int i = 0; i < spot.length; i++){
			spot[i] = new JButton();
			spot[i].setText("-");
			spot[i].setFont(new Font(this.getFont().getFontName(), this.getFont().getStyle(), 30));//used to change the font size
			board.add(spot[i]);
		}
		
		this.add(board, BorderLayout.CENTER);
	}
	
	public void setSpot(Character letter, int index) {
		this.spot[index].setText(letter.toString());
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
	
	public void setInfo(String info){
		this.info = new JLabel(info);
	}
	
	public boolean checkWinner(Board board){
		int total = 0;
		//Check rows for 3 X or O in a row
		for(int i = 0; i < 3; i++){ //row 1
			total += (int)board.getSpot(i).getText().charAt(0);
			if(total == 237 || total == 264)
			return true;
		}
		total = 0;
		for(int i = 3; i < 6; i++){ //row 2
			total += (int)board.getSpot(i).getText().charAt(0);
			if(total == 237 || total == 264)
			return true;
		}
		total = 0;
		for(int i = 6; i < 9; i++){ //row 3
			total += (int)board.getSpot(i).getText().charAt(0);
			if(total == 237 || total == 264)
			return true;
		}
		total = 0;
		//Check columns for 3 X or O in a row
		for(int i = 0; i < 7; i += 3){ //column 1
			total += (int)board.getSpot(i).getText().charAt(0);
			if(total == 237 || total == 264)
			return true;
		}
		total = 0;
		for(int i = 1; i < 8; i += 3){ //column 2
			total += (int)board.getSpot(i).getText().charAt(0);
			if(total == 237 || total == 264)
			return true;
		}
		total = 0;
		for(int i = 2; i < 10; i += 3){ //column 3
			total += (int)board.getSpot(i).getText().charAt(0);
			if(total == 237 || total == 264)
			return true;
		}
		total = 0;
		//check diagonal-right for 3 X or O in a row
		for(int i = 0; i < 10; i += 4){
			total += (int)board.getSpot(i).getText().charAt(0);
			if(total == 237 || total == 264)
			return true;
		}
		total = 0;
		//check diagonal-left for 3 X or O in a row
		for(int i = 2; i < 7; i += 2){
			total += (int)board.getSpot(i).getText().charAt(0);
			if(total == 237 || total == 264)
			return true;
		}
		total = 0;
		
		return false; //false by default, so game won't end prematurely
	}
}
