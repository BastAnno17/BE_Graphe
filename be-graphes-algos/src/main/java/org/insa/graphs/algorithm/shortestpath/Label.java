package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.model.Node;

public class Label implements Comparable<Label> {
	private int sommetCourrant;
	private boolean marque;
	private double cout;
	private int pere;
	
	public Label(int s, boolean m, double c, int p) {
		this.sommetCourrant = s;
		this.marque = m;
		this.cout = c;
		this.pere = p;
	}
	
	public double getCout() {
		return this.cout;
	}
	
	public void setCout(double c) {
		this.cout = c;
	}
	
	public void setMarque(boolean m) {
		this.marque = m;
	}
	
	public boolean getMarque() {
		return this.marque;
	}
	
	public int getSommet() {
		return this.sommetCourrant;
	}
	
	public int getPere() {
		return this.pere;
	}
	
	@Override
    public int compareTo(Label other) {
        return Double.compare(getCout(), other.getCout());
    }
}
