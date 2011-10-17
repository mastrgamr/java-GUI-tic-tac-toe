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
		player.setTurn(true);
		enemy.setTurn(false);
		
		while(!gameOver){
			player.setTurn(true);
			System.out.println("player turn: " + player.getTurn());
			System.out.println("enemy turn: " + enemy.getTurn());
			while(player.getTurn() == true && enemy.getTurn() == false) {
				player.turn();
				if(player.getTurn() == false)
					break;
			}
			//board.checkWinner();
			System.out.println("player turn: " + player.getTurn());
			System.out.println("enemy turn: " + enemy.getTurn());
			enemy.setTurn(true);
			while(enemy.getTurn() == true && player.getTurn() == false) {
				enemy.turn();
				if(player.getTurn() == false)
					break;
			}
			//board.checkWinner();
		}
		
	}
}
