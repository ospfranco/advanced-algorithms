import java.util.Scanner;

public class TheOrcAttack_uva10793 {
	final static int INFINTE = 1<<20;
	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for (int i = 0; i < n; i++) {
			int l = scan.nextInt()+1;
			int d = scan.nextInt();
			int[][] m = new int[l][l];
			for (int j = 0; j < m.length; j++) {
				m[j][0]=j;
				for (int j2 = 1; j2 < m.length; j2++) {
					m[j][j2] = INFINTE;
					if(j==j2)
						m[j][j2]=0;
				}
			}
			for (int j = 0; j < d; j++) {
				int x = scan.nextInt();
				int y = scan.nextInt();
				int c = scan.nextInt();
				if(c < m[x][y]){
					m[x][y] = c;
					m[y][x] = c;
				}
			}
			//print(m);
			m = floydWarshall(l, m);
			int candidate = INFINTE;
			for (int j = 6; j < m.length; j++) {
				int max = 0;
				for (int k = 1; k < m.length; k++) {
					if(m[j][k] > max)
						max = m[j][k];
				}
				if(max==INFINTE){
					candidate = -1;
					break;
				}
				else if(m[j][1] == m[j][2] && m[j][2] == m[j][3] && m[j][3] == m[j][4] && m[j][4] == m[j][5]){
						//System.out.println("fila candidata: "+j+" con un maximo de "+max);
						if(max < candidate){
							candidate = max;
						}
					}
			}
			if(candidate==INFINTE){
				System.out.println("Map "+(i+1)+": -1");
			}
			else{
				System.out.println("Map "+(i+1)+": "+candidate);
			}
			
			//print(m);
		}

	}
	
	private static int[][] floydWarshall(int n, int[][] m) {
		for (int k = 1; k < n; k++) {
			int[][] act = new int[n][n];
			for (int i = 1; i < act.length; i++) {
				for (int j = 1; j < act.length; j++) {
					act[i][j] = Math.min(m[i][j],m[i][k]+m[k][j]);
				}
			}
			m = act;
		}
		return m;
		
	}

	public static void print(int[][] m){
		for (int i = 0; i < m.length; i++) {
			System.out.print(i+"\t\t\t");
		}
		System.out.println();
		for (int i = 1; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				if(m[i][j]!=INFINTE)
					System.out.print(m[i][j]+"\t\t\t");
				else
					System.out.print("INF\t\t\t");
			}
			System.out.println();
		}
		System.out.println();
	}

}
