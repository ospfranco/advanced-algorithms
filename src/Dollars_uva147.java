import java.util.Scanner;

public class Dollars_uva147 {
	private static int[] coins = {5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000};
	private static long[] maximum = new long[30005];

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		pre();
		String numString = scan.nextLine();
		double numDouble = Double.parseDouble(numString);
		while(numDouble != 0){
			int num = (int) Math.round(numDouble*100);
			String res = Stringify(numString, maximum[num]);
			if(num%5!=0)
				System.out.println(0);
			else
				System.out.println(res);
			numString = scan.nextLine();
			numDouble = Double.parseDouble(numString);
		}
	}
	
	private static String Stringify(String num, long l) {
		String res="";
		if(num.length()==4)
			res+="  "+num;
		else if(num.length()==5)
			res+=" "+num;
		else
			res+=num;
		for (int i = 0; i < 17-count(l); i++) {
			res+=" ";
		}
		res+=l;
		return res;
	}

	private static void pre(){
		maximum[0] = 1;
		maximum[1] = 1;
		maximum[2] = 1;
		maximum[3] = 1;
		maximum[4] = 1;
		for (int i = 0; i < coins.length; i++) {
			for (int j = coins[i]; j < maximum.length; j++) {
				maximum[j]=maximum[j] + maximum[j-coins[i]];
			}
		}
	}
	
	private static int count(long n){
		int res = 0;
		while(n!=0){
			res++;
			n=n/10;
		}
		return res;
	}

}
