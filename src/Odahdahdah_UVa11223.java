package Capitulo1;
import java.util.Scanner;
public class Odahdahdah_UVa11223 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		scan.nextLine();
		for(int i = 0; i < n; i++){
			String res = "";
			String lin = scan.nextLine();
			String[] l = lin.split(" ");
			for(String a : l){
				if(a.equals(".-"))
					res += "A";
				if(a.equals("-..."))
					res += "B";
				if(a.equals("-.-."))
					res += "C";
				if(a.equals("-.."))
					res += "D";
				if(a.equals("."))
					res += "E";
				if(a.equals("..-."))
					res += "F";
				if(a.equals("--."))
					res += "G";
				if(a.equals("...."))
					res += "H";
				if(a.equals(".."))
					res += "I";
				if(a.equals(".---"))
					res += "J";
				if(a.equals("-.-"))
					res += "K";
				if(a.equals(".-.."))
					res += "L";
				if(a.equals("--"))
					res += "M";
				if(a.equals("-."))
					res += "N";
				if(a.equals("---"))
					res += "O";
				if(a.equals(".--."))
					res += "P";
				if(a.equals("--.-"))
					res += "Q";
				if(a.equals(".-."))
					res += "R";
				if(a.equals("..."))
					res += "S";
				if(a.equals("-"))
					res += "T";
				if(a.equals("..-"))
					res += "U";
				if(a.equals("...-"))
					res += "V";
				if(a.equals(".--"))
					res += "W";
				if(a.equals("-..-"))
					res += "X";
				if(a.equals("-.--"))
					res += "Y";
				if(a.equals("--.."))
					res += "Z";
				if(a.equals("-----"))
					res += "0";
				if(a.equals(".----"))
					res += "1";
				if(a.equals("..---"))
					res += "2";
				if(a.equals("...--"))
					res += "3";
				if(a.equals("....-"))
					res += "4";
				if(a.equals("....."))
					res += "5";
				if(a.equals("-...."))
					res += "6";
				if(a.equals("--..."))
					res += "7";
				if(a.equals("---.."))
					res += "8";
				if(a.equals("----."))
					res += "9";
				if(a.equals(".-.-.-"))
					res += ".";
				if(a.equals("--..--"))
					res += ",";
				if(a.equals("..--.."))
					res += "?";
				if(a.equals(".----."))
					res += "'";
				if(a.equals("-.-.--"))
					res += "!";
				if(a.equals("-..-."))
					res += "/";
				if(a.equals("-.--."))
					res += "(";
				if(a.equals("-.--.-"))
					res += ")";
				if(a.equals(".-..."))
					res += "&";
				if(a.equals("---..."))
					res += ":";
				if(a.equals("-.-.-."))
					res += ";";
				if(a.equals("-...-"))
					res += "=";
				if(a.equals(".-.-."))
					res += "+";
				if(a.equals("-....-"))
					res += "-";
				if(a.equals("..--.-"))
					res += "_";
				if(a.equals(".-..-."))
					res += "\"";
				if(a.equals(".--.-."))
					res += "@";
				if(a.equals(""))
					res += " ";
			}
			System.out.println("Message #"+(i+1));
			System.out.println(res);
			if(i!=n-1)
			System.out.println();
		}
	}
}
