package unit_1;


import java.awt.*;
import javax.swing.JFrame;
public class world extends Canvas{

	public static void main(String[] args) {
		JFrame frame = new JFrame("My First Drawing");
		Canvas canvas = new world();
		canvas.setSize(500,600);
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);

	}
	
	public void paint(Graphics g) {
		this.setBackground(Color.WHITE);
		stoplight test = new stoplight();
		test.draw_light(100, 0, g);
		test.goGreen(100,0,g);
	}

}
