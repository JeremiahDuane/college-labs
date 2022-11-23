
public class ProbabilityCalcProcessing {
	double headFlips, totalFlips, halfExp, mixedN;
	double totalFact=1;
	double headsFact=1;
	double mixedFact=1;
	 
	public double getProbability() {
		
		mixedN = (totalFlips-headFlips);
		
		for (double n = 1; n <= totalFlips; n++) {
			totalFact=totalFact*n;	
			}
		for (double n = 1; n <= headFlips; n++) {
			headsFact= headsFact*n;	
			}
		for (double n = 1; n <= mixedN; n++) {
			mixedFact=mixedFact*n;	
			}
		
		return ((Math.pow((.5), totalFlips))*totalFact)/(headsFact*mixedFact);
	}
}
