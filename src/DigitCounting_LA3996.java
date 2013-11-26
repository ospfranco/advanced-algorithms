package Capitulo1;
import java.util.Scanner;
public class DigitCounting_LA3996 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for(int i = 0;i<n;i++){
			int m = scan.nextInt();
			int[] res = new int[10];
			String numbers="";
			for(int j = 1;j<=m;j++)
				numbers+=j;
			char[] nns = numbers.toCharArray();
			for(char a:nns)
				res[a-'0']++;
			for(int j=0;j<10;j++)
				if(j!=9)
					System.out.print(res[j]+" ");
				else
					System.out.println(res[j]);
		}
	}
}
