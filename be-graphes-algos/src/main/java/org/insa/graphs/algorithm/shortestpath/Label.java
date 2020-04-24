package org.insa.graphs.algorithm.shortestpath;

public class Label {
	private int sommetCourrant;
	private boolean marque;
	private double cout;
	private int père;
	
	public Label(int s, boolean m, double c, int p) {
		this.sommetCourrant = s;
		this.marque = m;
		this.cout = c;
		this.père = p;
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
}
