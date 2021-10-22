package unit_1;

import java.awt.*;
public class Planets {
	private int x, y;
    private Graphics g;
    private static int sun_size = 50;

    public Planets(int x, int y, Graphics g) {
        this.x = x;
        this.y = y;
        this.g = g;
    }
    
    public void drawSun() {
        Color sunColour = new Color(242,244,255);
        g.setColor(sunColour);
        g.fillOval(x, y, sun_size, sun_size);
    }
    
    public void drawEarth() {
        
        Color water = new Color(11,12,117);
        g.setColor(new Color(242, 244,255));
        g.fillOval(x - 3, y - 3, 154, 154);
        g.setColor(water);
        g.fillOval(x, y, 150, 150);
    }
    public void drawLight() {
    	int start_r = 242, start_g = 244, start_b = 255, b = 255, r = 0, g = 0;
    	int size = sun_size +255, size_inc = 2;
    	int i = 0;
    	double percent =0;
    	while(i <=254) {
    		r = (int)(Math.pow(i,3)/Math.pow(242.0,2));
    		g = (int)(Math.pow(i,3)/Math.pow(244.0,2));
    		b = (int)(Math.pow(i,3)/Math.pow(255.0,2));    		
    		if(r > start_r)r=start_r;
    		if(g >start_g)g=start_g;
    		if(b >start_b)b = start_b;
    		size -= size_inc;
    		i+=size_inc;
    		this.g.setColor(new Color(r,g,b));
    		this.g.fillOval(this.x - (size-sun_size)/2,this.y - (size-sun_size)/2,size,size);
    	}
    }
}
