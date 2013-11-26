package Capitulo1;
import java.util.*;
import java.text.*;
public class ScheduleOfAMarriedMain_LA4202 {
	public static void main(String[] args){
		DateFormat formato = new SimpleDateFormat("HH:mm");
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		for(int i =0;i<n;i++){
			boolean res = false;
			String lll1 = scan.nextLine();
			String lll2=scan.nextLine();
			String[] ll1 = lll1.split(" ");
			String[] ll2 = lll2.split(" ");
			try {
				Date hora1 = formato.parse(ll1[0]);
				Date hora2 = formato.parse(ll1[1]);
				Date hora3 = formato.parse(ll2[0]);
				Date hora4 = formato.parse(ll2[1]);
				if(hora3.getTime()>hora2.getTime()&&hora4.getTime()>hora2.getTime())
					res=true;
				if(hora4.getTime()<hora1.getTime()&&hora3.getTime()<hora1.getTime())
					res=true;
				if(res==true)
					System.out.printf("Case %d: Hits Meeting\n",i+1);
				else
					System.out.printf("Case %d: Mrs Meeting\n",i+1);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
}
