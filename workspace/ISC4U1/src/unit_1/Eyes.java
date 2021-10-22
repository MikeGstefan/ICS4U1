package unit_1;

import java.awt.*;
public class Eyes {
	private int x, y;
	private Graphics g;
	private boolean pupil_side;
	private static int eye_offset = 40;
	private static final Color BODY_COL = new Color(217,118,25);
	private static final Color METAL = new Color(201, 197, 193);
//	239,209,165
	private static final Color HIGHLIGHT = new Color(209,179,145);
	private static final Color LOWLIGHT = new Color(199, 106, 20);
	private static final Color EYES = new Color(93,30,47);
//	private static final Color 
	/**
	 * 
	 * @param x
	 * @param y
	 * @param g
	 * @param pupil_side bool representing wether pupil should be on the left or right side of the eye, left being true
	 */
	public Eyes(int x, int y, Graphics g, boolean pupil_side) {
		this.x = x;
		this.y = y;
		this.g = g;
		this.pupil_side = pupil_side;
	}
	
	public void draw_eyes() {
		int x_offset = 0;
		if(!this.pupil_side) {
			x_offset = eye_offset;
		}
		this.g.setColor(new Color(97, 94, 92));
		this.g.fillOval(this.x , this.y, 160,120);
		this.g.setColor(METAL);
		this.g.fillOval(this.x +5, this.y +5, 150,110);
		this.g.setColor(new Color(0,0,0));
		this.g.fillOval(this.x+10 +x_offset,this.y +10, 100, 100);
		this.g.setColor(EYES);
		this.g.fillOval(this.x+15+ x_offset,this.y +15, 90, 90);
		this.g.setColor(METAL);
		this.g.fillOval(this.x+35+ x_offset,this.y +35, 50, 50);
		this.g.setColor(EYES);
		this.g.fillOval(this.x+40+ x_offset,this.y +40, 40, 40);
		

	}
}
