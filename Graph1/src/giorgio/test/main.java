package giorgio.test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import giorgio.DAO.GraphDAO;
import giorgio.graph.*;


public class main {
	public static void main(String[]args) throws IOException, SQLException{
		
		GraphDAO dao = new GraphDAO();
		
		Graph<Nodo, String> grafo = dao.read(55);
		Nodo n = grafo.vertices().get(0);
		
		GraphVisitImplements<Nodo, String> gv = new GraphVisitImplements<Nodo, String>();
		VertexAnalyserImplements<Nodo> va = new VertexAnalyserImplements<Nodo>();
		System.out.println("visita in profondità");
		gv.depthFirst(grafo, n, va);
		System.out.println("visita in ampiezza");
		gv.breadthFirst(grafo, n, va);
		
	}
	

	
}
