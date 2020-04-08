

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

public class NodePanel extends JPanel{ 

	 Node root;
	 List<Node> nodes = new ArrayList<Node>();
	 
	 public NodePanel() {
        super();
        setPreferredSize(new Dimension(800,500));
        setBackground(Color.LIGHT_GRAY);
        root = null;
	 }
	 
	 public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(0,0,getWidth(),getHeight());
        drawTree(root, g);
        setVisible(true);
	 }
	 	 
	 //use each node's saved width and height to get the x,y coordinates for drawing lines
	 public void drawTree(Node root, Graphics g) {
    	if(root != null) {
    		root.draw(g);
    		//draw line to left child
    		if(root.left != null) {
				g.drawLine(root.left.width+25, root.left.height, root.width+25, root.height+50);
    		}
			//draw line to right child
    		if(root.right != null) {
    			g.drawLine(root.right.width+25, root.right.height, root.width+25, root.height+50);
    		}
    		drawTree(root.left, g);
    		drawTree(root.right, g);
    	}
	 }
	 
	 public void insert(String key, int width, int height, int numCalls, int position) {
		 root = addNode(root, key, width, height, numCalls, position);
	 }
	  
	 //numCalls keeps track of the number of times addNode is called. It corresponds to the level of the tree we're on
	 //position keeps track of what position the node is at horizontally. 
	 //calculate width by W / (2^n + 1) * p
	 //where W = total width, n = level of the tree, p = position on that level
	 //numCalls always starts at 0, position always starts at 1
	 public Node addNode(Node root, String key, int width, int height, int numCalls, int position) {
	 	if(root == null) {
			root = new Node(this, width, height, key, position, numCalls);
			nodes.add(root);
			return root;
		}
	 	
	 	numCalls++;
	 	Integer rootKey = Integer.parseInt(root.key);
	 	Integer newKey = Integer.parseInt(key);
	 	
	 	int divisor = ((int)Math.pow(2, numCalls)+1);
		if(newKey < rootKey) {
			//each left child is going to be at position p*2-1
			position = position * 2 - 1;
			root.left = addNode(root.left, key, (800/divisor)*position, height+80, numCalls, position);
		} else {
			//each right child is going to be at position p*2
			position = position * 2;
			root.right = addNode(root.right, key, (800/divisor)*position, height+80, numCalls, position);
		}
		return root;
	 }
}

