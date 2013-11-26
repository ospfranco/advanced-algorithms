package Capitulo1;
import java.util.Scanner;
import java.util.ArrayList;
public class Mapmaker_uva394 {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		ArrayList<Array> Arreglos = new ArrayList();
		int n = scan.nextInt();
		int r = scan.nextInt();
		for(int i = 0;i<n;i++){
			String nom = scan.next();
			int bd = scan.nextInt();
			int cd = scan.nextInt();
			int d = scan.nextInt();
			int[] ldud = new int[d*2];
			for(int j = 0; j<d*2;j++){
				ldud[j]= scan.nextInt();
			}
			Arreglos.add(new Array(nom,bd,cd,d,ldud));
			scan.nextLine();
		}
		Array act = Arreglos.get(0);
		for(int i = 0;i<r;i++){
			String nomb = scan.next();
			for(int j = 0;j<Arreglos.size();j++)
				if(Arreglos.get(j).nombre.equals(nomb)){
					act = Arreglos.get(j);
					break;}
			int[] ifj = new int[act.D];
			for(int j = 0;j<act.D;j++)
				ifj[j]=scan.nextInt();
			int dir=act.CFINAL[0];
			int cont = 1;
			for(int j : ifj){
				dir += act.CFINAL[cont]*j;
				cont++;}
			System.out.print(nomb+"[");
			for(int j = 0;j<ifj.length;j++)
				if(j==ifj.length-1)
					System.out.print(ifj[j]);
				else
					System.out.print(ifj[j]+", ");
			System.out.println("] = "+dir);
			scan.nextLine();
		}
	}
	 static class Array{
		 private String nombre;
		 private int BaseDir;
		 private int CD;
		 private int D;
		 private int[] LdUd;
		 private int[] CFINAL;
		 public Array(String nombre,int BaseDir,int CD,int D,int[] LdUd){
			 this.nombre = nombre;
			 this.BaseDir = BaseDir;
			 this.CD = CD;
			 this.D = D;
			 this.LdUd = LdUd;
			 int[] C = new int[D+1];
			 C[D]=CD;
			 for(int i = D-1;i>=1;i--){
				C[i]=C[i+1]*(LdUd[(i*2)+1]-LdUd[i*2]+1);
			 }
			 C[0]=BaseDir;
			 for(int i = 1;i<C.length;i++)
				 C[0]=C[0]-(C[i]*LdUd[(i-1)*2]);
			 CFINAL = C;
		 }
	 }
}
