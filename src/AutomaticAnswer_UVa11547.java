package Capitulo1;
import java.util.Scanner;
public class AutomaticAnswer_UVa11547 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for(int i =0;i<n;i++){
			int a = scan.nextInt();
			a = (((((a*567)/9+7492)*235)/47-498)/10)%10;
			if(a<0)
				a=-a;
			System.out.println(a);
		}
	}
}
