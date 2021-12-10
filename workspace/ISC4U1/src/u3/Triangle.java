package u3;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Triangle extends Canvas{
	public void drawTriangle(int x1, int y1, int x2, int y2, int x3, int y3,int l, Graphics g) {
		if (l> 1) {
			g.setColor(Color.WHITE);
			g.drawLine(x1,y1,x2,y2);
			g.drawLine(x1,y1,x3,y3);
			g.drawLine(x2,y2,x3,y3);
			l--;
			drawTriangle(x1, y1, (x1 + x2)/2, (y1 + y2)/2, (x1 + x3)/2, (y1 + y3)/2, l, g);
			drawTriangle(x2, y2, (x2 + x1)/2, (y2 + y1)/2, (x2 + x3)/2, (y2 + y3)/2, l, g);
			drawTriangle(x3, y3, (x3 + x2)/2, (y3 + y2)/2, (x1 + x3)/2, (y1 + y3)/2, l, g);
			
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("My First Drawing");
		Canvas canvas = new Triangle();
		canvas.setSize(800,800);
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);

	}
	
	public void paint(Graphics g) {
		this.setBackground(Color.BLACK);
		drawTriangle(400,20,200,220,600,220,10,g);
	}
}
