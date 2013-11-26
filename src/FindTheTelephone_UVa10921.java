package Capitulo1;
import java.util.Scanner;
public class FindTheTelephone_UVa10921 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			String phone = scan.nextLine();
			char[] cad = phone.toCharArray();
			for(char a:cad){
				if(a=='1'||a=='0'||a=='-')
					System.out.print(a);
				else
					System.out.print(convertir(a));
			}
			System.out.println();
		}
	}
	public static char convertir(char a){
		char res= '0';
		if(a<=67)
			res='2';
		if(a>67&&a<=70)
			res='3';
		if(a>70&&a<=73)
			res='4';
		if(a>73&&a<=76)
			res='5';
		if(a>76&&a<=79)
			res='6';
		if(a>79&&a<=83)
			res='7';
		if(a>83&&a<=86)
			res='8';
		if(a>86&&a<=90)
			res='9';
		return res;
	}
}
