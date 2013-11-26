import java.util.Scanner;

public class Boxes_uva11003 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		while(n!=0){
			int[] boxes = new int[6001];
			int[] weights = new int[1000];
			int[] loads = new int[1000];
			for (int i = 0; i < n; i++) {
				weights[i] = scan.nextInt();
				loads[i] = scan.nextInt();
			}
			int max = maximumSequence(boxes,weights,loads, n);
			System.out.println(max);
			n = scan.nextInt();
		}

	}

	private static int maximumSequence(int[] boxes, int[] weights, int[] loads, int n) {

		for (int i = n-1; i >= 0; i--) {
			for (int j = loads[i]; j >= 0; j--) {
				if(boxes[ j ] > 0){
					boxes[ j + weights[ i ]] = Math.max( boxes[ j + weights[ i ]], boxes[ j ]+1);
				}
			}
			boxes[ weights[ i ] ] = Math.max( boxes[ weights[ i] ], 1);
		}	
		int max = 1;
		for (int i = 0; i < boxes.length; i++) {
			max = (boxes[i]>max)?boxes[i]:max;
		}
		return max;
	}

}
