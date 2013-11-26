package Capitulo2;
import java.io.*;
import static java.lang.Integer.*;
import java.util.*;
public class AgeSort_UVa11462 {
	public static void main(String[] args) throws IOException {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		int n = parseInt(scan.readLine());
		StringBuffer sb = new StringBuffer();
		while(n!=0){
			String res="";
			int [] ages = new int[101];
			StringTokenizer line = new StringTokenizer(scan.readLine());
			for(int i = 0;i<n;i++)
				ages[parseInt(line.nextToken())]++;
			for(int a=1,j = 0;a<100;a++)
				for(int i = 0;i<ages[a];i++,j++)
					sb.append((j>0?" ":"")+a);
			sb.append("\n");
			n=parseInt(scan.readLine());
		}
		System.out.print(new String(sb));
	}
}
