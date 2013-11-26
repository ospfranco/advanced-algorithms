import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DijkstraDijkstra_uva10806 {
	static int m, n, s, t;
	static final int INF = 1<<20;
	static int[][] graph = new int[220][220];
	static int[] dist = new int[220];
	static int[] path = new int[220];
	static int[] vis = new int[220]; 
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		while(n!=0){
			m = scan.nextInt();
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					graph[i][j] = INF;
				}
			}
			for (int i = 0; i < m; i++) {
				int u = scan.nextInt();
				int v = scan.nextInt();
				int w = scan.nextInt();
				graph[u][v]=graph[v][u]=w;
			}
			//print(graph);
			s = 1; 
			t = n;
			spfa();
			int sum=dist[t];
			if(dist[t] == INF){
				System.out.println("Back to jail");
			}
			else{
				change(t);
				s=n; t = 1;
				spfa();
				if(dist[t] == INF)
					System.out.println("Back to jail");
				else
					System.out.println(sum+dist[t]);
			}
			n = scan.nextInt();
		}

	}
	private static void change(int t) {
		int u = path[t];
		//graph[u][t]=-graph[u][t];
		graph[u][t] = INF;
		graph[t][u] = INF;
		if(u!=s)
			change(u);
	}
	private static void spfa() {
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) {
			dist[i] = INF;
			path[i] = s;
		}
		
		//print(dist);
		
		dist[s]=0; q.add(s); vis[s]=1;
		
		while(!q.isEmpty()){
			int u;
			u = q.poll(); vis[u]=0;
			for (int v = 1; v <= n; v++) {
				if(dist[u]+graph[u][v] < dist[v]){
					dist[v] = dist[u]+graph[u][v];
					path[v] = u;
					if(vis[v]==0){
						q.add(v); vis[v]=1;
					}
				}
			}
		}
		
		//print(dist);
	}
	
	public static void print(int[][] m){
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(m[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void print(int[] m){
		for (int i = 1; i <= n; i++) {
			System.out.print(i+"->"+m[i]+" ");
		}
		System.out.println();
	}

}
