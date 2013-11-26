import java.util.Scanner;

public class CoinChange_uva674 {
	
	private static int[] coins = {1,5,10,25,50};
	private static int[] minimum = new int[8000];

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		pre();
		while(scan.hasNext()){
			int n = scan.nextInt();
			System.out.println(minimum[n]);
		}

	}
	
	private static void pre() {
		minimum[0]=1;
		for (int i = 0; i < coins.length; i++) {
			for (int j = coins[i]; j < minimum.length; j++) {
				minimum[j]=minimum[j]+minimum[j-coins[i]];
			}
		}
	}

}