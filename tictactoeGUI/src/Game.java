
import javax.swing.JOptionPane;

public class Game {
	
	private Board board;
	private Player player;
	private Enemy enemy;
	
	private boolean gameOver;
	String playerLetter;
	
	public Game(){
		gameOver = false; //game not over by default
	}
	
	public void play(){
		while(!gameOver) {
			board = new Board(); //create a new board
			do{
				playerLetter = JOptionPane.showInputDialog("Choose your letter: X or O");
				if(playerLetter == null) //if cancel was pressed, exit the program
					System.exit(0);
				
				player = new Player(playerLetter.charAt(0), board);
			}while(!player.isValidLetter(player.getLetter()));
			
			enemy = new Enemy(board);
			enemy.setLetter(player.getLetter());
			
			JOptionPane.showMessageDialog(board, "You get the first turn.");
			//set turns, player goes first by default
			player.setTurnOver(false);
			enemy.setTurnOver(true);
			
			while(!gameOver){
				//player's turn
				player.setTurnOver(false);
				while(player.getTurnOver() == false && enemy.getTurnOver() == true) {
					player.turn();
				}
				
				//check winner
				if(board.checkWinner(board) == true) {
					JOptionPane.showMessageDialog(board, player.getLetter() + " won.");
					for(int i = 0; i < board.getSpot().length; i++) {
						board.getSpot(i).setEnabled(false);
					}
					gameOver = true;
					break;
				}
				
				//enemy turn
				enemy.setTurnOver(false);
				while(enemy.getTurnOver() == false && player.getTurnOver() == true) {
					enemy.turn();
					if(enemy.getTurnOver() == true){
						break;
					}
				}
				
				//check winner
				if(board.checkWinner(board) == true){
					JOptionPane.showMessageDialog(board, enemy.getLetter() + " won.");
					for(int i = 0; i < board.getSpot().length; i++) {
						board.getSpot(i).setEnabled(false);
					}
					gameOver = true;
					break;
				}
			} //gameplay loop
			int choice = JOptionPane.showConfirmDialog(board, "Do you want to play again?");
			if(choice == 0) {
				gameOver = false;
				board.dispose(); //destroy the current board
			}
		}//game loop
		System.exit(0); //exit program when play method is over
	}//play method
}
