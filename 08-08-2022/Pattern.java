import java.util.Scanner;

public class Pattern {
    public static void main(String[] args) {
	int[][] pattern = new int[][]{{1,0,0,0},{1,1,0,0},{0,1,1,0},{0,0,1,1}};
        int row = 0;
        int column = 0;
	
	while (column < pattern[0].length-1 || row < pattern.length-1) {
	    if (pattern[row][column] == 1) {
		if (pattern[row][column + 1] == 1) {
		    column++;
		    System.out.print("R");
		} else if (pattern[row + 1] [column + 1] == 1) {
		    row++;
		    System.out.print("D");
		}
	    }
	}
    }
}
		
	    