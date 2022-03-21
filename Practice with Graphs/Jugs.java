import java.util.Scanner;

public class Jugs {
	private static int N;
	private static int A;
	private static int B;
	private static int C;

	private static boolean [][] visited;
	private static int [][] predA;
	private static int [][] predB;
	private static int goalA;
	private static int goalB;
	private static String [][] format;

	private static boolean dfs(int x, int y, int predX, int predY, String list) {
		if (x < 0 || x > A || y < 0 || y > B) {
			return false;
		}
		if (visited[x][y]) {
			return false;
		}

		visited[x][y] = true;
		predA[x][y] = predX;
		predB[x][y] = predY;
		format[x][y] = list;

		if ((x + y) == C) {
			goalA = x;
			goalB = y;
			return true;
		}	
		
		boolean ret = dfs(A, y, x, y, "Fill Jug 1");
		ret = ret | dfs(x, B, x, y, "Fill Jug 2");
		ret = ret | dfs(0, y, x, y, "Empty Jug 1");
		ret = ret | dfs(x, 0, x, y, "Empty Jug 2");

		int z = 0;

		if (x < (B - y)) {
			z = x;
		}
		else { 
			z = (B - y);
		}
		
		ret = ret | dfs((x - z), (y + z), x, y, "Pour Jug 1 -> Jug 2");
		
		if (y < (A - x)) {
			z = y;
		}
		else {
			z = (A - x);
		}
		
		ret = ret | dfs((x + z), (y - z), x, y, "Pour Jug 2 -> Jug 1");
		
		return ret;
	}

	private static void print(int x, int y) {
		if (x == 0 && y == 0) {
			return;
		}

		print(predA[x][y], predB[x][y]);
		System.out.println(format[x][y] + " [a = " + x + ", b = " + y + "]");
	}
	
	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter A: ");
		A = kb.nextInt();
		System.out.print("Enter B: ");
		B = kb.nextInt();
		System.out.print("Enter C: ");
		C = kb.nextInt();

		N = 1000;
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				visited[i][j] = false;
		predA = new int[N][N];
		predB = new int[N][N];
		format = new String[N][N];

		boolean possible = dfs(0, 0, -1, -1, "");
		if (possible) {
			System.out.println("Yay! Found a solution.");
			print(goalA, goalB);
		}
		else
			System.out.println("Impossible!");

	}
}
