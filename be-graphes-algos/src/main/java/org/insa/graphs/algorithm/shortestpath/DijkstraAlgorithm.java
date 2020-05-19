package org.insa.graphs.algorithm.shortestpath;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import org.insa.graphs.algorithm.AbstractSolution.Status;
import org.insa.graphs.algorithm.utils.BinaryHeap;
import org.insa.graphs.model.Node;
import org.insa.graphs.model.Path;
import org.insa.graphs.model.Arc;
import org.insa.graphs.model.Graph;


public class DijkstraAlgorithm extends ShortestPathAlgorithm {

    public DijkstraAlgorithm(ShortestPathData data) {
        super(data);
    }

    @Override
    protected ShortestPathSolution doRun() {
        final ShortestPathData data = getInputData();
        ShortestPathSolution solution = null;
        // TODO:
        
        int taille = data.getGraph().getNodes().size();
        BinaryHeap<Label> tas = new BinaryHeap<Label>();
        Vector<Label> label = new Vector<Label>();
        
        //INITIALISATION
        for (int i = 0; i < taille; i++){
     	   Label aAjouter = new Label(i, false, Double.POSITIVE_INFINITY, -1);
     	   label.add(aAjouter);
        }
        
        int origine = data.getGraph().getNodes().indexOf(data.getOrigin());
        label.get(origine).setCout(0);
        tas.insert(label.get(origine));
        // FIN INITIALISATION
        
        int nbArc = 0;
        int nbIter = 0;
        
        
        //ITERATION
        while((label.get(data.getGraph().getNodes().indexOf(data.getDestination())).getMarque() == false) && true){ // true -> a completer : "file" non vide
     	   Label x = tas.deleteMin();
     	   int indexX = x.getSommet();
           x.setMarque(true);
           //notifyNodeReached(data.getGraph().getNodes().get(x.getSommet()));
     	   for (Arc successeurs :  data.getGraph().getNodes().get(indexX).getSuccessors()) {
     		   nbIter += 1;
     		   notifyNodeReached(successeurs.getDestination());
     		   
     		   if(data.isAllowed(successeurs)) {
     			   
     		   }
     		   
     		   Node noeudSuiv = successeurs.getDestination(); //ancien y
     		   Label y = label.get(noeudSuiv.getId());

     		   
     		   marquage(x, y, successeurs, indexX, tas);
     	   }
        }
        
       Graph graph = data.getGraph();
       
       
       if (label.get(data.getGraph().getNodes().indexOf(data.getDestination())).getMarque() == false) {
           solution = new ShortestPathSolution(data, Status.INFEASIBLE);
       }
       else {
    	   ArrayList<Arc> arcs = new ArrayList<>();
           Arc arc;
            
            int x = data.getGraph().getNodes().indexOf(data.getDestination()); //x un point et X son label
            Label X = label.get(x);
            while(X.getPere() != -1) {
            	for (Arc successeurs :  data.getGraph().getNodes().get(X.getPere()).getSuccessors()) {
            		if( successeurs.getDestination() == data.getGraph().getNodes().get(x)) {
            			arc = successeurs;
            			arcs.add(arc);
            			nbArc += 1;
            		}
            	}
            	x = X.getPere();
            	if(x != -1) {
            		X = label.get(x);
            	}
            }
            
            Collections.reverse(arcs);
            
            solution = new ShortestPathSolution(data, Status.OPTIMAL, new Path(graph, arcs));
       }
       
       System.out.println(nbIter);
       System.out.println(nbArc);
       return solution;
    }
    
    
    public void marquage(Label x, Label y, Arc successeurs, int indexX, BinaryHeap<Label> tas) {
		if (y.getMarque() == false) {
			   
			if (y.getCoutTotal() > x.getCoutTotal() + successeurs.getLength()) {
				y.setCout(x.getCout() + (int)successeurs.getLength());  //TO DO:
				y.setPere(indexX);
				try{
					tas.remove(y);
				}catch(Exception ElementNotFoundException) {}
				tas.insert(y);
				
				//System.out.println(successeurs.getDestination().getPoint());
			}
		}
    }

}


/* int taille = data.getGraph().getNodes().size();
BinaryHeap<Node> tas = new BinaryHeap<Node>();
Vector<Label> label = new Vector<Label>();

//INITIALISATION
for (int i = 0; i < taille; i++){
	   Label aAjouter = new Label(i, false, Double.POSITIVE_INFINITY, 0);
	   label.add(aAjouter);
}

int origine = data.getGraph().getNodes().indexOf(data.getOrigin());
label.get(origine).setCout(0);
tas.insert(data.getGraph().getNodes().get(origine));
// FIN INITIALISATION

//ITERATION
while((label.get(data.getGraph().getNodes().indexOf(data.getDestination())).getMarque() == false) && true){ // true -> a completer : "file" non vide
	   Node x = tas.deleteMin();
	   int indexX = data.getGraph().getNodes().indexOf(x);
    label.get(indexX).setMarque(true);
    
	   for (Arc successeurs :  data.getGraph().getNodes().get(indexX).getSuccessors()) {
		   System.out.println("ICIiii");
		   Node y = successeurs.getDestination();
		   int indexY = data.getGraph().getNodes().indexOf(y);
		   if (label.get(indexY).getMarque() == false) {
			   
			   if (label.get(indexY).getCout() > label.get(indexX).getCout() + successeurs.getLength()) {
				  
				   label.get(indexY).setCout(label.get(indexX).getCout() + successeurs.getLength());
				   System.out.println("la");
				   tas.remove(y);
				   System.out.println("la");
				   tas.insert(y);
				   System.out.println("la");
				   
			   }
		   }
	   }
} */