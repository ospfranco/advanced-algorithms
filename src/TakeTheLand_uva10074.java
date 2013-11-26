import java.util.Scanner;

public class TakeTheLand_uva10074 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		int n = scan.nextInt();
		while(m != 0 && n != 0){
			int[][] forest = new int[m][n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					forest[i][j] = scan.nextInt();
				}				
			}
			int[][] sumMax = maxSumArea(m,n,forest);
			int max = maxArea(sumMax);
			System.out.println(max);
			m = scan.nextInt(); 
			n = scan.nextInt();
		}
	}

	private static int maxArea(int[][] sumMax) {
		int max = -1;
		for (int i = 0; i < sumMax.length; i++) {
			for (int j = 0; j < sumMax[0].length; j++) {
				int cnt  = sumMax[i][j];
				for (int k = j+1; k < sumMax[i].length && sumMax[i][j]<=sumMax[i][k]; k++) {
					cnt += sumMax[i][j];
				}
				for (int k = j-1; k>=0 && sumMax[i][j]<=sumMax[i][k]; k--) {
					cnt+=sumMax[i][j];
				}
				if(cnt>max)
					max=cnt;
			}
		}
		return max;
	}

	private static int[][] maxSumArea(int m, int n, int[][] forest) {
		int[][] res = new int[m][n];
		int[][] matrix = flip(m,n,forest);
		for (int i = 0; i < res[0].length; i++) {
			res[0][i]=forest[0][i];
		}
		for (int i = 1; i < res.length; i++) {
			for (int j = 0; j < res[i].length; j++) {
				if(forest[i][j]==0)
					res[i][j]=0;
				else
					res[i][j]=res[i-1][j]+forest[i][j];
			}
		}
		return res;
	}
	
	private static int[][] flip(int m, int n, int[][] forest){
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(forest[i][j]==0)
					forest[i][j]=1;
				else
					forest[i][j]=0;
			}
		}
		return forest;
	}
}
