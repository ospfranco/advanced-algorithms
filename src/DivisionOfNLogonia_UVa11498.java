package Capitulo1;
import java.util.Scanner;
public class DivisionOfNLogonia_UVa11498 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		while(n!=0){
			int divx = scan.nextInt();
			int divy = scan.nextInt();
			for(int i = 0;i<n;i++){
				int x = scan.nextInt();
				int y = scan.nextInt();
				if(x==divx || y == divy)
					System.out.println("divisa");
				else
					if(x>divx)
						if(y>divy)
							System.out.println("NE");
						else
							System.out.println("SE");
					else
						if(y>divy)
							System.out.println("NO");
						else
							System.out.println("SO");
			}
			n = scan.nextInt();
		}
	}
}
