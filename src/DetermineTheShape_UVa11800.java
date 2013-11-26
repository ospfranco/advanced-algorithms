package Capitulo1;
import java.util.Scanner;
public class DetermineTheShape_UVa11800 {
	public static void main(String[] args){
		int[][] perm =  {{1,2,3},{1,3,2},{2,1,3},{2,3,1},{3,1,2},{3,2,1}};
		punto[] puntos =new punto[4];
		punto v1 = new punto(0,0);
		punto v2 = new punto(0,0);
		punto v3 = new punto(0,0);
		punto v4 = new punto(0,0);
		punto p1 = new punto(0,0);
		punto p2 = new punto(0,0);
		punto p3 = new punto(0,0);
		punto p4 = new punto(0,0);
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for(int i = 0;i < n;i++){
			p1.x=scan.nextLong();
			p1.y=scan.nextLong();
			p2.x=scan.nextLong();
			p2.y=scan.nextLong();
			p3.x=scan.nextLong();
			p3.y=scan.nextLong();
			p4.x=scan.nextLong();
			p4.y=scan.nextLong();
			long r1,r2,r3,r4;
			puntos[0]=p1;
			puntos[1]=p2;
			puntos[2]=p3;
			puntos[3]=p4;
			int cont = 0;
			boolean exito = false;
			boolean stop = false;
			while(exito==false && !stop){
				v1.x=( puntos[perm[cont][0]].x-p1.x);
				v1.y=( puntos[perm[cont][0]].y-p1.y);
				v2.x=( puntos[perm[cont][1]].x-puntos[perm[cont][0]].x);
				v2.y=( puntos[perm[cont][1]].y-puntos[perm[cont][0]].y);
				v3.x=( puntos[perm[cont][2]].x-puntos[perm[cont][1]].x);
				v3.y=( puntos[perm[cont][2]].y-puntos[perm[cont][1]].y);
				v4.x=( p1.x-puntos[perm[cont][2]].x);
				v4.y=( p1.y-puntos[perm[cont][2]].y);
				
				r1=v1.x*v2.y -v2.x*v1.y;
				r2=v2.x*v3.y -v3.x*v2.y;
				r3=v3.x*v4.y -v4.x*v3.y;
				r4=v4.x*v1.y -v1.x*v4.y;
				
				if((r1>0&&r2>0&&r3>0&&r4>0)||(r1<0&&r2<0&&r3<0&&r4<0))
					exito=true;
				cont++;
				if(cont==6)
					stop=true;
				
			}
			
			long tama = tam(v1);
			long tamb = tam(v2);
			long tamc = tam(v3);
			long tamd = tam(v4);
			
			if(prodPunto(v1, v2) == 0 && prodPunto(v2, v3) == 0
		            && prodPunto(v3, v4) == 0 && prodPunto(v4, v1) == 0){
		            if(tama == tamb && tamb == tamc && tamc == tamd)
		                System.out.printf("Case %d: Square\n", i + 1);
		            else
		                System.out.printf("Case %d: Rectangle\n", i + 1);
		        }
		        else{
		            if(tama == tamb && tamb == tamc && tamc == tamd)
		                System.out.printf("Case %d: Rhombus\n", i + 1);
		            else{
		              if(tama == tamc && tamb == tamd)
		                System.out.printf("Case %d: Parallelogram\n", i + 1);
		              else{
		                    if(prodCruz(v1, v3) == 0 || prodCruz(v2, v4) == 0) 
		                        System.out.printf("Case %d: Trapezium\n", i + 1);
		                    else
		                        System.out.printf("Case %d: Ordinary Quadrilateral\n", i + 1);
		                }
		            }
		        }
		    }
		}		
	
	
	private static long prodPunto(punto a, punto b){
		return a.x * b.x + a.y * b.y;
	}
	
	private static long tam(punto a){
		return a.x*a.x + a.y*a.y;
	}

	private static long prodCruz(punto a, punto b){
		return (a.x*b.y -b.x*a.y);
		
	}
	
	public static class punto{
		public long x;
		public long y;
		
		public punto(long a,long b){
			this.x = a;
			this.y = b;}
	}
}