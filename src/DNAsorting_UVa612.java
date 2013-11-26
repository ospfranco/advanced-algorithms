package Capitulo2;

import java.util.Scanner;

public class DNAsorting_UVa612 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int M = scan.nextInt();
		for(int i = 0;i<M;i++){
			int n = scan.nextInt();
			int m = scan.nextInt();
			scan.nextLine();
			String[] lin = new String[m];
			for(int j = 0;j<m;j++){
				lin[j]=scan.nextLine();
			}
		}
	}

}
