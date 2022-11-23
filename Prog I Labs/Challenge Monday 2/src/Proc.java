
public class Proc {
	private double prob, totalProb;
	private double eff;

	public void setEff(double input1) {
		eff = input1;

	}

	public void setProb(double input2) {
		prob = input2;
	}

	public double getTotalProb() {
		totalProb = (eff*prob)/((eff*prob)+((1-eff)*(1-prob)));

		return totalProb;
	}
}
