package giorgio.graphic;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

public class Frame {

	private JFrame frame;

	    public static void main(String[] args) throws IOException 
	    {
	    	String basePath = new File("").getAbsolutePath();
	    	System.out.println(basePath+"src/giorgio/graph/mappa.jpg");
	    	BufferedImage img=ImageIO.read(new File(basePath+"\\src\\giorgio\\graphic\\mappa.jpg"));
	        
	    	ImageBuffer i = new ImageBuffer(img);
	   
	    	
	    	
	        int height = img.getHeight();
	        int width = img.getWidth();
	        JFrame frame=new JFrame();
	        frame.setSize(height,width);
	        frame.setResizable(false);
	        frame.add(i);
	        frame.setVisible(true);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }

	/**
	 * Create the application.
	 */
	public Frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	

}
