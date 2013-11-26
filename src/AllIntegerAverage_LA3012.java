package Capitulo1;
import java.util.Scanner;
public class AllIntegerAverage_LA3012 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int times =1;
		while(n!=0){
			System.out.println("Case "+times+":");
			int[] array = new int[n];
			int sum = 0;
			for(int i = 0;i<n;i++){
				sum+=scan.nextInt();
			}
			int entero = sum/n;
			int decimal = sum%n;
			int divisor=n;
			if(decimal!=0){
				for (int c=2;c<=Math.min(divisor, Math.abs(decimal)); c++ )
		        {
		            if (divisor%c==0 && decimal%c==0)
		            {
		                divisor=divisor/c;
		                decimal=decimal/c;
		                c=2;
		            }
		        }
				int numBarras=contar(divisor);
				String Barras=barras(numBarras);
				String decOut=identar(Math.abs(decimal),numBarras-1);
				if(entero!=0){

					int numEspacios = contar(entero);
					String espacios = espacios(numEspacios);
					if(entero>0){
						System.out.println(espacios+decOut);
						System.out.println(entero+Barras);
						System.out.println(espacios+divisor);
					}
					else{
						System.out.println("  "+espacios+decOut);
						System.out.println("- "+Math.abs(entero)+Barras);
						System.out.println("  "+espacios+Math.abs(divisor));
					}
				}
				else
					if(decimal>=0){
						System.out.println(decOut);
						System.out.println("-");
						System.out.println(divisor);
					}
					else{
						System.out.println("  "+decOut);
						System.out.println("- "+Barras);
						System.out.println("  "+Math.abs(divisor));
						}
			}
			else
				if(entero>=0){
					System.out.println(entero);
				}
				else{
					System.out.println("- "+Math.abs(entero));
				}
			n=scan.nextInt();
			times++;
		}
	}

	private static String espacios(int numEspacios) {
		String res = "";
		while(numEspacios!=0){
			res+=" ";
			numEspacios--;
		}
		return res;
	}

	private static String identar(int n,int barras) {
		String res ="";
		while((barras-contar(n)+1)!=0){
			res+=" ";
			barras--;
		}
		return res+n;
	}

	private static String barras(int numBarras) {
		String res="";
		while(numBarras!=0){
			res+="-";
			numBarras--;
		}
		return res;
	}

	private static int contar(int d) {
		int res = 0;
		while (d!=0){
			res++;
			d=d/10;}
		return res;
	}
}
