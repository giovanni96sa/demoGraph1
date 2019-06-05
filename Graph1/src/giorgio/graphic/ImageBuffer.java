package giorgio.graphic;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import giorgio.graph.Graph;
import giorgio.DAO.GraphDAO;
import giorgio.graph.Nodo;
import giorgio.graph.SparseGraph;

public class ImageBuffer  extends JPanel implements MouseListener, MouseMotionListener{


	private static final long serialVersionUID = 1L;

	int mouse_x, mouse_y; 
	String modifierKeys = ""; 
	String operation;
	Nodo n1;
	Nodo n2;
	private int x1, y1;

	BufferedImage image;
	//Dimension size = new Dimension();  //  @jve:decl-index=0:
	String imgFile;
	//  private String dir = null;
	int amt_input=0;
	int radius =15;
	private SparseGraph<Nodo, String> grafo; 

	public ImageBuffer (BufferedImage image) {
		n1 = null;
		n2 = null;
		this.image = image;
		int height = image.getHeight();
		int width = image.getWidth();
		this.setSize(height,width);
		ImageIcon icon=new ImageIcon(image);
		
		JLabel lbl=new JLabel();
		lbl.setIcon(icon);
		this.add(lbl);
		
		operation = "vertex";
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		grafo = new SparseGraph<Nodo, String>();

	}
	
	public void disegnaNodo() {
		operation = "vertex";
	}

	public void disegnaArchi() {
		operation = "edge";
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int x;
		int y;
		x = e.getX(); 
		y = e.getY();
		if(operation.equals("vertex")) {
			//drawCircle(e.getX()-(radius/2), e.getY()-(radius/2));
			drawCircle(e.getX(), e.getY());
			grafo.addVertex(new Nodo(x, y));
		}
		else if(operation.equals("edge")) {
			
			ArrayList<Nodo> nodi = grafo.vertices();
			if(n1 != null) {
				for(Nodo n: nodi) {
					if(verticeCliccato(x, y, n)) {
						drawEdge(n1.getX(), n1.getY(), n.getX(), n.getY());
						//grafo.addEdge(n1, n, "");
						grafo.addUndirectedEdge(n1, n, "");
						n1 = null;
					}
				}
			}
			else {
				for(Nodo n: nodi) {
					if(verticeCliccato(x, y, n)) {
						n1 = n;
					}
				}
			}
		
		}

	}
	
	public boolean verticeCliccato(int x, int y, Nodo n) {
		double distanza = Math.sqrt(
			    Math.pow(x - n.getX(), 2) +
			    Math.pow(y - n.getY(), 2)
			);
		if(distanza <= radius) {
			return true;
		}
		return false;
	}
	
	private void setX1(int x1) {
		this.x1 = x1;
	}
	private void setY1(int y1) {
		this.y1 = y1;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {

	}

	private void drawCircle(int x, int y) {

		Graphics g = getGraphics();
		
		g.drawOval(x - radius , y - radius, 2 * radius, 2 * radius);
		
		g.setColor(Color.BLACK);
		g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);

	}
	private void drawEdge(int x1, int y1, int x2, int y2) {
		Graphics g = getGraphics();
		
		g.drawLine(x1, y1, x2, y2);
		g.setColor(Color.GREEN);
		
	}

	public void salvaGrafo() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Nella funzione");
		GraphDAO dao = new GraphDAO();
		dao.create(grafo);
		
	}
}