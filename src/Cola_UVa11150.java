package Capitulo1;
import java.util.Scanner;
public class Cola_UVa11150 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);		
		while(scan.hasNext()){
			int n = scan.nextInt();
			int aux = n;
			int max = 0;
			int max1 = n;
			int max2 = n;
			int max3 = n;
			while(n>3){
				max1 += n/3;
				n=n/3+n%3;
			}
			n = aux+1;
			while(n>3){
				max2 += n/3;
				n=n/3+n%3;
			}
			n = aux+2;
			while(n>3){
				max3 += n/3;
				n=n/3+n%3;
			}
			if(n<2)
				max2 = 0;
			if(max1>max2)
				if(max1>max3)
					max = max1;
				else
					max = max3;
			else
				if(max2>max3)
					max = max2;
				else 
					max = max3;
			System.out.println(max);
			
		}
	}
}
