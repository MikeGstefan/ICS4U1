package unit_1;

import java.awt.*;

import javax.swing.JFrame;
public class Walle extends Canvas{

	public static void main(String[] args) {
		JFrame frame = new JFrame("My First Drawing");
		Canvas canvas = new Walle();
		canvas.setSize(800,800);
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);

	}
	public void paint(Graphics g) {
//		this.setBackground(Color.BLACK);
		Stars star = new Stars(800,370,g,200,1,3);
		star.draw_stars();
		Planets planet = new Planets(110, 70, g);
		planet.drawLight();
	    planet.drawSun();
	    planet.drawEarth();
	    
		
		g.fillRect(250,250,300,300);
		Eyes right_eye = new Eyes(410,60,g, true);
		Eyes left_eye = new Eyes(230,60,g,false);
		Neck neck = new Neck(400,250,g);
		
		neck.draw_neck();
		right_eye.draw_eyes();
		left_eye.draw_eyes();
	}
}
