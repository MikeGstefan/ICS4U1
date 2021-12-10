package game;
import java.awt.*;
public class Element {
	private int x,y,r;
	private Color col;
	private Graphics g;
	
	
	public Element(int x, int y, int r, Color col, Graphics g) {
		this.x = x;
		this.y = y;
		this.r = r;
		this.col = col;
		this.g = g;
		this.draw_element();
	}
	
	public void draw_element() {
		this.g.setColor(col);
		this.g.fillOval(this.x,this.y,(int)(this.r/2),(int)(this.r/2));
	}

	public void set_pos(int x, int y){
		this.x =x;
		this.y = y;
	}
}
