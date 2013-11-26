package Capitulo1;
import java.util.Scanner;
public class FreeSpots_UVa10703 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int w = scan.nextInt();
		int h = scan.nextInt();
		int n = scan.nextInt();
		while(w!=0||h!=0||n!=0){
			boolean [][] board = new boolean[w][h];
			int count=w*h;
			for(int i = 0;i<n;i++){
				int x1 = scan.nextInt();
				int y1 = scan.nextInt();
				int x2 = scan.nextInt();
				int y2 = scan.nextInt();			
				for(int x =Math.min(x1, x2)-1;x<Math.max(x1, x2);x++)
					for(int y = Math.min(y1,y2)-1;y<Math.max(y1,y2);y++)
						if(board[x][y]==false){
							board[x][y]=true;
							count --;}
				
			}
			if(count ==0){
				System.out.println("There is no empty spots.");}
			else if(count ==1){
					System.out.println("There is one empty spot.");}
				else{
					System.out.println("There are "+count+" empty spots.");}
			w=scan.nextInt();
			h=scan.nextInt();
			n=scan.nextInt();
		}
	}	
}
