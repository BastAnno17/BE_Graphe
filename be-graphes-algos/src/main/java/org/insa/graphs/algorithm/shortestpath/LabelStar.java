package org.insa.graphs.algorithm.shortestpath;

public class LabelStar extends Label{
	
	double coutEstime;
	double coutTotal;
	
	public LabelStar(int s, boolean m, double c, int p, double ce, double ct) {
		super(s, m, c, p);
		this.coutEstime = ce;
		this.coutTotal = ct;
	}

	void setCoutEstime(double c){
		this.coutEstime = c;
	}
	
	void setCoutTotal(double c) {
		this.coutTotal = c;
	}
	
	double getCoutEstime() {
		return this.coutEstime;
	}
	
	double getCoutTotal() {
		this.coutTotal = this.getCoutEstime() + super.getCout();
		return this.coutTotal;
	}

	
	@Override
    public int compareTo(Label other) {
        return Double.compare(getCout(), other.getCout());
    }
}
