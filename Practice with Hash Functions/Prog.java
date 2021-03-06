import java.lang.Integer;

public class Prog {

	public static void main(String [] args) {
		
		if (args.length != 2) {
			System.out.println("Please execute: java Prog <n> <p>");
			System.out.println("n is the input size, and p is the program number.");
			System.exit(0);
		}

		int n = Integer.parseInt(args[0]);
		int p = Integer.parseInt(args[1]);

		switch(p) {
			case 1: prog1(n);
							break;
			case 2: prog2(n);
							break;
			case 3: prog3(n);
							break;
			case 4: prog4(n);
							break;
			default: System.out.println("Invalid program number. Only 1-4.");
		}
	}

	private static void prog1(int n) {
		// TODO: Code to generate n keys that all get hashed to the same index using hash1.
		for (int i = 0; i < (n * n); i += n) {
			System.out.println(i);
		}
	}

	private static void prog2(int n) {
		// TODO: Code to generate n keys that all get hashed to the same index using hash2.
		for (int i = 0; i < n; i++) {
			System.out.println(i);
		}		    
	}

	private static void prog3(int n) {
		// TODO: Code to generate n keys that all get hashed to the same index using hash3.
		Node array[] = new Node[n];
		int size[] = new int[n];
		HashFunctions hash = new HashFunctions(n);
		int p = 128189;
		int index = 0;
		int a = 0;
		int inc = p;
		int num = 0;

//		for (int i = 0; (i < (n * n)) && (i < p); ++i) {
//			int z = hash.hash3(i);
//			size[z] += 1;
//			array[z] = new Node(i, array[z]);
//
//			if (size[z] > size[index]) {
///				index = z;
//			}
//		}	
		
//		while (array[index].key + (a * inc) < (n * n) && num < n) {
//			for (current = array[index]; current != null && ((a * inc) + current.key) < (n * n) && num < n; current = current.next, ++num) {
//				System.out.println((a * inc) + current.key);
//			}
			a++;
//		}
	}

	private static void prog4(int n) {
		// TODO: Code to generate n keys that all get hashed to the same index using hash4.
		Node array[] = new Node[n];
		HashFunctions hash = new HashFunctions(n);
		int size[] = new int[n];
		int index = 0;
		boolean tester = false;

		for (int i = 0; i < (n * n) && !tester; ++i) {
			int z = hash.hash4(i);
			size[z] += 1;
			array[z] = new Node(i, array[z]);
			
			if (size[z] == n) {
				index = z;
				tester = true;
			}
		}
		if (!tester) {
			System.out.println(":(");
		}	
	//	else {
	//		for (Node current = array[index]; current != null; current = current.next) {
	//			System.out.println(current.key);
	//		}
	//	}	
	}
}
