import java.util.Scanner;
import java.util.ArrayList;

public class TestingTheCatcher_uva231 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> missiles = new ArrayList<Integer>();
		int n = scan.nextInt();
		int t = 1;
		while(n!=-1){
			while(n!=-1){
				missiles.add(n);
				n = scan.nextInt();
			}
			System.out.println("Test #"+t+":");
			System.out.println("  maximum possible interceptions: "+maximumSequence(missiles));
			t++;
			missiles.clear();
			n = scan.nextInt();
			if(n!=-1)
				System.out.println();
		}
		

	}

	private static int maximumSequence(ArrayList<Integer> missiles) {
		int[] maximums = new int[missiles.size()];
		for (int i = maximums.length-1; i >= 0; i--) {
			int act = missiles.get(i);
			int max = 1;
			for (int j = i; j < maximums.length; j++) {
				if(act >= missiles.get(j))
					max = (max>maximums[j]+1)?max:maximums[j]+1;
			}
			maximums[i]=max;
		}
		int max = 0;
		for (int i = 0; i < maximums.length; i++) {
			max = (maximums[i]>max)?maximums[i]:max;
		}
		return max;
	}

}
