

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class MainFrame extends JFrame{

	NodePanel nodePanel = new NodePanel();
	
	public MainFrame() throws FileNotFoundException, InterruptedException {
		super("MainFrame");
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		getContentPane().add(nodePanel);
		pack();
		
		File inFile = new File("bst.txt");
		Scanner input = new Scanner(inFile);
		int width = 400;
		int height = this.getHeight() - 490;//10
		String s = input.next();
		
		//insert the root node
		nodePanel.insert(s, width, height, 0, 1);
		
		//populate the rest of the tree
		while(input.hasNext()) {
			String keyString = input.next();
			nodePanel.insert(keyString, width, height, 0, 1);
		}
		input.close();
		
		
		//nodePanel.preorderTraversal();
		
	}
}
