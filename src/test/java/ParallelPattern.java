import java.util.*;

public class ParallelPattern {

	public static void main(String[] args) {
		// Write your code here

		Scanner sc = new Scanner(System.in);
		int numOfRows = sc.nextInt();
		int row, col;
		for (row = 1; row <= numOfRows; row++) {
			for(int i=0;i<row-1;i++){
				System.out.print(" ");	
			}
			for (col = 1; col <= numOfRows; col++) {
					System.out.print("*");
			}
			System.out.println();
		}
	}
}
