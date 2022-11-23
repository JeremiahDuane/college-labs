import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Proc proc = new Proc();

		System.out.println("Input the test accuracy level.  Please enter as decimal number.");
		proc.setEff(keyboard.nextDouble());
		System.out.println("What is the probability of having the disease? Enter as decimal");
		proc.setProb(keyboard.nextDouble());
	
		System.out.println("Your Probability is: " + proc.getTotalProb());

		keyboard.close();
	}

}
