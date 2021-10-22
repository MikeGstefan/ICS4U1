package unit_1;

import java.awt.*;
public class Neck {
	private int x, y;
	private Graphics g;
	private static final Color BODY_COL = new Color(217,118,25);
	private static final Color METAL = new Color(201, 197, 193);
//	239,209,165
	private static final Color HIGHLIGHT = new Color(209,179,145);
	private static final Color LOWLIGHT = new Color(199, 106, 20);
	
	public Neck(int x, int y, Graphics g) {
		this.x = x;
		this.y = y;
		this.g = g;
	}
	
	public void draw_neck() {
		this.g.setColor(METAL);
		this.g.fillRect(this.x-40, this.y-20, 80, 20);
		this.g.setColor(BODY_COL);
		this.g.fillRect(this.x-30, this.y-65,60, 65);
		this.g.setColor(LOWLIGHT);
		this.g.fillOval(this.x-30, this.y-80, 60, 30);
		this.g.setColor(BODY_COL);
		this.g.fillOval(this.x-27, this.y-87, 54, 35);
//		this.g.setColor(LOWLIGHT);
//		this.g.fillRect(this.x-24, this.y -79, 49, 10);
		this.g.setColor(BODY_COL);
		this.g.fillRect(this.x-22, this.y -130, 44, 55);
//		this.g.setColor(HIGHLIGHT);
//		this.g.fillRect(this.x-20, this.y-150, 40, 40);
//		this.g.setColor(LOWLIGHT);
//		this.g.fillRect(this.x-15, this.y -117, 30, 10);
	}
}
