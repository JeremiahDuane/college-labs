import java.util.Scanner;


public class ProbabilityCalc {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		ProbabilityCalcProcessing processing = new ProbabilityCalcProcessing(); 
		 
		System.out.println("Please enter the total number of flips: ");
		processing.totalFlips = keyboard.nextDouble();
		System.out.println("Please enter the total number of heads flipped: ");
		processing.headFlips = keyboard.nextDouble();
		System.out.println("Your probability is: " + processing.getProbability());
		
		
		keyboard.close();
	}

}
