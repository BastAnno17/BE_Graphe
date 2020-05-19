package org.insa.graphs.algorithm.shortestpath;

//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Vector;

//import org.insa.graphs.algorithm.AbstractSolution.Status;
import org.insa.graphs.algorithm.utils.BinaryHeap;
import org.insa.graphs.model.Arc;
//import org.insa.graphs.model.Graph;
//import org.insa.graphs.model.Node;
//import org.insa.graphs.model.Path;

public class AStarAlgorithm extends DijkstraAlgorithm {

    public AStarAlgorithm(ShortestPathData data) {
        super(data);
    }


    @Override
    public void marquage(Label x, Label y, Arc successeurs, int indexX, BinaryHeap<Label> tas) {
    	
    	successeurs.getDestination().getPoint();
    	
		if (y.getMarque() == false) {
			   
			if (y.getCoutTotal() > x.getCoutTotal() + successeurs.getLength()) {
				y.setCout(x.getCout() + (int)successeurs.getLength());  //TO DO:
				y.setPere(indexX);
				try{
					tas.remove(y);
				}catch(Exception ElementNotFoundException) {}
				tas.insert(y);
				   
			}
		}
    }
}
