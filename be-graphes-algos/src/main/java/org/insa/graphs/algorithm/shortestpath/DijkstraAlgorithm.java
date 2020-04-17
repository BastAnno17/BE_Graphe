package org.insa.graphs.algorithm.shortestpath;
import java.util.Vector;
import org.insa.graphs.algorithm.utils.BinaryHeap;
import org.insa.graphs.model.Node;
import org.insa.graphs.model.Arc;

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
       }
       
       System.out.println("ICI");
       return solution;
    }

}
