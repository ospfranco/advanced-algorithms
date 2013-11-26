package Capitulo1;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class ListOfConquests_UVa10420 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		ArrayList<pais> paises = new ArrayList();
		boolean found =false;
		Comparator comparador = new Comparator(){
			public int compare(Object o1,Object o2){
				pais p1 = (pais) o1;
				pais p2 = (pais) o2;
			return p1.getNombre().compareToIgnoreCase(p2.getNombre());
			}
		};
			
		int n = scan.nextInt();
		scan.nextLine();
		for(int i = 0;i < n; i++){
			found = false;
			String cad = scan.nextLine();
			char[] cade = cad.toCharArray();
			String p = "";
			for(int j = 0;j<cade.length;j++)
				if(cade[j]==' ')
					break;
				else
					p+=cade[j];
			for(int j = 0;j<paises.size();j++)
				if(paises.get(j).getNombre().equals(p)){
					paises.get(j).add1();
					found=true;
					break;}
			if(found==false)
				paises.add(new pais(p));
		}
		
			Collections.sort(paises,comparador);
				
			for(int i = 0;i<paises.size();i++)
				System.out.println(paises.get(i).getNombre()+" "+paises.get(i).getN());
	}
	
	public static class pais{
		private int n = 1;
		private String nombre;
		public pais(String nombre){
			this.setNombre(nombre);
		}
		public void add1(){
			n++;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public int getN(){
			return n;
		}
	}
}