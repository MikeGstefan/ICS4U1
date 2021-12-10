package u3;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class canter extends Canvas{
	public void drawCanter(int x, int y, int l, Graphics g) {
		if(l <=1)return;
		g.setColor(Color.WHITE);
		g.fillRect(x, y, l, 20);
		y+=60;
		drawCanter(x,y,l/3,g);
		drawCanter(x + l - (l/3), y, l/3, g);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("My First Drawing");
		Canvas canvas = new canter();
		canvas.setSize(800,800);
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);

	}
	
	public void paint(Graphics g) {
		this.setBackground(Color.BLACK);
		drawCanter(50,20,500, g);
	}

}
