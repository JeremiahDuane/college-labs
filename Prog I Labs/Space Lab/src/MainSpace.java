import java.util.Scanner;

public class MainSpace {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		ProcSpace proc = new ProcSpace();

		System.out.println("Enter the starting value: ");
		proc.setStart(keyboard.nextDouble());
		System.out.println("Enter the ending value: ");
		proc.setEnd(keyboard.nextDouble());
		System.out.println("Enter the number of slices:  ");
		proc.setSlices(keyboard.nextInt());
		
		System.out.println("Your area estimate is: " + proc.getArea());

		keyboard.close();
	}

}
