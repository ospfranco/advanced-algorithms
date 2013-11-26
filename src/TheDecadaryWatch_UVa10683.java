package Capitulo1;
import java.util.Scanner;
import java.text.DecimalFormat;
public class TheDecadaryWatch_UVa10683 {
	public static void main(String[] args){
		DecimalFormat form = new DecimalFormat("0000000");
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			String horaS = scan.nextLine();
			char[] h = horaS.toCharArray();
			int hora = (h[0]-48)*10+h[1]-48;
			int min = (h[2]-48)*10+h[3]-48;
			int seg = (h[4]-48)*10+h[5]-48;
			int cc = (h[6]-48)*10+h[7]-48;
			int d = (hora*3600+min*60+seg)*100+cc;
			d = (int)d*125/108;
			System.out.println(form.format(d));
		}
	}
}
