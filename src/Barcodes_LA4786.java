package Capitulo1;
import java.util.Scanner;
public class Barcodes_LA4786 {
	static int thin = 10;
	static int wide = 20;
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		while(n!=0){
			int[] code = new int[n];
			String decoded = "";
			for(int i = 0;i<n;i++)
				code[i] = scan.nextInt();
			String backcode = encode(code,n-5,n);
			backcode = new StringBuffer(backcode).reverse().toString();
			backcode = translate(backcode);
			String frontcode = encode(code,0,5);
			frontcode = translate(frontcode);
			if(backcode.equals("start/stop")){
				code = reverse(code);
				decoded = decode(code);
			}
			else
				decoded = decode(code);
			for(int a:code)
				System.out.print(a+" ");
			System.out.println();
			for(int i = 0;i<n;i++)
				if(i<10)
					System.out.print(" "+i+" ");
				else
					System.out.print(i+" ");
			System.out.println();
			System.out.println(decoded);
			n=scan.nextInt();
		}
	}
	
	private static String encode(int[] code, int inf, int sup){
		String res="";
		for(int i = inf;i<sup;i++)
			if(code[i]==thin)
				res+="0";
			else
				res+="1";
		return res;
	}
	
	private static String translate(String a){
		String res="N";
		if(a.equals("00001"))
			res="0";
		if(a.equals("10001"))
			res="1";
		if(a.equals("01001"))
			res="2";
		if(a.equals("11000"))
			res="3";
		if(a.equals("00101"))
			res="4";
		if(a.equals("10100"))
			res="5";
		if(a.equals("01100"))
			res="6";
		if(a.equals("00011"))
			res="7";
		if(a.equals("10010"))
			res="8";
		if(a.equals("10000"))
			res="9";
		if(a.equals("00100"))
			res="-";
		if(a.equals("00110"))
			res="start/stop";	
		return res;
	}
	
	private static int[] reverse(int[] a){
		int t = a.length;
		int[] res = new int[t];
		for(int i = 0;i<a.length;i++)
			res[i]= a[t-i-1];
		return res;
	}
	
	private static String decode(int[] a){
		String res ="";
		int[] aux = new int[5];
		int cont=0;
		int cont2=5;
		for(int i = 0;i<a.length+1;i++){
			if(i==cont2||i==59){
				System.out.println(encode(aux,0,5));
				res+=translate(encode(aux,0,5));
				cont=0;
				cont2+=6;
				}
			else{
				aux[cont]=a[i];
				cont++;}
		}
		return res;
	}
}
