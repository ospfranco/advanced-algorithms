package Capitulo2;
import java.util.Scanner;
public class IDcodes_UVa146 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			String linea = scan.nextLine();
			if(linea.equals("#"))
				break;
			else{
				int y = 0;
				int x = 0;
				boolean stop = false;
				char[] l = linea.toCharArray();
				for(int i = 1;i<l.length;i++){
					for(int j = 0;j<i;j++){
						if(l[l.length-i-1]<l[l.length-j-1]){
							y=l.length-i-1;
							x=l.length-j-1;
							stop=true;
						}
						if(stop) break;
					}
					if(stop) break;
				}
				if(x==y&&y==0)
					System.out.println("No Successor");
				else{
					char aux = l[y];
					l[y]=l[x];
					l[x]=aux;
					char[] WL=new char[x-y];
					int CWL=0;
					char[] WR=new char[l.length-x];
					int CWR =0;
					for(int i = y+1;i<x;i++){
						WL[CWL]=l[i];
						CWL++;
					}
					for(int i =x+1;i<l.length;i++){
						WR[CWR]=l[i];
						CWR++;
					}
					WR = invertir(WR);
					WL = invertir(WL);
					String re1="";
					for(char a:WR)
					 re1+=a;
					String re2 ="";
					for(char a:WL)
						re2+=a;
					String res = "";
					for(int i = 0;i<y+1;i++)
						res+=l[i];
					res+=re1.substring(1,re1.length());
					res+=l[x];
					res+=re2.substring(1,re2.length());
					System.out.println(res);
				}					
			}				
		}
	}
	public static char[] invertir(char[] a){
		char[] res = new char[a.length];
		for(int i = 0;i<a.length;i++)
			res[i]=a[a.length-i-1];
		return res;
	}
}
