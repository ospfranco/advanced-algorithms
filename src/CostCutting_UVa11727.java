package Capitulo1;
import java.util.Scanner;
import java.util.Arrays;
public class CostCutting_UVa11727 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] a = new int[3];
		for(int i = 0;i<n;i++){
			a[0]= scan.nextInt();
			a[1]=scan.nextInt();
			a[2]=scan.nextInt();
			Arrays.sort(a);
			System.out.println("Case "+(i+1)+": "+a[1]);
		}
	}
}
