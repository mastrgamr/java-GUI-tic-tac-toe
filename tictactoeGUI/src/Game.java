import javax.swing.JOptionPane;

public class Game {
	
	private Board board;
	private Player player;
	private Enemy enemy;
	
	private boolean gameOver;
	String playerLetter;
	
	public Game(){
		gameOver = false;
		board = new Board();
	}
	
	public void play(){
		do{
			playerLetter = JOptionPane.showInputDialog("What letter would you like to be? (X or O)");
			player = new Player(playerLetter.charAt(0), board);
			if(player.getLetter() == null)
				System.exit(0);
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
		}
		
	}
}
