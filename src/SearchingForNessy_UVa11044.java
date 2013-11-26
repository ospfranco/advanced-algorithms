package Capitulo1;
import java.util.Scanner;
public class SearchingForNessy_UVa11044 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for(int i = 0;i<n;i++){
			int a = scan.nextInt();
			int b = scan.nextInt();
			System.out.println((int)(a/3)*(int)(b/3));}
	}
}
