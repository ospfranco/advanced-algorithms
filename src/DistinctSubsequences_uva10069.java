import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
 
public class DistinctSubsequences_uva10069 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(in.readLine());
        while (tc-- > 0) {
            String a = in.readLine();
            String b = in.readLine();
            BigInteger[][] res = new BigInteger[a.length() + 1][b.length() + 1];
            for (int i = 0; i <= a.length(); i++) {
                for (int j = 0; j < b.length(); j++)
                    res[i][j] = BigInteger.ZERO;
                res[i][b.length()] = BigInteger.ONE;
            }
            //print(a,b,res);
            for (int i = a.length() - 1; i >= 0; i--)
                for (int j = b.length() - 1; j >= 0; j--) {
                    res[i][j] = res[i + 1][j];
                    if (a.charAt(i) == b.charAt(j))
                        res[i][j] = res[i][j].add(res[i + 1][j + 1]);
                    //print(a,b,res);
                }
            System.out.println(res[0][0]);
        }
    }
    
    public static void print(String a, String b,BigInteger[][] res){
    	System.out.print("  ");
    	for (int i = 0; i < res[0].length-1; i++) {
			System.out.print(b.charAt(i)+"  ");
		}
    	System.out.println();
    	for (int i = 0; i < res.length; i++) {
    		if(i<res.length-1)
    			System.out.print(a.charAt(i)+" ");
    		else System.out.print("  ");
			for (int j = 0; j < res[0].length; j++) {
				System.out.print(res[i][j]+", ");
			}
			System.out.println();
		}
    	System.out.println();
    }
}