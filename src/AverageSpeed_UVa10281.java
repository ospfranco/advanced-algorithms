package Capitulo1;
import java.util.Scanner;
import java.text.DecimalFormat;
public class AverageSpeed_UVa10281 {
	public static void main(String[] args){
		DecimalFormat form = new DecimalFormat("00");
		DecimalFormat form2 = new DecimalFormat("#.00");
		Scanner scan = new Scanner(System.in);
		float speed = 0;
		float dist = 0;
		int lastHora = 0;
		int lastMin = 0;
		int lastSeg = 0;
		int difHoras;
		int difMin;
		int difSeg;
		while(scan.hasNext()){
			String lin=scan.nextLine();
			char[] linea = lin.toCharArray();
			int Thora = (linea[0]-48)*10+(linea[1]-48);
			int Tmin = (linea[3]-48)*10+(linea[4]-48);
			int Tseg = (linea[6]-48)*10+(linea[7]-48);
			String hora = form.format(Thora);
			String min = form.format(Tmin);
			String seg = form.format(Tseg);
			if(lin.length()<=8){
				difHoras= (Thora-lastHora)*3600;
				difMin=(Tmin-lastMin)*60;
				difSeg= (Tseg-lastSeg);
				
				dist = dist + speed*(difHoras+difMin+difSeg)/3600;
				System.out.printf(hora+":"+min+":"+seg+" "+"%.2f km\n",dist);
				lastHora = Thora;
				lastMin = Tmin;
				lastSeg = Tseg;
			}
			else{
				difHoras= (Thora-lastHora)*3600;
				difMin=(Tmin-lastMin)*60;
				difSeg= (Tseg-lastSeg);
				dist = dist + speed*(difHoras+difMin+difSeg)/3600;
				speed = 0;
				for(int i = 9;i<linea.length;i++)
					speed = speed*10+(linea[i]-48);
				lastHora = Thora;
				lastMin = Tmin;
				lastSeg = Tseg;
			}
		}
	}
}
