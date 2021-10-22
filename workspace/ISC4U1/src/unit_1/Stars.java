package unit_1;

import java.awt.*;
import java.util.Random;
public class Stars {
	private int x,y, count,min_size, max_size;
	private Graphics g;
	private static Color STAR_COL = new Color(205,238,249);
	/**
	 * @param x range of valid x positions
	 * @param y range of valid y positions
	 * @param g graphics
	 * @param count how many stars to draw
	 */
	public Stars (int x, int y, Graphics g, int count,int min_size, int max_size) {
		this.x = x;
		this.y = y;
		this.g = g;
		this.count = count;
		this.min_size = min_size;
		this.max_size = max_size;
	}
	/**
	 * Draws a single star
	 * @param x position 
	 * @param y position 
	 */
	private void draw_star(int x,int y, int size) {
		this.g.setColor(STAR_COL);
		this.g.fillOval(x, y, size, size);
	}
	/**
	 * Draws number of stars specified by count at random position
	 */
	public void draw_stars() {
		Random rand = new Random();
		for(int i = 0; i<= count; i++) {
			draw_star(rand.nextInt(this.x), rand.nextInt(this.y), this.min_size+rand.nextInt(this.max_size - this.min_size));
		}
	}
	
}