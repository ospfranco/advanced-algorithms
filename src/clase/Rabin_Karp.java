package clase;

public class Rabin_Karp {
	
	static String T = "aaabbbaabababbabababbabbabababbbabbbaaabababababbbabbabbababaaababaababaaaabab";
	static String P = "aaab";
	
	static int d = 10;
	static int q = 13;

	public static void main(String[] args) {
		int n = T.length();
		int m = P.length();
		int h = (int)Math.pow(d, m-1)%q;
		//System.out.println(h);
		int p = 0;
		int t = 0;
		for (int i = 1; i < m; i++) {
			p = (d*p + P.charAt(i))%q;
			t = (d*t + T.charAt(i))%q;
		}
		//System.out.println(p);
		//System.out.println(t);
		for (int s = 0; s < n - m; s++) {
			System.out.println(t);
			if(p == t)
				if (P.equals(T.substring(s, s+m)))
					System.out.println("Patron ocurre con cambio "+s);
			if(s < n - m - 1){
				int qq = (-2)%13;
				qq = (qq<0)?qq+13:qq;
				t = (d*(t-T.charAt(s)*h) + T.charAt(s + m))%q;
			}
		}
	}

}
