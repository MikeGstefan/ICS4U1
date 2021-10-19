package unit_1;


import java.awt.*;
import javax.swing.JFrame;
public class drawing extends Canvas{

	public static void main(String[] args) {
		JFrame frame = new JFrame("My First Drawing");
		Canvas canvas = new drawing();
		canvas.setSize(500,600);
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);

	}
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
	
	public void paint(Graphics g) {
		this.setBackground(Color.WHITE);
		this.draw_light(100, 0, g);
		this.goGreen(100,0,g);
	}

}
