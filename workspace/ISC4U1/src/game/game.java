package game;


import java.awt.*;
import javax.swing.JFrame;

public class game extends Canvas{

	public static void main(String[] args) {
		JFrame frame = new JFrame("");
		Canvas canvas = new game();
		canvas.setSize(400,400);
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);
		
//		System.out.print(Vector.vector_add(new Vector(10,0), new Vector(10,90)));
		

	}
	public void paint(Graphics g) {
		this.setBackground(Color.WHITE);
		Element test = new Element(100,100,30,Color.BLACK,g );
		
	}

}
