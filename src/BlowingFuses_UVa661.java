package Capitulo1;
import java.util.Scanner;
public class BlowingFuses_UVa661 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		long c = scan.nextLong();
		boolean blown=false;
		int act =0;
		int max=0;
		int cont = 1;
		while(m!=0&&n!=0&&c!=0){
			boolean[] aprs = new boolean[n];
			long[] aprscons = new long[n];
			int[] ops = new int[m];
			for(int i =0;i<n;i++)
				aprscons[i]=scan.nextLong();
			for(int i =0;i<m;i++)
				ops[i]=scan.nextInt();
			for(int op :ops)
				if(aprs[op-1]==false){
					act+=aprscons[op-1];
					aprs[op-1]=true;
					if(act>c){
						System.out.println("Sequence "+cont);
						System.out.println("Fuse was blown.");
						blown = true;
						break;
					}
					else
						if(act>max)
							max = act;
				}
				else{
					act-=aprscons[op-1];
					aprs[op-1]=false;
				}
			if(blown==false){
				System.out.println("Sequence "+cont);
				System.out.println("Fuse was not blown.");
				System.out.println("Maximal power consumption was "+max+" amperes.");
			}
			n=scan.nextInt();
			m=scan.nextInt();
			c=scan.nextLong();
			cont++;
			max = 0;
			act=0;
			blown=false;
			System.out.println();
		}
	}
}
