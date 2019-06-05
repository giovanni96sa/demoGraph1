package giorgio.graphic;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String basePath = new File("").getAbsolutePath();
			    	BufferedImage img=ImageIO.read(new File(basePath+"\\src\\giorgio\\graphic\\mappa.jpg"));
			        
			    	ImageBuffer i = new ImageBuffer(img);
			        int height = img.getHeight();
			        int width = img.getWidth();
			        JFrame frame=new JFrame();
			        frame.setSize(height,width);
			        
			        frame.setResizable(false);
			        JMenuBar jmb = new JMenuBar();
			        JMenu elemento = new JMenu("Menu");
			        JMenuItem itemVertice = new JMenuItem("Aggiungi Vertice");
			        itemVertice.addActionListener(new ActionListener() {
			             
			            public void actionPerformed(ActionEvent e) {
			                       i.disegnaNodo();     
			            }
			        });
			        JMenuItem itemArco = new JMenuItem("Aggiungi Arco");
			        itemArco.addActionListener(new ActionListener() {
	
			        	public void actionPerformed(ActionEvent e) {
		                           i.disegnaArchi(); 
		            	}
			        });
			        JMenuItem itemSalvaGrafo = new JMenuItem("Salva Grafo");
			        itemSalvaGrafo.addActionListener(new ActionListener() {
			             
			            public void actionPerformed(ActionEvent e) {
			                       try {
									i.salvaGrafo();
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}     
			            }
			        });
			        elemento.add(itemVertice);
			        elemento.add(itemArco);
			        elemento.add(itemSalvaGrafo);
			        jmb.add(elemento);
			        frame.setJMenuBar(jmb);
			        
			        
			        frame.getContentPane().add(i);
			        
			        frame.setVisible(true);
			        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		
		
	}

}
