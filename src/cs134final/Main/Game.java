package cs134final.Main;
import javax.swing.JFrame;

public class Game {
	
	public static void main(String[] args){
		JFrame window = new JFrame("CS134 Adventure");
		
		window.add(new GamePanel());
		
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
