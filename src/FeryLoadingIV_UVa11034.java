package Capitulo2;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
public class FeryLoadingIV_UVa11034 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for (int i = 0; i < n; i++) {
			int l = scan.nextInt();
			int m = scan.nextInt();
			scan.nextLine();
			Queue<Integer> left = new LinkedList<Integer>();
			Queue<Integer> right = new LinkedList<Integer>();
			for (int j = 0; j < m; j++) {
				String[] lin = scan.nextLine().split(" ");
				if(lin[1].equals("left"))
					left.add(Integer.parseInt(lin[0]));
				else
					right.add(Integer.parseInt(lin[0]));
			}
			int res = FerryUp(left,right,l);
			System.out.println(res);
		}
	}
	
	public static int FerryUp(Queue<Integer> l,Queue<Integer> r,int ft){
		int res=0;
		ft = ft*100;
		int fl = 0;
		//side == false -> izq ::: side == true -> der
		boolean side=false;
		while(!l.isEmpty()||!r.isEmpty()){
			if(side==false&&!l.isEmpty()){
				while(!l.isEmpty() && fl+l.peek()<ft)
					fl+=l.poll();
				fl=0;
				res++;
				side=true;
			}
			else if(side==false && !r.isEmpty()){
				side=true;
				res++;
			}
			if(side==true && !r.isEmpty()){
				while(!r.isEmpty()&&fl+r.peek()<ft)
					fl+=r.poll();
				fl=0;
				res++;
				side=false;
			}
			else if(side==true && !l.isEmpty()){
				side=false;
				res++;
			}
		}
		return res;
	}
}
