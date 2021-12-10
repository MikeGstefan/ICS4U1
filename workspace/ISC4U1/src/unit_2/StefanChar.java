package unit_2;
import java.awt.*;
public class StefanChar extends Character{
	public StefanChar(int x, int y, Graphics g) {
		this.x =x;
		this.y =y;
		this.g = g;
	}
	
	public void draw() {
		this.g.setColor(new Color(255, 248, 48));
		this.g.fillOval(x,y,100,100);
		this.g.setColor(Color.BLACK);
		this.g.fillOval(x+10, y +10,80,80);
		this.g.setColor(new Color(255, 248, 48));
		this.g.fillOval(x+5, y ,90,80);
		this.g.setColor(Color.BLACK);
		this.g.fillOval(x+20, y +25, 20,20);
		this.g.fillOval(x+60, y +25, 20,20);
		
	}
}
