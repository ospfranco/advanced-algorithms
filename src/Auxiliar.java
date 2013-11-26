package Capitulo1;
import java.util.Scanner;
public class Auxiliar {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		char[] cad = scan.nextLine().toCharArray();
		int[] vals = new int[123];
		String li = scan.nextLine();
		String[] l = li.split(",");
		for(int i = 0;i<l.length;i++){
			vals[i+'A']=Integer.parseInt(l[i]);
		}
		li= scan.nextLine();
		l = li.split(",");
		for(int i = 0;i<l.length;i++){
			vals[i+'a']=Integer.parseInt(l[i]);
		}
		int sum = 0;
		for(char a:cad){
			if(a==' ')
				sum+=3;
			sum+=vals[a];}
		sum+=cad.length-1;
		System.out.println(sum);
		}
}
