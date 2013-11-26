import java.util.Scanner;
import java.util.ArrayList;

public class LongestMatch_uva10100 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = 1;
		while(scan.hasNext()){
			ArrayList<String> cad1 = new ArrayList();
			ArrayList<String> cad2 = new ArrayList();
			char[] l1 = scan.nextLine().toCharArray();
			char[] l2 = scan.nextLine().toCharArray();
			if(l1.length==0 || l2.length == 0){
				if(T < 10){
					System.out.println(" "+T+". Blank!");	
				}
				else{
					System.out.println(T+". Blank!");
				}
				T++;
			}
			else{
				String temp = "";
				for (int i = 0; i < l1.length; i++) {
					if(isAlpha(l1[i])){
						temp+=l1[i];
					}
					else{
						if(!temp.equals(""))
							cad1.add(temp);
						temp="";
					}
				}
				if(isAlpha(l1[l1.length-1]) && !temp.equals(""))
					cad1.add(temp);
				temp = "";
				for (int i = 0; i < l2.length; i++) {
					if(isAlpha(l2[i])){
						temp+=l2[i];
					}
					else{
						if(!temp.equals(""))
							cad2.add(temp);
						temp="";
					}
				}
				if(isAlpha(l2[l2.length-1]) && !temp.equals(""))
					cad2.add(temp);
				int lcs = LCS(cad1, cad2);
				//System.out.println(cad1.toString());
				//System.out.println(cad2.toString());
				if(T < 10){
					System.out.println(" "+T+". Length of longest match: "+lcs);	
				}
				else{
					System.out.println(T+". Length of longest match: "+lcs);
				}
				T++;
				
			}
			
		}
	}

	private static int LCS(ArrayList<String> cad1, ArrayList<String> cad2) {
		int m = cad1.size();
		int n = cad2.size();
		int[][] c = new int[m+1][n+1];
		for (int i = 0; i <= m; i++) {
			c[i][0] = 0;
		}
		for (int i = 0; i < n; i++) {
			c[0][i] = 0;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if(cad1.get(i-1).equals(cad2.get(j-1))){
					c[i][j] = c[i-1][j-1]+1;
				}
				else if(c[i-1][j] >= c[i][j-1])
					c[i][j] = c[i-1][j];
                else
                     c[i][j] = c[i][j-1];
			}
		}
		return c[m][n];
	}

	public static boolean isAlpha(char a){
		if(a >= 'a' && a <= 'z') return true;
		if(a >= 'A' && a <= 'Z') return true;
		if(a >= '0' && a <= '9') return true;
		return false;
	}
}
