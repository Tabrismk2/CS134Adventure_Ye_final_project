//Contains a reference to the Player.
//Draws all relevant information at the
//bottom of the screen.

package cs134final.HUD;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import cs134final.Entity.Pokedex;
import cs134final.Entity.Player;
import cs134final.Main.GamePanel;
import cs134final.Manager.Content;

public class Hud {
	
	private int yoffset;
	
	private BufferedImage bar;
	private BufferedImage pokedex;
	private BufferedImage lapras;
	private BufferedImage masterball;
	
	private Player player;
	
	private int numPokedex;
	
	private Font font;
	private Color textColor; 
	
	public Hud(Player p, ArrayList<Pokedex> d) {
		
		player = p;
		numPokedex = d.size();
		yoffset = GamePanel.HEIGHT;
		
		bar = Content.BAR[0][0];
		pokedex = Content.POKEDEX[0][0];
		lapras = Content.ITEMS[0][0];
		masterball = Content.ITEMS[0][1];
		
		font = new Font("Arial", Font.PLAIN, 10);
		textColor = new Color(242, 167, 167);
		
	}
	
	public void draw(Graphics2D g) {
		
		// draw hud
		g.drawImage(bar, 0, yoffset, null);
		
		// draw pokedex bar
		g.setColor(textColor);
		g.fillRect(8, yoffset + 6, (int)(28.0 * player.numPokedex() / numPokedex), 4);
		
		// draw amount
		g.setColor(textColor);
		g.setFont(font);
		String s = player.numPokedex() + "/" + numPokedex;
		Content.drawString(g, s, 40, yoffset + 3);
		if(player.numPokedex() >= 10) g.drawImage(pokedex, 80, yoffset, null);
		else g.drawImage(pokedex, 72, yoffset, null);
		
		// draw items
		if(player.hasLapras()) g.drawImage(lapras, 100, yoffset, null);
		if(player.hasMasterBall()) g.drawImage(masterball, 112, yoffset, null);
		
		// draw time
		int minutes = (int) (player.getTicks() / 1800);
		int seconds = (int) ((player.getTicks() / 30) % 60);
		if(minutes < 10) {
			if(seconds < 10) Content.drawString(g, "0" + minutes + ":0" + seconds, 85, 3);
			else Content.drawString(g, "0" + minutes + ":" + seconds, 85, 3);
		}
		else {
			if(seconds < 10) Content.drawString(g, minutes + ":0" + seconds, 85, 3);
			else Content.drawString(g, minutes + ":" + seconds, 85, 3);
		}
		
		
		
	}
	
}
