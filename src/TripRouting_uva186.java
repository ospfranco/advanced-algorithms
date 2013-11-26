import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.StringBuilder;

public class TripRouting_uva186 {
	final static int MAX = 20000000; 

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String lineComplete = scan.nextLine();
		ArrayList<String[]> entryList = new ArrayList();
		ArrayList<String> cityKeys = new ArrayList();
		cityKeys.add("nulo");
		int count = 1;
		while(!lineComplete.equals("")){
			String[] lineCompleteArray = lineComplete.split(",");
			if(!cityKeys.contains(lineCompleteArray[0])){
				cityKeys.add(lineCompleteArray[0]);
				count++;
			}
			if(!cityKeys.contains(lineCompleteArray[1])){
				cityKeys.add(lineCompleteArray[1]);
				count++;
			}
			entryList.add(lineCompleteArray);
			lineComplete = scan.nextLine();
		}
		
		int n = cityKeys.size()+1;
		int[][] adyacents = new int[n][n];
		for (int i = 0; i < adyacents.length; i++) {
			adyacents[i][0]=i;
		}
		int[][] weights = new int[n][n];
		for (int i = 0; i < weights.length; i++) {
			for (int j = 0; j < weights.length; j++) {
				if(i==j)
					weights[i][j]=0;
				else
					weights[i][j]=MAX;
			}
		}
		String[][] routeName = new String[n][n];
		for (int i = 0; i < entryList.size(); i++) {
			String[] actCity = entryList.get(i);
			int key1 = cityKeys.indexOf(actCity[0]);
			int key2 = cityKeys.indexOf(actCity[1]);
			adyacents[key1][key2] = key1;
			adyacents[key2][key1] = key2;
			int weight = Integer.parseInt(actCity[3]);
			if(weight<weights[key1][key2]){
				weights[key1][key2] = weight;
				weights[key2][key1] = weight;
				routeName[key1][key2] = actCity[2];
				routeName[key2][key1] = actCity[2];
			}
		}
		weights = floydWarshall(n, adyacents, weights, routeName);
		
		while(scan.hasNext()){
			String[] queryComplete = scan.nextLine().split(",");
			String city1 = queryComplete[0];
			String city2 = queryComplete[1];
			int cp1 = cityKeys.indexOf(city1);
			int cp2 = cityKeys.indexOf(city2);
			
			ArrayList<Integer> route = tracert(cp1, cp2, adyacents);
			
			StringBuilder res = new StringBuilder();
			res.append("\n\n");
			res.append("From                 To                   Route      Miles\n-------------------- -------------------- ---------- -----\n");
			
			for (int i = 1; i < route.size(); i++) {
				int c1 = route.get(i-1);
				int c2 = route.get(i);
				res.append(cityKeys.get(c1));
				for (int j = cityKeys.get(c1).length(); j <= 20; j++) {
					res.append(' ');
				}
				res.append(cityKeys.get(c2));
				for (int j = cityKeys.get(c2).length(); j <= 20; j++) {
					res.append(' ');
				}
				res.append(routeName[c1][c2]);
				for (int j = routeName[c1][c2].length(); j <= 10; j++) {
					res.append(' ');
				}
				
				for (int j = 0; j <= 4-countDigits(weights[c1][c2]); j++) {
					res.append(' ');
				}
				res.append(weights[c1][c2]);
				res.append("\n");
			}
			
			int c1 = route.get(route.size()-1);
			int c2 = cp2;
			
			res.append(cityKeys.get(c1));
			for (int j = cityKeys.get(c1).length(); j <= 20; j++) {
				res.append(' ');
			}
			res.append(cityKeys.get(c2));
			for (int j = cityKeys.get(c2).length(); j <= 20; j++) {
				res.append(' ');
			}
			res.append(routeName[c1][c2]);
			for (int j = routeName[c1][c2].length(); j <= 10; j++) {
				res.append(' ');
			}
			
			for (int j = 0; j <= 4-countDigits(weights[c1][c2]); j++) {
				res.append(' ');
			}
			res.append(weights[c1][c2]);
			res.append("\n");
			res.append("                                                     -----\n                                          Total        "+weights[cp1][cp2]+"\n");
			System.out.print(res.toString());
			
		}
		//print(adyacents);
		//print(weights);
		
	}
	
	public static int countDigits(int n){
		int res = 0;
		while(n!=0){
			res++;
			n=n/10;
		}
		return res;
	}
	
	private static ArrayList<Integer> tracert(int i, int j,int[][] ady) {
		ArrayList<Integer> res = new ArrayList();
		if(i==j){
			res.add(i);
			return res;}
		if(ady[i][j]==i){
			res.add(i);
			return res;
		}
			
		else{
			res.addAll(tracert(i,ady[i][j],ady));
			res.addAll(tracert(ady[i][j],j, ady));
			return res;
		}
	}

	private static int[][] floydWarshall(int n, int[][] adyacents, int[][] weights,
			String[][] routeName) {
		for (int k = 0; k < n; k++) {
			int[][] act = new int[n][n];
			for (int i = 0; i < act.length; i++) {
				for (int j = 0; j < act.length; j++) {
					if(weights[i][k]+weights[k][j]<weights[i][j]){
						adyacents[i][j]=k;
						adyacents[j][i]=k;
					}
					act[i][j] = Math.min(weights[i][j],weights[i][k]+weights[k][j]);
				}
			}
			
			weights = act;
		}
		return weights;
		
	}

	public static void print(int[][] m){
		for (int i = 0; i < m.length; i++) {
			System.out.print(i+"\t");
		}
		System.out.println();
		for (int i = 1; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				System.out.print(m[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println();
	}

}
