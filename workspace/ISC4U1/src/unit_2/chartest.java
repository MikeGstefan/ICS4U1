package unit_2;

import java.awt.*;

import javax.swing.JFrame;

public class chartest extends Canvas{

	public static void main(String[] args) {
		JFrame frame = new JFrame("");
		Canvas canvas = new chartest();
		canvas.setSize(200,200);
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);
		
//		System.out.print(Vector.vector_add(new Vector(10,0), new Vector(10,90)));
		

	}
	public void paint(Graphics g) {
		this.setBackground(Color.WHITE);
		Character test = new StefanChar(100,100,g);
		test.draw();
	}
}
