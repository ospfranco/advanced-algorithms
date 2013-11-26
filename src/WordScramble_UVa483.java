package Capitulo1;
import java.util.Scanner;
import java.util.ArrayList;
public class WordScramble_UVa483 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		ArrayList<Character> lista = new ArrayList();
		while(scan.hasNext()){
		String act = scan.nextLine();
		char[] arr = act.toCharArray();
		for(char a : arr)
			if(a!=' ')
				lista.add(a);
			else{
				putout(lista);
				lista.clear();
				System.out.print(" ");}
		putout(lista);
		lista.clear();
		System.out.println();
		}
	}

	private static void putout(ArrayList<Character> lista) {
		int e = lista.size();
		for(int i = 1;i<=e;i++)
			System.out.print(lista.get(e-i));
	}
}
