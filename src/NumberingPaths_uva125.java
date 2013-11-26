import java.util.Scanner;

public class NumberingPaths_uva125 {
	static int N=0;
	static int[][] m;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = 0;
		while(scan.hasNext()){
			int n = scan.nextInt();
			N = 0;
			m = new int[110][110];
			for (int i = 0; i < n; i++) {
				int x = scan.nextInt();
				int y = scan.nextInt();
				if(x>N)
					N=x;
				if(y>N)
					N=y;
				m[x][y]=1;
			}
			//print();
			System.out.println("matrix for city "+T);
			solve();
			T++;
		}
	}
	private static void solve() {
		
		for (int k = 0; k <= N; k++) {
			for (int i = 0; i <= N; i++) {
				for (int j = 0; j <= N; j++) {
					if(m[i][k] != 0 && m[k][j] != 0)
						m[i][j] += m[i][k] * m[k][j];
				}
			}
		}
		
		for(int k = 0; k <= N; k ++)
	        if(m[k][k] != 0)
	        {
	            for(int i = 0; i <= N; i ++)
	                for(int j = 0; j <= N; j ++)
	                    if(m[i][k] != 0 && m[k][j] != 0)
	                        m[i][j] = -1;
	        }
		print();
	}

	public static void print(){
		for (int i = 0; i <= N; i++) {
			System.out.print(m[i][0]);
			for (int j = 1; j <= N; j++) {
				System.out.print(" " + m[i][j]);
			}
			System.out.println();
		}
	}
}
