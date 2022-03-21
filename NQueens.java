import java.util.Scanner;
public class NQueens {
	public static int n;
	public static int [][] gb;

	public static int check_row(int row) {
		if (row >= n) {
			return 1;
		}

		int check = 0;
		for (int i = 0; i < n; ++i) {
			if(gb[row][i] == 0) {
				gameBoard(row, i, 1);
				check += check_row(row + 1);
				
				gameBoard(row, i, -1);	
			}
		}
		return check;
	}

	public static void gameBoard(int row, int col, int x) {
		for (int i = (row + 1), j = 1; i < n; ++i, ++j) {
				gb[i][col] += x;

				if((col + j) < n) {
					gb[i][(col + j)] += x;
				}
				if ((col - j) >= 0) {
					gb[i][(col - j)] += x;
				}
		}
	}

	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);

		System.out.print("Enter the number of queens: ");
		n = kb.nextInt();
		gb = new int[n][n];

		int checkX = check_row(0);
		System.out.println("The number of valid arrangements is " + checkX);		
	}
}


