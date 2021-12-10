package u3;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;


public class Tree extends Canvas{
	final double angle_off = Math.PI/4.0;

	public void drawTree(int x1, int y1, int x2, int y2, double angle, int count,  Graphics g) {
		double l = Math.sqrt(Math.pow((x2-x1), 2)+ (Math.pow((y2-y1), 2)));
		if (Math.abs(x2-x1) >1 || Math.abs(y2-y1) > 1) {
			g.setColor(Color.WHITE);
			System.out.println(count + " " + x1 + " " + y1 + " " + x2 + " " + y2);
			count --;
			g.drawLine(x1,y1,x2,y2);
			drawTree(x2, y2, (int)(x2+ Math.sin(angle - angle_off)*l/2),(int)(y2- Math.cos(angle - angle_off)*l/2),angle-angle_off, count, g);
			drawTree(x2, y2, (int)(x2+ Math.sin(angle + angle_off)*l/2),(int)(y2- Math.cos(angle + angle_off)*l/2),angle+angle_off, count, g);
//			count+= 1;
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("My First Drawing");
		Canvas canvas = new Tree();
		canvas.setSize(1000,1000);
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);

	}
	
	public void paint(Graphics g) {
		this.setBackground(Color.BLACK);
		drawTree(600,1000, 600, 600,0.0,20,g);
	}

}
