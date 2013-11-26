import java.util.Scanner;

public class MaximumSumOnATorus_uva10827 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int cases = scan.nextInt();
		for (int i = 0; i < cases; i++) {
			int n = scan.nextInt();
			int[][] matr = new int[160][160];
			for (int j = 1; j <= n; j++) {
				for (int j2 = 1; j2 <= n; j2++) {
					matr[j][j2]=scan.nextInt();
					matr[j+n][j2]=matr[j][j2];
				}
			}
			
			for(int j=1; j<=2*n; j++)
	            for(int j2=1;j2<=n; j2++)
	                matr[j][j2]+=matr[j-1][j2];
			
			System.out.println(stringify(n,matr));
			int max = torus(n, matr);
			System.out.println(max);
		}		
	}
	
	private static int torus(int n,int[][] matr) {
		int res = 0;
		for (int i = 1; i <= 2*n; i++) {
			for (int j = i; j <= Math.min(i+n-1, 2*n); j++) {
				int smax = 0, smin = 0, ssum = 0, tmax = 0, tmin = 0;
				
				for (int k = 0; k <= n; k++) {
					ssum += matr[j][k] - matr[i-1][k];
				}
				
				for (int k = 0; k <= n; k++) {
					int a = matr[j][k] - matr[i-1][k];
					smax +=a;
					smin +=a;
					
					tmax = Math.max(tmax, smax);
					tmin = Math.min(tmin, smin);
					
					if(smax<0) smax = 0;
					if(smin>0) smin = 0;
				}
				res = Math.max(res, Math.max(tmax, ssum-tmin));
			}
		}
		return res;
	}

	private static String stringify(int n,int[][] m){
		String res = "";
		for (int i = 1; i <= 2*n; i++) {
			for (int j = 1; j <= 2*n; j++) {
				res+= m[i][j]+", ";
			}
			res+="\n";
		}
		return res;
	}
}
