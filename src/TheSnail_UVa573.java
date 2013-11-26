package Capitulo1;
import java.util.Scanner;
public class TheSnail_UVa573 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int H = scan.nextInt();
		int Ux = scan.nextInt();
		int D = scan.nextInt();
		int Fx = scan.nextInt();
		double U = (double)Ux;
		double F = (double)Fx/100;
		F = U*F;
		int days = 1;
		double pos = U;
		while(H!=0){
				while(true){
					if(pos>(double)H){
						System.out.println("success on day "+days);
						break;}
					else{
						pos-=D;
						if(U>0)
							U = U-F;}
					if(pos < 0.0){
						System.out.println("failure on day "+days);
						break;}
					pos += U;
					days++;
				}
				H = scan.nextInt();
				Ux = scan.nextInt();
				D = scan.nextInt();
				Fx = scan.nextInt();
				U = (double)Ux;
				F = (double)Fx/100;
				F = U *F;
				pos = U;
				days = 1;
			}
	}
}
