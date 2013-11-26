package examen2;

import java.util.Scanner;
import java.util.ArrayList;

public class Bocadits {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] l1 = scan.nextLine().split(" ");
		String[] l2 = scan.nextLine().split(" ");
		int k = scan.nextInt();
		int n = l1.length;
		int[] dist = new int[n];
		int[] prof = new int[n];
		for (int i = 0; i < prof.length; i++) {
			dist[i] = Integer.parseInt(l1[i]);
			prof[i] = Integer.parseInt(l2[i]);
		}
		String max = maximumSequence(dist, prof, k);
		System.out.println(max);

	}

	private static String maximumSequence(int[] dist, int[] prof, int k) {
		int n = dist.length;
		int[] maxes = new int[n];
		ArrayList<ArrayList<Integer>> arrayMaxes = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i++) {
			arrayMaxes.add(new ArrayList<Integer>());
		}
		for (int i = n-1; i >= 0; i--) {
			ArrayList<Integer> listaAct = new ArrayList<Integer>();
			listaAct.add(dist[i]);
			int maxAct = prof[i];
			for (int j = i; j < maxes.length; j++) {
				if(Math.abs(dist[i] - dist[j]) >= k)
					if(maxAct < prof[i] + maxes[j]){
						maxAct = maxes[j] + prof[i];
						listaAct.clear();
						listaAct.add(dist[i]);
						listaAct.addAll(arrayMaxes.get(j));
					}
			}
			maxes[i] = maxAct;
			arrayMaxes.set(i, listaAct);
		}
		
		int res = 0;
		ArrayList<Integer> maxArray = new ArrayList();
		for (int i = 0; i < maxes.length; i++) {
			if(res < maxes[i]){
				res = maxes[i];
				maxArray = arrayMaxes.get(i);
			}
		}
		String finalRes = "La ganancia maxima es: "+res+"\ncon las tiendas:\n";
		for (int i = 0; i < maxArray.size(); i++) {
			finalRes+=maxArray.get(i)+" ";
		}

		return finalRes;
	}

}
