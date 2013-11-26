package Capitulo1;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.text.DecimalFormat;
public class LightAndTransparencies_UVa837 {
	public static void main(String[] args){
		DecimalFormat f = new DecimalFormat("0.000");
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		ArrayList<Segmento> LSegmentos=new ArrayList();
		for(int i = 0;i<m;i++){
			int n = scan.nextInt();
			ArrayList<Double> exis = new ArrayList();
			for(int j = 0;j<n;j++){
				LSegmentos.add(new Segmento(scan.nextDouble(),scan.nextDouble(),scan.nextDouble(),scan.nextDouble(),scan.nextDouble()));
				exis.add(LSegmentos.get(j).x1);
				exis.add(LSegmentos.get(j).x2);
			}
			Collections.sort(exis);
			System.out.println(exis.size()+1);
			System.out.println("-inf "+f.format(exis.get(0))+" 1.000");
			for(int j=1;j<exis.size();j++){
				System.out.println(f.format(exis.get(j-1))+" "+f.format(exis.get(j))+" "+calcularPorc(exis.get(j-1),exis.get(j),LSegmentos,f));
			}
			System.out.println(f.format(exis.get(exis.size()-1))+" +inf 1.000");
			
			if(i!=m-1)
				System.out.println();
			LSegmentos.clear();
			exis.clear();
		}
	}
	private static String calcularPorc(Double x1, Double x2,ArrayList<Segmento> Lista,DecimalFormat f) {
		double por = 1.0;
		for(Segmento seg:Lista){
			if(x1>=seg.x1 && x2<=seg.x2)
				por *= seg.r;
		}
		
		return f.format(por);
	}
	static class Segmento{
		private double x1,x2,y1,y2,r;
		public Segmento(double x1,double y1,double x2,double y2,double r){
			if(x1<x2){
				this.x1=x1;
				this.x2=x2;
				this.y1=y1;
				this.y2=y2;}
			else{
				this.x1=x2;
				this.x2=x1;
				this.y1=y2;
				this.y2=y1;}
			this.r=r;
		}
	}
}
