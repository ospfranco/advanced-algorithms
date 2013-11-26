import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class StringComputer_uva164 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String scomplete = scan.nextLine();
		while(!scomplete.equals("#")){
			String[] scompleteArray = scomplete.split(" ");
			String s1 = scompleteArray[0];
			String s2 = scompleteArray[1];
			int[][] m = new int[s2.length()+1][s1.length()+1];
			dir[][] direcciones = new dir[s2.length()+1][s1.length()+1];
			fill(s2, s1 ,m, direcciones);
			ArrayList<dir> res = trace(m, direcciones,s2,s1);
			int acarreo = 0;
			char last = 'a';
			//if(res.get(res.size()-1).val==0)
				//acarreo=1;
			for (int i = res.size()-1; i > -1; i--) {
				
				if(res.get(i).pre.charAt(0)=='I'){
					acarreo++;
					//last = 'I';
				}
				//System.out.println("Acarreo "+acarreo);
				//if((last== 'I' && res.get(i).pre.charAt(0)!='I')||(last== 'D' && res.get(i).pre.charAt(0)!='D'))
				//if(res.get(i).val==0)
					//res.get(i).val=1;
				res.get(i).acarreo(acarreo);
				System.out.print(res.get(i).Stringify());
				if(res.get(i).pre.charAt(0)=='D'){
					acarreo--;
					//last = 'D';
				}
				
			}
			System.out.print("E\n");
			//print(s2,s1,m);
			scomplete = scan.nextLine();
		}
	}
	
    private static ArrayList<dir> trace(int[][] m, dir[][] direcciones, String s2, String s1) {
		int x = m.length-1;
		int y = m[0].length-1;
		int acarreo=0;
		ArrayList<dir> res = new ArrayList();
		dir arr = new dir(0, -1);
		dir izq = new dir(-1, 0);
		dir dia = new dir(-1, -1);
		dir actual = direcciones[x][y];
		while(x!=0 || y!=0){
			actual = direcciones[x][y];
			if(actual.equals(arr)){
				//if((y+acarreo)<10)
					actual.setString("D"+s1.charAt(y-1), y);
					res.add(actual);
					//res.add("D"+s1.charAt(y-1)+"0"+y);
				//else
					//actual.setString("D"+s1.charAt(y-1),y);
					//res.add("D"+s1.charAt(y-1)+y);
				//acarreo++;
			}
			else if(actual.equals(izq)){
				//if((x+acarreo)<10)
	//				res.add("I"+s2.charAt(x-1)+"0"+(x+acarreo));
					actual.setString("I"+s2.charAt(x-1), y);
					res.add(actual);
				//else
					//res.add("I"+s2.charAt(x-1)+(x+acarreo));
				//acarreo;
			}
			else if(actual.equals(dia)){
				if(s2.charAt(x-1)!=s1.charAt(y-1)){
					actual.setString("C"+s2.charAt(x-1), y);
					res.add(actual);
				}
					
				//	if(x<10)
						//res.add("C"+s2.charAt(x-1)+"0"+(x+acarreo));
					//else
						//res.add("C"+s2.charAt(x-1)+(x+acarreo));
			}
			//System.out.println(x+" "+y+" -> "+direcciones[x][y].toString());
			int xAux=x+direcciones[x][y].x;
			int yAux=y+direcciones[x][y].y;
			x = xAux;
			y = yAux;
		}
		
		return res;
	}

	private static void fill(String s2, String s1, int[][] m, dir[][] d) {
    	
    	for (int i = 0; i < m.length; i++) {
    		m[i][0]=i;
    		d[i][0] = new dir(-1,0);
		}
    	
    	for (int i = 0; i < m[0].length; i++) {
    		m[0][i]=i;
    		d[0][i]=new dir(0,-1);
		}
    	
    	for (int i = 1; i < m.length; i++) {
			for (int j = 1; j < m[0].length; j++) {
				int minArr = m[i-1][j];
				int minIzq = m[i][j-1];
				int minDiag = m[i-1][j-1];
				//System.out.println("minimoArr "+minArr+" minIZQ "+ minIzq+" minDiag "+minDiag);
				
				if(s2.charAt(i-1)!=s1.charAt(j-1)){
					if(minDiag +1 <= minIzq && minDiag+1 <= minArr){
						m[i][j] = m[i-1][j-1]+1;
						d[i][j] = new dir(-1, -1);
					}
					else if(minIzq <= minArr && minIzq <= minDiag){
						m[i][j] = m[i][j-1]+1;
						d[i][j] = new dir(0, -1);
					}
					else if(minArr <= minIzq && minArr <= minDiag){
						m[i][j] = m[i-1][j]+1;
						d[i][j] = new dir(-1, 0);
					} 
				}
				else{
					if(minDiag <= minIzq && minDiag <= minArr){
						m[i][j] = m[i-1][j-1];
						d[i][j] = new dir(-1, -1);
					}
					else if(minIzq <= minArr && minIzq <= minDiag){
						m[i][j] = m[i][j-1]+1;
						d[i][j] = new dir(0, -1);
					}
					else if(minArr <= minIzq && minArr <= minDiag){
						m[i][j] = m[i-1][j]+1;
						d[i][j] = new dir(-1, 0);
					}
				}
			}
		}
	}

	public static void print(String a, String b,int[][] res){
    	System.out.println(res.length+" "+res[0].length);
    	System.out.print("         ");
    	for (int i = 0; i < b.length(); i++) {
			System.out.print(b.charAt(i)+"  ");
		}
    	System.out.println();
    	for (int i = 0; i < res.length; i++) {
    		if(i<a.length()+1 && i > 0)
    			System.out.print(a.charAt(i-1)+" ");
    		else System.out.print("  ");
			for (int j = 0; j < res[0].length; j++) {
				System.out.print(res[i][j]+", ");
			}
			System.out.println();
		}
    	System.out.println();
    }
	static class dir{
		public int x, y;
		public int val;
		public String pre;
		public dir(int x, int y){
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString(){
			return "["+x+" ,"+y+"]";
		}
		
		public boolean equals(dir other){
			if(other.x==this.x && other.y==this.y)
				return true;
			return false;
		}
		
		public void setString(String pre, int val){
			this.pre = pre;
			this.val=val;
		}
		public void acarreo(int i){
			this.val+=i;
		}
		public String Stringify(){
			if(this.val<10)
				return this.pre+"0"+this.val;
			else
				return this.pre+this.val;
			
		}
	}
}
