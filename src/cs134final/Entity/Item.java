//Possibly redundant subclass of Entity.
//There are two types of items: PokemDex and Lapras.
//Upon collection, informs the Player
//that the Player does indeed have the item.
package cs134final.Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import cs134final.Manager.Content;
import cs134final.TileMap.TileMap;

public class Item extends Entity{
	
	private BufferedImage sprite;
	private int type;
	public static final int LAPRAS = 0;
	public static final int MASTERBALL = 1;
	
	public Item(TileMap tm) {
		super(tm);
		type = -1;
		width = height = 16;
		cwidth = cheight = 12;
	}
	
	public void setType(int i) {
		type = i;
		if(type == LAPRAS) {
			sprite = Content.ITEMS[1][0];
		}
		else if(type == MASTERBALL) {
			sprite = Content.ITEMS[1][1];
		}
	}
	
	public void collected(Player p) {
		if(type == LAPRAS) {
			p.gotLapras();
		}
		if(type == MASTERBALL) {
			p.gotMasterBall();
		}
	}
	
	public void draw(Graphics2D g) {
		setMapPosition();
		g.drawImage(sprite, x + xmap - width / 2, y + ymap - height / 2, null);
	}
	
}