import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Node extends JPanel{
	
	int width;
	int height;
	String key;
	JPanel panel;
	Node left;
	Node right;
	int position;
	int level;
	
	public Node(JPanel panel, int width, int height, String key, int position, int level) {
		this.key = key;
		this.width = width;
		this.height = height;
		this.panel = panel;
		this.position = position;
		this.level = level;
		this.left = this.right = null;
	}
	
	public void draw(Graphics g) {
	    g.drawString(key, width+18, height+30);
        g.drawOval(width, height, 50, 50);
    }
	
	public void drawFilled(Graphics g) {       
        g.setColor(Color.GREEN); 
        g.drawOval(width, height, 50, 50);
        g.fillOval(50,50,20,20);
        g.drawString(key, width+18, height+30);
	}
}
