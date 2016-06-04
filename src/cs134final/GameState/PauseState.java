//The pause GameState can only be activated
//by calling GameStateManager#setPaused(true).
package cs134final.GameState;

import java.awt.Graphics2D;

import cs134final.Manager.Content;
import cs134final.Manager.GameStateManager;
import cs134final.Manager.JukeBox;
import cs134final.Manager.Keys;

public class PauseState extends GameState {
	
	public PauseState(GameStateManager gsm) {
		super(gsm);
	}
	
	public void init() {}
	
	public void update() {
		handleInput();
	}
	
	public void draw(Graphics2D g) {
		
		Content.drawString(g, "Pause Menu", 20, 30);
		
		Content.drawString(g, "Control Setting", 4, 60);
		Content.drawString(g, "move", 12, 80);
		Content.drawString(g, ": ", 42, 80);
		Content.drawString(g, "up/down ", 48, 76);
		Content.drawString(g, "left/right ", 48, 84);
		
		Content.drawString(g, "space", 12, 96);
		Content.drawString(g, ":action", 52, 96);
		
		Content.drawString(g, "F1:reset game", 12, 112);

	}
	public void handleInput() {
		if(Keys.isPressed(Keys.ESCAPE)) {
			gsm.setPaused(false);
			JukeBox.resumeLoop("music1");
		}
		if(Keys.isPressed(Keys.F1)) {
			gsm.setPaused(false);
			gsm.setState(GameStateManager.PLAY);
		}
	}
	
}
