package unit_1;

import java.awt.*;
/**
 *stoplight class, draws stoplights
 * @author mike stefan
 * @version 10/19
 */
public class Stoplight {
	private int x,y;
	private Graphics g;
	/**
	 *add constructor for stoplight
	 *@param x x position
	 *@param y y position
	 */
	public Stoplight(int x, int y, Graphics g) {
		this.x =x; 
		this.y = y;
		this.g = g;
	}
	/**
	 * Draws light
	 */
	public void draw_light() {
		this.g.setColor(Color.YELLOW);
		this.g.fillRect(this.x,this.y,200,500);
		this.g.setColor(Color.GRAY);
		this.g.fillOval(this.x+50, this.y+50, 100, 100);
		this.g.fillOval(this.x+50, this.y+200, 100, 100);
		this.g.fillOval(this.x+50, this.y+350, 100, 100);
	}
	/**
	 * turns light red
	 */
	public void goRed() {
		this.g.setColor(Color.RED);
		this.g.fillOval(x+50, y+50, 100, 100);
	}
	/**
	 * Turns light yellow
	 */
	public void goYellow() {
		this.g.setColor(new Color(255,234,3));
		this.g.fillOval(this.x+50, this.y+200, 100, 100);
	}
	/**
	 * turns light green
	 */
	public void goGreen() {
		this.g.setColor(Color.GREEN);
		this.g.fillOval(this.x+50, this.y+350, 100, 100);
	}
	
}
