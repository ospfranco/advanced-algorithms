package paraExamen3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.Scanner;

public class UselessTilePackers_uva10065 {
	static Punto p0;
	static int[] xPoints, yPoints;
	static int xPoints2[];
    static int yPoints2[];
    static int num, pNum;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int T = 1;
		while(n != 0){
			xPoints = new int[n];
			yPoints = new int[n];
			num = 0;
			pNum = n;
			
			for (int i = 0; i < n; i++) {
				xPoints[i] = scan.nextInt();
				yPoints[i] = scan.nextInt();
			}
			
			xPoints2 = new int[n];
			yPoints2 = new int[n];
		
			double areaPolygon = polygonArea(xPoints, yPoints, n);
			
			quickconvexhull();
			
			double areaHull = polygonArea(xPoints2, yPoints2, xPoints2.length);
			
			double wastedSpace = ((areaHull-areaPolygon)/areaHull)*100;
			
			System.out.println("area poligono: "+areaPolygon+" Area Hull: "+areaHull+" Area desperdiciada: "+((double)areaHull-(double)areaPolygon)+" division: "+wastedSpace);
			
			String res = "Tile #"+T+"\n";
			res += String.format("Wasted Space = %.2f", wastedSpace) + " %\n";
			System.out.println(res);
			
			T++;
			n = scan.nextInt();
		}

	}

	private static double polygonArea(int[] xs, int[] ys, int n) {
		double area = 0;
		int j = n - 1;
		for (int i = 0; i < n; i++) {
			area += (xs[j] +xs[i]) * (ys[j]-ys[i]);
			j = i;
		}
		return Math.abs(area / 2);
	}
	

    // check whether point p is right of line ab
    public static int right(int a, int b, int p)
    {
	return (xPoints[a] - xPoints[b])*(yPoints[p] - yPoints[b]) - (xPoints[p] - xPoints[b])*(yPoints[a] - yPoints[b]);
    }

    // square distance point p to line ab
    public static float distance(int a, int b, int p)
    {
	float x, y, u;
	u = (((float)xPoints[p] - (float)xPoints[a])*((float)xPoints[b] - (float)xPoints[a]) + ((float)yPoints[p] - (float)yPoints[a])*((float)yPoints[b] - (float)yPoints[a])) 
	    / (((float)xPoints[b] - (float)xPoints[a])*((float)xPoints[b] - (float)xPoints[a]) + ((float)yPoints[b] - (float)yPoints[a])*((float)yPoints[b] - (float)yPoints[a]));
	x = (float)xPoints[a] + u * ((float)xPoints[b] - (float)xPoints[a]);
	y = (float)yPoints[a] + u * ((float)yPoints[b] - (float)yPoints[a]);
	return ((x - (float)xPoints[p])*(x - (float)xPoints[p]) + (y - (float)yPoints[p])*(y - (float)yPoints[p]));
    }

    public static int farthestpoint(int a, int b, ArrayList<Integer>al)
    {
	float maxD, dis;
	int maxP, p;
	maxD = -1;
	maxP = -1;
	for ( int i = 0; i < al.size(); i++ ) {
	    p = al.get(i);
	    if ( (p == a) || (p == b) )
		continue;
	    dis = distance(a, b, p);
	    if ( dis > maxD ) {
		maxD = dis;
		maxP = p;
	    }
	}
	return maxP;
    }

    public static void quickhull(int a, int b, ArrayList<Integer>al)
    {
	//System.out.println("a:"+a+",b:"+b+" size: "+al.size());
	if ( al.size() == 0 )
	    return;

	int c, p;

	c = farthestpoint(a, b, al);

	ArrayList<Integer> al1 = new ArrayList<Integer>();
	ArrayList<Integer> al2 = new ArrayList<Integer>();

	for ( int i=0; i<al.size(); i++ ) {
	    p = al.get(i);
	    if ( (p == a) || (p == b) )
		continue;
	    if ( right(a,c,p) > 0 )
		al1.add(p);
	    else if ( right(c,b,p) > 0 )
		al2.add(p);
	}

	quickhull(a, c, al1);
	xPoints2[num] = xPoints[c];
	yPoints2[num] = yPoints[c];
	num++;
	quickhull(c, b, al2);
    }

    public static void quickconvexhull() {

	// find two points: right (bottom) and left (top)
	int r, l;
	r = l = 0;
	for ( int i = 1; i < pNum; i++ ) {
	    if ( ( xPoints[r] > xPoints[i] ) || ( xPoints[r] == xPoints[i] && yPoints[r] > yPoints[i] ))
	    	r = i;
	    if ( ( xPoints[l] < xPoints[i] ) || ( xPoints[l] == xPoints[i] && yPoints[l] < yPoints[i] ))
	    	l = i;
	}

	//System.out.println("l: "+l+", r: "+r);

	ArrayList<Integer> al1 = new ArrayList<Integer>();
	ArrayList<Integer> al2 = new ArrayList<Integer>();

	int upper;
	for ( int i = 0; i < pNum; i++ ) {
	    if ( (i == l) || (i == r) )
		continue;
	    upper = right(r,l,i);
	    if ( upper > 0 )
		al1.add(i);
	    else if ( upper < 0 )
		al2.add(i);
	}

	xPoints2[num] = xPoints[r];
	yPoints2[num] = yPoints[r];
	num++;
	quickhull(r, l, al1);
	xPoints2[num] = xPoints[l];
	yPoints2[num] = yPoints[l];
	num++;
	quickhull(l, r, al2);
    }

	
	
	static class Punto{
		public int x,y;
		public Punto(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	

}
