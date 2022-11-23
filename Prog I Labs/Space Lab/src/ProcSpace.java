
public class ProcSpace {
	private double start;
	private double end;
	private int slices;


	public void setStart(double input) {
		start = input;
	}

	public void setEnd(double input2) {
		end = input2;
	}

	public void setSlices(int input3) {
		slices = input3;
	}

	public double getDist() {;
		return (end - start);
	}

	public double getSliceWidth() {
		return getDist()/slices;
	}

	public double getArea() {
		double area=0;
		for (int n = 1; n <= slices; n++) {
			area = area + Math.abs((getSliceWidth()*Math.sin(start+n*getSliceWidth())));
		}

		return area;
	}
}
