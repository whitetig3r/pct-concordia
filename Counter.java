import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;

public class Counter {
	static Scanner sc = new Scanner(System.in);
	public static int countOccurences(int[][] grid,int mRow,int mCol, int tRow, int tCol) {
		int ctr = 0;
		for(int i=0;i<mRow;i++) {
			for(int j=0;j<mCol;j++) {
				if(grid[i][j] == 1) {
					boolean w,x,y,z;
					w=true;
					x=true;
					y=true;
					z=true;
					for(int k=0;k<tRow;k++) {
						for(int l=0;l<tCol;l++) {
							if(i+k<mRow && j+l<mCol) {
								if(grid[i+k][j+l]==1) {
									//start 0 padding check
									if((i>0) && k==0) {
										//first row
										if(grid[i+k-1][j+l] !=0 ) w=false;
									}
									if(i+k<mRow-1 && k==tRow-1) {
										//last row
										if(grid[i+k+1][j+l] !=0 ) x=false;
									}
									if(j>0 && l==0) {
										//first col
										if(grid[i+k][j+l-1] != 0) y=false;
									}
									if(j+l<mCol-1 && l==tCol-1) {
										//last col
										if(grid[i+k][j+l+1] != 0) z=false;
									}
								}else {x=false;}
							}else {w=false;}
						}		
					}
					if(w&&x) {
						if(y&&z) {
							ctr++;
						}
					}
				}
			}
		}
		return ctr;
	}
	
	public static void main(String[] args) {
		String gridSize = sc.nextLine();
		int n = Integer.parseInt(gridSize.split("x")[0]);
		int m = Integer.parseInt(gridSize.split("x")[1]);
		int[][] grid = new int[n][m];
		for(int i=0;i<n;i++) {
			String row = sc.nextLine();
			for(int j=0;j<m;j++) {
				grid[i][j] = row.charAt(j) == '0' ? 0 : 1;
			}
		}
		// take tests inp
		int tests = Integer.parseInt(sc.nextLine());
		ArrayList<Integer> res = new ArrayList<>();
		for(int k=0;k<tests;k++) {
			String testGrid = sc.nextLine();
			int rows = Integer.parseInt(testGrid.split("x")[0]);
			int cols = Integer.parseInt(testGrid.split("x")[1]);
			res.add(countOccurences(grid,n,m,rows,cols));
		}
		System.out.print(res.stream().map(String::valueOf).collect(Collectors.joining("\n")));
	}

}

/*
3x5
00010
00010
11100
3
2x1
1x3
1x2

7x7
0000110
0000110
0011000
0100000
0100000
0001000
0000001
4
2x2
1x2
1x1
2x1
*/