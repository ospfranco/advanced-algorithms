package paraExamen3;

import java.util.Scanner;

public class IsThisIntegration_uva10209 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			double a = scan.nextDouble();
			double areaRect = a*a;
			double A = areaRect - (Math.PI*a)/4;
			double B = areaRect - 2*A;
			double x = areaRect * (1 - Math.sqrt(3) + Math.PI / 3);  
            double y = areaRect * (2 * Math.sqrt(3) - 4 + Math.PI / 3);  
            double z = areaRect * (4 - Math.sqrt(3) - 2 * Math.PI / 3);
            String temp=String.format("%.3f %.3f %.3f\n", x,y,z);
            System.out.println(temp);
		}

	}

}
