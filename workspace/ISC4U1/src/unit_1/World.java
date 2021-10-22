package unit_1;


import java.awt.*;
import javax.swing.JFrame;
/**
 *draws stoplight
 * @author mike stefan
 * @version 00/19
 */
public class World extends Canvas{

	public static void main(String[] args) {
		JFrame frame = new JFrame("My First Drawing");
		Canvas canvas = new World();
		canvas.setSize(1000,1000);
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);

	}
	/**
	 * draws
	 */
	public void paint(Graphics g) {
		this.setBackground(Color.WHITE);
		Stoplight test = new Stoplight(10,10,g);
		Stoplight test2 = new Stoplight(300,10,g);
		test.draw_light();
		test.goGreen();
		test2.draw_light();
		test2.goRed();
		
	}

}
