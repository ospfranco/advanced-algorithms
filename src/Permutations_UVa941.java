package Capitulo1;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.ArrayList;
public class Permutations_UVa941 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(scan.readLine());
		for(int i = 0; i < n;i++){
			String li = scan.readLine();
			String res ="";
			char [] aux = li.toCharArray();
			ArrayList<Character> l =new ArrayList();
			for(char a :aux)
				l.add(a);
			Collections.sort(l);
			long f = Long.parseLong(scan.readLine());
			while(f!=0){
				long rango = factorial(l.size()-1);
				int k = (int)(f/rango);
				long mod = f%rango;
				res += l.get(k);
				l.remove(k);
				f = mod;
			}
			for(int j = 0;j<l.size();j++)
				res +=l.get(j);
			System.out.println(res);
		}
	}
	public static long factorial(int n) {
			    long res = 1;
		        for (int i = 2; i <= n; i++)
		        res *= i;
		        return res;
		    }

}
