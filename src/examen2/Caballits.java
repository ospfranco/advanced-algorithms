package examen2;

import java.util.Scanner;

public class Caballits {
	static final int INF = 1 << 20;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		int[] caballits = new int[n];
		for (int i = 0; i < caballits.length; i++) {
			caballits[i] = scan.nextInt();
		}
		int res = minimumCost(n, k, 0,caballits);
		System.out.println(res);
	}

	private static int minimumCost(int n, int k, int pos, int[] caballits) {
		int cost = INF;
		if(k == 0 && pos == n)
			return 0;
		else if(k == 0 && pos < n)
			return INF;
		else if(k > 0 && pos >= n)
			return INF;
		else if(k < 0)
			return INF;
		else{
			for (int i = pos; i < caballits.length; i++) {
				int costAct = mult(caballits, pos, i ) + minimumCost(n,k-1,i+1,caballits);
				if(costAct<cost)
					cost = costAct;
			}
		}
		
		return cost;
	}

	private static int mult(int[] caballits, int pos, int i) {
		int res = 0;
		int white = 0;
		int black = 0;
		for (int j = pos; j <= i; j++) {
			if(caballits[j]==1)
				black++;
			else
				white++;
		}
		res = black*white;
		return res;
	}
	
	

}
