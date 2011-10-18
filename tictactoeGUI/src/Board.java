import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Board extends JFrame implements ActionListener{
	
	private JButton[] spot = new JButton[9];
	
	public Board(){
		super("The Game of Tic-Tac-Toe");
		//setup frame defaults
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		setupBoard(); //setup board and set default values
	}
	
	public void setupBoard(){
		//setup the menu
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenuItem menuItem;
		
		//add items to the menu
		menuItem = new JMenuItem("New Game (Unavailable)");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Exit");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		
		menuBar.add(menu); //add the actual menu to the bar
		this.setJMenuBar(menuBar); //set the menu bar to the frame for viewing
		
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String menuText = e.getActionCommand();
		
		if(menuText.equals("No Function yet.")) { //TODO: Setup new game Menu Item
			this.setNewGame(true);
		}else if(menuText.equals("Exit")) {
			System.exit(0);
		}
	}
	
	private boolean newGame;
	
	public void setNewGame(boolean bool) {
		this.newGame = bool;
	}
	public boolean getNewGame() {
		return this.newGame;
	}
	
	public boolean checkWinner(Board board){
		int total = 0;
		//Check rows for 3 X or O in a row
		for(int i = 0; i < 3; i++){ //row 1
			total += (int)board.getSpot(i).getText().charAt(0);
			if(total == 237 || total == 264) {
				for(int j = 0; j < 3; j++)
					this.getSpot(j).setBackground(Color.DARK_GRAY);
				return true;
			}
		}
		total = 0;
		for(int i = 3; i < 6; i++){ //row 2
			total += (int)board.getSpot(i).getText().charAt(0);
			if(total == 237 || total == 264) {
				for(int j = 3; j < 6; j++)
					this.getSpot(j).setBackground(Color.DARK_GRAY);
				return true;
			}
		}
		total = 0;
		for(int i = 6; i < 9; i++){ //row 3
			total += (int)board.getSpot(i).getText().charAt(0);
			if(total == 237 || total == 264) {
				for(int j = 6; j < 9; j++)
					this.getSpot(j).setBackground(Color.DARK_GRAY);
				return true;
			}
		}
		total = 0;
		//Check columns for 3 X or O in a row
		for(int i = 0; i < 7; i += 3){ //column 1
			total += (int)board.getSpot(i).getText().charAt(0);
			if(total == 237 || total == 264) {
				for(int j = 0; j < 7; j += 3)
					this.getSpot(j).setBackground(Color.DARK_GRAY);
				return true;
			}
		}
		total = 0;
		for(int i = 1; i < 8; i += 3){ //column 2
			total += (int)board.getSpot(i).getText().charAt(0);
			if(total == 237 || total == 264) {
				for(int j = 1; j < 8; j += 3)
					this.getSpot(j).setBackground(Color.DARK_GRAY);
				return true;
			}
		}
		total = 0;
		for(int i = 2; i < 10; i += 3){ //column 3
			total += (int)board.getSpot(i).getText().charAt(0);
			if(total == 237 || total == 264) {
				for(int j = 2; j < 10; j += 3)
					this.getSpot(j).setBackground(Color.DARK_GRAY);
				return true;
			}
		}
		total = 0;
		//check diagonal-right for 3 X or O in a row
		for(int i = 0; i < 10; i += 4){
			total += (int)board.getSpot(i).getText().charAt(0);
			if(total == 237 || total == 264) {
				for(int j = 0; j < 10; j += 4)
					this.getSpot(j).setBackground(Color.DARK_GRAY);
				return true;
			}
		}
		total = 0;
		//check diagonal-left for 3 X or O in a row
		for(int i = 2; i < 7; i += 2){
			total += (int)board.getSpot(i).getText().charAt(0);
			if(total == 237 || total == 264) {
				for(int j = 2; j < 7; j += 2)
					this.getSpot(j).setBackground(Color.DARK_GRAY);
				return true;
			}
		}
		total = 0;
		
		return false; //false by default, so game won't end prematurely
	}
}
