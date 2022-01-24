package u3; 
 
import java.awt.*; 
 
import javax.swing.JFrame; 
import java.util.*; 
 
public class mountain2 extends Canvas{ 
	static Random rand = new Random();  
	static int[] size;
	static ArrayList<ArrayList<int[]>> coords = new ArrayList<ArrayList<int[]>>(); 
	public static int randSgn() { 
		if(rand.nextInt(2) == 1)return 1; 
		else return -1; 
	} 
	 
 
	 
	public static int[] calcMountain(int x1, int y1, int x2, int y2, int x3, int y3, int l) { 
		int corner1 = (y1 + y2)/2; 
		int corner2 = (y1 + y3)/2; 
		l--; 
		if (l>= 1) { 
			return calcMountain(x1, y1, (x1 + x2)/2, corner1, (x1 + x3)/2, corner2, l);
		} 
		else { 

			return new int[]{(x3- x2)/2, corner1-y1};

		} 
	} 

	
	
	public static void fillArray(int[] dimensions, int middle, int height) {
		ArrayList<int[]> temp = new ArrayList<int[]>();
		for(int i = 0; i <= 400/size[1]+1; i++) {
			temp.clear();
			for(int j = 0; j < i; j++) {

				//ask why i have to do this  ( this being create the arrary then call it in add, not just create the array in the add
				int[] newDi= {(int)(middle - (i-1)/2.0*dimensions[0])+ dimensions[0]*j, (i-1)*dimensions[1]+height+rand.nextInt((int)(12))*randSgn()};
				temp.add(newDi);
//				int[] newDi = {0,0};
	
			}
			coords.add(new ArrayList<int[]>(temp));
		}
		System.out.println("out of loo " + coords.get(3).size());
		for(int i = 0; i < coords.size(); i++) {
//			System.out.println("out of loo " + coords.size());
			for(int j = 0; j < coords.get(i).size(); j++) {
				System.out.print(coords.get(i).get(j)[0] + " " + coords.get(i).get(j)[1] + " ");
				
			}
			System.out.print("\n");
			
		}
		
	}
	 
	public static void drawTriangle(int x1, int y1, int x2, int y2, int x3, int y3, Graphics g) { 
//		if (l>= 1) { 
//			g.setColor(Color.WHITE); 
			g.drawLine(x1,y1,x2,y2); 
			g.drawLine(x1,y1,x3,y3); 
			g.drawLine(x2,y2,x3,y3); 
//			l--; 
//			drawTriangle((x3 + x2)/2, (y3 + y2)/2 + rand.nextInt(10), (x1 + x2)/2, (y1 + y2)/2 + rand.nextInt(10), (x1 + x3)/2, (y1 + y3)/2 + rand.nextInt(10), l, g); 
 
//		} 
	} 
	
	public static void connect(Graphics g) {
		for(int i = 1; i < coords.size(); i++) {
//			System.out.println(coords.get(i).get(1) + " "+coords.get(i).get(1));
			for(int j = 0; j < coords.get(i).size(); j++) {
				System.out.println(coords.get(i).get(j)[0] + " "+coords.get(i).get(j)[1]);
				if(i !=coords.size()-1) {
					g.drawLine(coords.get(i).get(j)[0],coords.get(i).get(j)[1],coords.get(i+1).get(j)[0],coords.get(i+1).get(j)[1]);
					g.drawLine(coords.get(i).get(j)[0],coords.get(i).get(j)[1],coords.get(i+1).get(j+1)[0],coords.get(i+1).get(j+1)[1]);
				}
				if(j != coords.get(i).size() - 1)g.drawLine(coords.get(i).get(j)[0],coords.get(i).get(j)[1],coords.get(i).get(j+1)[0],coords.get(i).get(j+1)[1]);
			}
//			g.drawLine(coords.get(i).get(coords.get(i).size()-1)[0],coords.get(i).get(coords.get(i).size()-1)[1],coords.get(i+1).get(coords.get(i).size()-1)[0],coords.get(i+1).get(coords.get(i).size()-1)[1]);
		}
	}
	 
	public static void main(String[] args) { 
		size = calcMountain(400,20,10,420,790,420,5);
		fillArray(size, 400,20);
		JFrame frame = new JFrame("My First Drawing"); 
		Canvas canvas = new mountain2(); 
		canvas.setSize(800,800); 
		frame.add(canvas); 
		frame.pack(); 
		frame.setVisible(true); 
		
//		System.out.println(size[0]); 
		
 
	} 
	 
	public void paint(Graphics g) { 
		this.setBackground(Color.BLACK); 
		g.setColor(Color.WHITE); 
		
//		drawMountain(400,20,10,420,790,420,4, rand.nextInt((int)(50))*randSgn(),50,50,g); 
		connect(g);
		g.setColor(Color.RED); 
		drawTriangle(400,20,10,420,790,420,g); 
	} 
} 
