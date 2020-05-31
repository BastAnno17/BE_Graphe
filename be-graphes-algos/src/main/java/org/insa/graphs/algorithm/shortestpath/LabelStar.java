package org.insa.graphs.algorithm.shortestpath;

public class LabelStar extends Label {
	
	double coutEstime;
	double coutTotal;
	
	public LabelStar(int s, boolean m, double c, int p, double ce, double ct) {
		super(s, m, c, p);
		this.coutEstime = ce;
		this.coutTotal = ct;
	}

	public void setCoutEstime(double c){
		this.coutEstime = c;
	}
	
	public void setCoutTotal(double c) {
		this.coutTotal = c;
	}
	
	public double getCoutEstime() {
		return this.coutEstime;
	}
	
	public double getCoutTotal() {
		calculateCoutTotal();
		return this.coutTotal;
	}
	
	public void calculateCoutTotal() {
		this.coutTotal = this.getCoutEstime() + super.getCout();
	}

	
	@Override
    public int compareTo(Label o) {
		LabelStar other = (LabelStar) o;
        return Double.compare(getCoutTotal(), other.getCoutTotal());
    }
}
