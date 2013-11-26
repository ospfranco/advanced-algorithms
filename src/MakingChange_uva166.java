import java.util.Scanner;

public class MakingChange_uva166 {
	static int[] coins = {5,10,20,50,100,200};
	static int[] A = new int[6];
	static int[] dp = new int[1001];
	static int INFINITE = 20000000;
	static int max = 1000;
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		
		for (int i = 0; i < A.length; i++) {
			A[i]=scan.nextInt();
		}
		
		while(A[0]!=0 || A[1]!=0 || A[2]!=0 || A[3]!=0 || A[4]!=0 || A[5]!=0){
			int min = INFINITE;
			pre();
			Double num = scan.nextDouble();
			int n = (int)Math.round(num*100);
			
			for (int i = n; i < 1000; i++) {
				min = Math.min(min, dp[i] + minimumChange(i-n));
			}
			if(min<10)
				System.out.println("  "+min);
			else if(min < 100)
				System.out.println(" "+min);
			else
				System.out.println(min);
			
			for (int i = 0; i < A.length; i++) {
				A[i]=scan.nextInt();
			}
		}
		
	}

	private static int minimumChange(int v) {
		for (int i = 5; i > -1; i--) {
			if(v >= coins[i])
			{
				return 1 + minimumChange(v-coins[i]);
			}
		}
		return 0;
	}

	private static void pre() {
		dp[0]=0;
		for (int i = 1; i < dp.length; i++) {
			dp[i]=INFINITE;					
		}
		for (int c = 0; c < 6; c++) {
			while (A[c] != 0) {
				for (int i = (max - coins[c] - 1); i > -1; i--) {
					if(dp[i] < INFINITE)
					{
						dp[i + coins[c]]= Math.min(dp[i]+1, dp[i+coins[c]]);
					}
				}
				A[c]--;
			}
		}
	}
}
