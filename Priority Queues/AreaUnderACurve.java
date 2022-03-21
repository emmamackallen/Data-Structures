import java.util.Scanner;

public class AreaUnderACurve {
	
	public static double newArea = 0.0;

	/**
		The function f(x) = x^2 + x + 1.
	*/
	private static double f(double x) {
		return x * x + x + 1; 
	}

	/**
		Returns an approximation for the area under the curve f(x) between x = a and x = b.
	*/
	private static double computeArea(double a, double b) {
		double error = 1e-08; // This is the comparison error. See document for description.

		// TODO: Please compute an approximation for the area under the curve here.
		Interval x = new Interval(a, b);		
		double prevArea = (b - a) * f(b);

		do {

			double a1 = x.getStart();
			double b1 = x.getEnd();
			
			double fa1 = f(a1);
			double fb1 = f(b1);

			double p = ((a1 + b1) / 2.0);

			double fp = f(p);

			newArea = prevArea - ((b1 - a1) * fb1) + ((p - a1) * f(p)) + ((b1 - p) * f(b1));
			if (Math.abs(newArea - prevArea) < error) {
				return newArea;
			}

			prevArea = newArea;
		}		
		while(Math.abs(newArea - prevArea) > error);

		return newArea;	 // Remove this statement and return the computed area.
	} 

	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("We have the function f(x) = x^2 + x + 1.");
		System.out.print("Please enter lower value a: ");
		double a = kb.nextDouble();
		System.out.print("Please enter upper value b: ");
		double b = kb.nextDouble();

		double area = computeArea(a, b);
		System.out.println("\nAn approximation for the area under the curve f(x) \nbetween a = " + a + " and b = " + b + " is " + area);
	}
}
