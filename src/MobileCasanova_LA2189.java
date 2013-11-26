package Capitulo1;
import java.util.Scanner;
public class MobileCasanova_LA2189 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int times =1;
		while(n!=0){
			System.out.println("Case "+times+":");
			long numbers[] = new long[n];
			for(int i = 0;i<n;i++){
				numbers[i] = scan.nextLong();
			}
			long base = numbers[0];
			int cont = 0;
			for(int i =1;i<n;i++){
				if(numbers[i]==(numbers[i-1]+1)){
					cont++;
				}
				else{
					if(cont==0){
						System.out.println("0"+numbers[i-1]);
					}
					else{
						System.out.println("0"+numbers[i-cont-1]+"-"+diff(numbers[i-cont-1]+"",cont));
						cont=0;
					}
				}			
			}
			if(cont==0){
				System.out.println("0"+numbers[n-1]);
			}
			else{
				System.out.println("0"+numbers[n-cont-1]+"-"+diff(numbers[n-cont-1]+"",cont));
			}
			n = scan.nextInt();
			System.out.println();
			times++;
		}
	}
	public static String diff(String a,int c){
		String res="";
		long aa = Long.parseLong(a);
		long bb = aa+c;
		String b = bb+"";
		int aux = 0;
		for(int i = 0;i<b.length();i++){
			if(a.charAt(i)!=b.charAt(i)){
				aux= i;
				break;}
		}
		for(int i = aux;i<b.length();i++)
			res+=b.charAt(i);
		return res;
	}
}
