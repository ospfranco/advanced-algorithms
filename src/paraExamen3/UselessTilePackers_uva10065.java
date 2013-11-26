package paraExamen3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.Scanner;

public class UselessTilePackers_uva10065 {
	static Punto p0;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int T = 1;
		while(n != 0){
			Punto[] points = new Punto[n];
			
			for (int i = 0; i < n; i++) {
				points[i] = new Punto(scan.nextInt(), scan.nextInt());
			}
			
			int ymin = points[0].y, min = 0;
			for (int i = 1; i < points.length; i++) {
				int y = points[i].y;
				
				if(y < ymin || (ymin == y && points[i].x < points[min].x)){
					ymin = points[i].y; min = i;
				}
			}
			
			swap(points[0], points[min]);
			
			p0 = points[0];
			Comp c = new Comp();
			Arrays.sort(points, c);
			
			double areaPolygon = polygonArea(points, n);
			
			Punto[] hull = convexHull(points, n);
			double areaHull = polygonArea(hull, hull.length);
			
			double wastedSpace = (((double)areaHull-(double)areaPolygon)/(double)areaHull)*100;
			System.out.println("area poligono: "+areaPolygon+" Area Hull: "+areaHull+" Area desperdiciada: "+((double)areaHull-(double)areaPolygon)+" division: "+wastedSpace);
			String res = "Tile #"+T+"\n";
			res += String.format("Wasted Space = %.2f", wastedSpace) + " %\n";
			System.out.println(res);
			
			T++;
			n = scan.nextInt();
		}

	}

	private static double polygonArea(Punto[] p, int n) {
		double area = 0;
		int j = n - 1;
		for (int i = 0; i < n; i++) {
			area += (p[j].x +p[i].x) * (p[j].y-p[i].y);
			j = i;
		}
		return Math.abs(area / 2);
	}
	
	private static Punto[] convexHull(Punto[] puntos, int n) {
		int ymin = puntos[0].y, min = 0;
		for (int i = 1; i < puntos.length; i++) {
			int y = puntos[i].y;
			
			if(y < ymin || (ymin == y && puntos[i].x < puntos[min].x)){
				ymin = puntos[i].y; min = i;
			}
		}
		
		swap(puntos[0], puntos[min]);
		
		p0 = puntos[0]; 
		Comp c = new Comp();
		Arrays.sort(puntos, c);
		
		Deque<Punto> stack = new ArrayDeque<Punto>();
		stack.push(puntos[0]);
		stack.push(puntos[1]);
		stack.push(puntos[2]);
		
		for (int i = 3; i < n; i++) {
			while(orientation(nextToTop(stack), stack.peek(), puntos[i])!=2){
				stack.pop();
			}
			stack.push(puntos[i]);
		}
		
		Punto[] res = new Punto[stack.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = stack.pop();
		//	System.out.println("punto "+i+" "+res[i].x+" "+res[i].y);
		}
		/*System.out.println("puntos del hull:");
		while(!stack.isEmpty()){
			System.out.println(stack.peek().x +" "+ stack.peek().y);
			stack.pop();
		}
		System.out.println("----------");*/
		return res;
	}
	
	private static int orientation(Punto p, Punto q, Punto r) {
		 int val = (q.y - p.y) * (r.x - q.x) -
	              (q.x - p.x) * (r.y - q.y);
	 
	    if (val == 0) return 0;  // colinear
	    return (val > 0)? 1: 2;
	}
	
	private static Punto nextToTop(Deque<Punto> s){
		Punto p = s.poll();
		Punto res = s.peek();
		s.push(p);
		return res;
	}
	
	private static void swap(Punto p1, Punto p2){
		Punto aux = p1;
		p1 = p2;
		p2 = aux;
	}

	static class Punto{
		public int x,y;
		public Punto(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static class Comp implements Comparator<Punto>{

		@Override
		public int compare(Punto p1, Punto p2) {
			int o = orientation(p0, p1, p2);
			if(o == 0)
				return (dist(p0, p2) >= dist(p0, p1))? -1 : 1;
			return (o == 2)? -1: 1;
		}

		private int dist(Punto p1, Punto p2) {
			 return (p1.x - p2.x)*(p1.x - p2.x) + (p1.y - p2.y)*(p1.y - p2.y);
		}

		private int orientation(Punto p, Punto q, Punto r) {
			 int val = (q.y - p.y) * (r.x - q.x) -
		              (q.x - p.x) * (r.y - q.y);
		 
		    if (val == 0) return 0;  // colinear
		    return (val > 0)? 1: 2;
		}
		
	}

}
