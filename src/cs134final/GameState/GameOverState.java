package cs134final.GameState;

import java.awt.Color;
import java.awt.Graphics2D;

import cs134final.Main.GamePanel;
import cs134final.Manager.Content;
import cs134final.Manager.Data;
import cs134final.Manager.GameStateManager;
import cs134final.Manager.JukeBox;
import cs134final.Manager.Keys;

public class GameOverState extends GameState {
	
	private Color color;
	
	private int rank;
	private long ticks;
	
	public GameOverState(GameStateManager gsm) {
		super(gsm);
	}
	
	public void init() {
		color = new Color(247, 247, 247);
		ticks = Data.getTime();
		if(ticks < 3600) rank = 1;
		else if(ticks < 5400) rank = 2;
		else if(ticks < 7200) rank = 3;
		else rank = 4;
	}
	
	public void update() {}
	
	public void draw(Graphics2D g) {
		
		g.setColor(color);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT2);
		
		Content.drawString(g, "finish time", 20, 36);
		
		int minutes = (int) (ticks / 1800);
		int seconds = (int) ((ticks / 30) % 60);
		if(minutes < 10) {
			if(seconds < 10) Content.drawString(g, "0" + minutes + ":0" + seconds, 44, 48);
			else Content.drawString(g, "0" + minutes + ":" + seconds, 44, 48);
		}
		else {
			if(seconds < 10) Content.drawString(g, minutes + ":0" + seconds, 44, 48);
			else Content.drawString(g, minutes + ":" + seconds, 44, 48);
		}
		
		Content.drawString(g, "rank", 48, 66);
		if(rank == 1) Content.drawString(g, "Professor Finder", 20, 78);
		else if(rank == 2) Content.drawString(g, "Good student", 24, 78);
		else if(rank == 3) Content.drawString(g, "Normal student", 32, 78);
		else if(rank == 4) Content.drawString(g, "Bad student", 8, 78);
		
		Content.drawString(g, "Game Over", 12, 110);
		
	}
	
	public void handleInput() {
		if(Keys.isPressed(Keys.ENTER)) {
			gsm.setState(GameStateManager.MENU);
			JukeBox.play("collect");
		}
	}
	
}
