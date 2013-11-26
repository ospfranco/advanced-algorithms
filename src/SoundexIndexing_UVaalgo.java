package Capitulo1;
import java.util.Scanner;
public class SoundexIndexing_UVaalgo {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("         NAME                     SOUNDEX CODE");
		while(scan.hasNext()){
			String lin = scan.nextLine();
			System.out.print("         "+lin);
			int dif = (lin.length()+9);
			dif= 34-dif;
			String spacios ="";
			for(int i = 0;i<dif;i++){
				spacios+=" ";
			}
			System.out.print(spacios+getSoundex(lin));
			System.out.println();
		}
			System.out.print("                   ");
		System.out.println("END OF OUTPUT");
	}
	public static String getSoundex(String l){
		String res ="";
		res += l.charAt(0);
		for(int i = 1;i<l.length();i++){
			if(res.length()<4)
				if(encode(l.charAt(i)).equals(encode(l.charAt(i-1))))
					res +="";
				else
					res+=encode(l.charAt(i));
			else
				break;
		}
		int n = 4-res.length();
		for(int i = 0;i<n;i++)
			res+="0";
		return res;
	}
	public static String encode(char a){
		String res="0";
		switch(a){
			case 66: res="1";
			break;
			case 80: res="1";
			break;
			case 70: res="1";
			break;
			case 86: res="1";
			break;
			case 67: res="2";
			break;
			case 83: res="2";
			break;
			case 75: res="2";
			break;
			case 71: res="2";
			break;
			case 74: res="2";
			break;
			case 81: res="2";
			break;
			case 88: res="2";
			break;
			case 90: res="2";
			break;
			case 68: res="3";
			break;
			case 84: res="3";
			break;
			case 76: res="4";
			break;
			case 77: res="5";
			break;
			case 78: res="5";
			break;
			case 82: res="6";
			break;
			
			case 65: res="";
			break;
			case 69: res="";
			break;
			case 73: res="";
			break;
			case 79: res="";
			break;
			case 85: res="";
			break;
			case 89: res="";
			break;
			case 87: res="";
			break;
			case 72: res="";
			break;
			
			default: break;
		}
		return res;
	}

}
