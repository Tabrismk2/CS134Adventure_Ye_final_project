//Pokedex class.
//May contain a list of tileChanges.
//These tileChanges are used to modify
//the tile map upon collection.
package cs134final.Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import cs134final.Manager.Content;
import cs134final.TileMap.TileMap;

public class Pokedex extends Entity {
	
	BufferedImage[] sprites;
	
	private ArrayList<int[]> tileChanges;
	
	public Pokedex(TileMap tm) {
		
		super(tm);
		
		width = 16;
		height = 16;
		cwidth = 12;
		cheight = 12;
		
		sprites = Content.POKEDEX[0];
		animation.setFrames(sprites);
		animation.setDelay(10);
		
		tileChanges = new ArrayList<int[]>();
		
	}
	
	public void addChange(int[] i) {
		tileChanges.add(i);
	}
	public ArrayList<int[]> getChanges() {
		return tileChanges;
	}
	
	public void update() {
		animation.update();
	}
	
	public void draw(Graphics2D g) {
		super.draw(g);
	}
	
}