package Capitulo1;
import java.util.Scanner;
public class BeatTheSpread_UVa10812 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for(int i =0;i<n;i++){
			int x = 0;
			int y = 0;
			int aux = 0;
			int s = scan.nextInt();
			int d = scan.nextInt();
			if(d>s)
				System.out.println("impossible");
			else{
				if((s-d)%2!=0)
					System.out.println("impossible");
				else{
					y = (s-d)/2;
					x = s-y;
					if(x<0)
						x=-x;
					if(y<0)
						y=-y;
					if(y>x){
						aux = x;
						x = y;
						y = aux;}
					if(i!=n-1)
						System.out.println(x+" "+y);
					else
						System.out.print(x+" "+y);}
				}
		}
	}
}
