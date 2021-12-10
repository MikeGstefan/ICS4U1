package u3;

import java.awt.*;

import javax.swing.JFrame;
import java.util.*;

public class mountain extends Canvas{
	Random rand = new Random(); 
	public int randSgn() {
		if(rand.nextInt(2) == 1)return 1;
		else return -1;
	}
	public void drawMountain(int x1, int y1, int x2, int y2, int x3, int y3, int l, int m1, int m2, int m3, Graphics g) {
		
//		int corner1 = (y1 + y2)/2;
//		int corner2 = (y1 + y3)/2;
//		int corner3 = (y3 + y2)/2;
//		int corner1 = (y1 + y2)/2 -50;
//		int corner2 = (y1 + y3)/2 +50;
//		int corner3 = (y3 + y2)/2 +50;
		int corner1 = (y1 + y2)/2;
		int corner2 = (y1 + y3)/2;
		int corner3 = (y3 + y2)/2;
		int off1 = rand.nextInt((int)((y1 + y2)/20))*randSgn();
		int off2 = rand.nextInt((int)((y1 + y3)/20))*randSgn();
		int off3 = rand.nextInt((int)((y3 + y2)/20))*randSgn();
		corner1 += m1;
		corner2 += m2;
		corner3 += m3;
		l--;
		if (l>= 1) {
			

//			drawMountain(x1, y1, (x1 + x2)/2, corner1, (x1 + x3)/2, corner2, l,m1,m2,m3, g);
//			drawMountain(x2, y2, (x2 + x1)/2, corner1, (x2 + x3)/2, corner3, l,m1,m2,m3,  g);
//			drawMountain(x3, y3, (x3 + x2)/2, corner3, (x1 + x3)/2, corner2, l,m1,m2,m3, g);
//			drawMountain((x1 + x2)/2, corner1, (x3 + x2)/2, corner3, (x1 + x3)/2, corner2, l,m1,m2,m3, g);
//			drawMountain((x1 + x2)/2, corner1, (x3 + x2)/2, corner3, (x1 + x3)/2, corner2, l,corner1,corner2,corner3, g);
//			
			drawMountain(x1, y1, (x1 + x2)/2, corner1, (x1 + x3)/2, corner2, l,0,0,off3, g);
			drawMountain(x2, y2, (x2 + x1)/2, corner1, (x2 + x3)/2, corner3, l,0,0,off3, g);
			drawMountain(x3, y3, (x3 + x2)/2, corner3, (x1 + x3)/2, corner2, l,0,0,off3, g);
//			corner1 -= off1;
//			corner2 -= off2;
//			corner3 -= off3;
			drawMountain((x1 + x2)/2, corner1, (x3 + x2)/2, corner3, (x1 + x3)/2, corner2, l,off3,off3,off3, g);

		}
		else {
//			int corner1 = (y1 + y2)/2 +rand.nextInt((int)((y1 + y2)/4));
//			int corner2 = (y1 + y3)/2 +rand.nextInt((int)((y1 + y3)/4));
//			int corner3 = (y3 + y2)/2 +rand.nextInt((int)((y3 + y2)/4));
			drawTriangle(x1, y1, (x1 + x2)/2, corner1, (x1 + x3)/2, corner2, g);
			drawTriangle(x2, y2, (x2 + x1)/2, corner1, (x2 + x3)/2, corner3, g);
			drawTriangle(x3, y3, (x3 + x2)/2, corner3, (x1 + x3)/2, corner2, g);
		}
	}
	
	public void drawTriangle(int x1, int y1, int x2, int y2, int x3, int y3, Graphics g) {
//		if (l>= 1) {
//			g.setColor(Color.WHITE);
			g.drawLine(x1,y1,x2,y2);
			g.drawLine(x1,y1,x3,y3);
			g.drawLine(x2,y2,x3,y3);
//			l--;
//			drawTriangle((x3 + x2)/2, (y3 + y2)/2 + rand.nextInt(10), (x1 + x2)/2, (y1 + y2)/2 + rand.nextInt(10), (x1 + x3)/2, (y1 + y3)/2 + rand.nextInt(10), l, g);

//		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("My First Drawing");
		Canvas canvas = new mountain();
		canvas.setSize(800,800);
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);

	}
	
	public void paint(Graphics g) {
		this.setBackground(Color.BLACK);
		g.setColor(Color.WHITE);
//		drawMountain(400,20,10,420,790,420,4, rand.nextInt((int)(50))*randSgn(),50,50,g);
		drawMountain(400,20,10,420,790,420,5, 0,0,0,g);
		g.setColor(Color.RED);
		drawTriangle(400,20,10,420,790,420,g);
	}
}
