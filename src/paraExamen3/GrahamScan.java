package paraExamen3;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

public class GrahamScan {
	static Punto p0;
	public static void main(String[] args) {
		Punto[] puntos = {new Punto(0,3),new Punto(1,1),new Punto(2,2),new Punto(4,4),new Punto(0,0),new Punto(1,2),new Punto(3,1),new Punto(3,3),};
		int n = puntos.length;
		convexHull(puntos, n);

	}

	//imprime el convex hull de un conjunto de puntos
	private static void convexHull(Punto[] puntos, int n) {
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
		
		while(!stack.isEmpty()){
			System.out.println(stack.peek().x +" "+ stack.peek().y);
			stack.pop();
		}
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
