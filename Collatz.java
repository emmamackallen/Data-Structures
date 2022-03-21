import java.util.Scanner;

public class Collatz {
	public static int n = 100000000;
	public static int [] vals;


	public static int collatzLength(long i) {
		if (i < 1) {
			return 0;
		}

		int size = (int)i;
		if (i < n) {
			if (vals[size] != 0) {
				return vals[size];
			}
		}

		int length = 0;
		if ((i % 2) == 0) {
			length = collatzLength(i / 2) + 1;
		}
		else {
			length = collatzLength((3 * i) + 1) + 1;
		}
		if (i < n) {
			vals[size] = length;
		}

		return length;	

	}
	
	public static void main(String [] args) {
		vals = new int[n];
		vals[1] = 1;

		Scanner kb = new Scanner(System.in);
		System.out.print("Enter the range: ");
		int a = kb.nextInt();
		int b = kb.nextInt();
		int max = a;

		int x = collatzLength(a);
		for (int i = (max + 1); i <= b; ++i) {
			int size = collatzLength(i);
			if (size > x) {
				max = i;
				x = size;
			}
		}
		
		System.out.println("The number with the maximum Collatz length in the range: " + max);
		System.out.println("Its Collatz length: " + x);
	}		
}
