package game;


import java.awt.*;
import javax.swing.JFrame;

public class game extends Canvas{

	public static void main(String[] args) {
		JFrame frame = new JFrame("My First Drawing");
		Canvas canvas = new game();
		canvas.setSize(1000,600);
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);

	}
	public void paint(Graphics g) {
		this.setBackground(Color.WHITE);
		
	}

}
