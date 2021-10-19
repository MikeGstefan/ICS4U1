package unit_1;

import java.awt.*;

public class stoplight {
	public void draw_light(int x, int y, Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x,y,200,500);
		g.setColor(Color.GRAY);
		g.fillOval(x+50, y+50, 100, 100);
		g.fillOval(x+50, y+200, 100, 100);
		g.fillOval(x+50, y+350, 100, 100);
	}
	
	public void goRed(int x, int y, Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(x+50, y+50, 100, 100);
	}
	public void goYellow(int x, int y, Graphics g) {
		g.setColor(new Color(255,234,3));
		g.fillOval(x+50, y+200, 100, 100);
	}
	public void goGreen(int x, int y, Graphics g) {
		g.setColor(Color.GREEN);
		g.fillOval(x+50, y+350, 100, 100);
	}
	
}
