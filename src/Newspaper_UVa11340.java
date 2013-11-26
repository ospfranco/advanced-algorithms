package Capitulo1;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Newspaper_UVa11340 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(scan.readLine());
		for(int i = 0; i<n;i++){
			double [] vals = new double[100000];
			int k = Integer.parseInt(scan.readLine());
			for(int j = 0;j<k;j++){
				String[] l = scan.readLine().split(" "); 
				vals[l[0].charAt(0)]=Double.parseDouble(l[1]);
			}
			int m = Integer.parseInt(scan.readLine());
			double res = 0;
			for(int j = 0;j<m;j++){
				String l = scan.readLine();
				for(int a = 0;a<l.length();a++){
					char Act = l.charAt(a);
					res+=vals[Act];}
							
			}
			res = res/100;
			System.out.printf("%.2f$\n",res);
		}
	}
}
