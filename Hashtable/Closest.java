import java.lang.Math.*;
import java.util.Scanner;

public class Closest {
	private static Node[][] grid;
	private static double minDist;

  	private static double calculate(double x, double y, double x1, double y1) {
    
		return Math.sqrt(Math.pow(x1 - x, 2) + Math.pow(y1 - y, 2));
  	}

	private static void compare(int i, int j, double x, double y) {
   
		for (Node curr = grid[i][j]; curr != null; curr = curr.next) {
			double newCalc = calculate(x, y, curr.x, curr.y);
		
			if (newCalc < minDist) {
				 minDist = newCalc;
			}
		}
  	} 

  	public static void main(String [] args) {

    		int z = 1000;
    		double x = 0;
		double y = 0;

    		Scanner kb = new Scanner(System.in);
    		grid = new Node[z][z];

    		minDist = 1.0;

    		while (kb.hasNextDouble()) {
      			x = kb.nextDouble();
      			y = kb.nextDouble();

      			int a = (int) (x * z);
      			int b = (int) (y * z);
      			compare(a, b, x, y);

      			if ((a - 1) >= 0) {
				compare(a - 1, b, x, y);
			}
			if ((a + 1) < z) {
				compare(a + 1, b, x, y);
			}
			if ((b - 1) >= 0) {
				compare(a, b - 1, x, y);
			}
			if ((b + 1) < z) {
				compare(a, b + 1, x, y);
			}
      			if (((a - 1) >= 0) && ((b - 1)  >= 0)) {
				compare(a - 1, b - 1, x, y);
			}
			if (((a - 1) >= 0) && ((b + 1) < z)) {
 				compare(a - 1, b + 1, x, y);
			}
      			if (((a + 1) < z) && ((b - 1) >= 0)) {
 				compare(a + 1, b - 1, x, y);
			}
      			if (((a + 1) < z) && ((b + 1) < z)) {
				compare(a + 1, b + 1, x, y);
			}

			grid[a][b] = new Node(x, y, grid[a][b]);

    		}
		System.out.println("The closest pair of points is: " + minDist);

	}
}
