package Capitulo1;
import java.util.Scanner;
public class TicTacToe_UVa10363 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.nextLine();
		for(int i = 0;i<n;i++){
			int x = 0;
			int o = 0;
			boolean xwin = false;
			boolean owin = false;
			String fila1 = scan.nextLine();
			String fila2 = scan.nextLine();
			String fila3 = scan.nextLine();
			if(i!=n-1)
				scan.nextLine();
			char[] cfil1 = fila1.toCharArray();
			char[] cfil2 = fila2.toCharArray();
			char[] cfil3 = fila3.toCharArray();
			char[][] mat = new char[][]{cfil1,cfil2,cfil3};
			for(char[] a:mat)
				for(char b:a){
					if(b=='X')
						x++;
					else
						if(b=='O')
							o++;}
			for(int j = 0;j<3;j++){
					if(mat[j][0]=='X'&&mat[j][1]=='X'&&mat[j][2]=='X')
						xwin=true;
					if(mat[j][0]=='O'&&mat[j][1]=='O'&&mat[j][2]=='O')
						owin=true;
					if(mat[0][j]=='X'&&mat[1][j]=='X'&&mat[2][j]=='X')
						xwin=true;
					if(mat[0][j]=='O'&&mat[1][j]=='O'&&mat[2][j]=='O')
						owin=true;}			
			if(mat[0][0]=='X'&&mat[1][1]=='X'&&mat[2][2]=='X')
				xwin=true;
			if(mat[0][2]=='X'&&mat[1][1]=='X'&&mat[2][0]=='X')
				xwin=true;
			if(mat[0][0]=='O'&&mat[1][1]=='O'&&mat[2][2]=='O')
				owin=true;
			if(mat[0][2]=='O'&&mat[1][1]=='O'&&mat[2][0]=='O')
				owin=true;
			if(xwin&&owin)
				System.out.println("no");
			else
				if(xwin&&(x==o+1))
					System.out.println("yes");
				else
					if(xwin&&(x!=o+1))
						System.out.println("no");
					else
						if(owin&&(x==o))
							System.out.println("yes");
						else
							if(owin&&(x!=0))
								System.out.println("no");
							else
								if(x==o||x==o+1)
									System.out.println("yes");
								else
									System.out.println("no");
		}
	}
}
