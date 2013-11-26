import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class IsBiggerSmarter_uva10131 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = 0;
		ArrayList<Elephant> elephants = new ArrayList<Elephant>();
		while(scan.hasNext()){
		//while(n<9){
			n++;
			int size = scan.nextInt();
			int iq = scan.nextInt();
			elephants.add(new Elephant(n,size,iq));
		}
		Collections.sort(elephants);
		//print(elephants);
		ArrayList<Integer> maximum = maximumSequence(elephants);
		System.out.println(maximum.size());
		for (int i = 0; i < maximum.size(); i++) {
			System.out.println(maximum.get(i));
		}

	}
	
	private static ArrayList<Integer> maximumSequence(
			ArrayList<Elephant> e) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < e.size(); i++) {
			res.add(new ArrayList<Integer>());
		}
		for (int i = e.size()-1; i >= 0; i--) {
			Elephant act = e.get(i);
			ArrayList<Integer> max = new ArrayList();
			max.add(act.getN());
			for (int j = i; j < e.size()-1; j++) {
				if(e.get(j).getIq()<act.getIq() && e.get(j).getSize()>act.getSize()){
					if(max.size()< 1 + res.get(j).size()){
					max.clear();
					max.add(act.getN());
					max.addAll(res.get(j));
					}
				}
			}
			res.set(i, max);
		}
		ArrayList<Integer> max = res.get(0);
		for (int i = 1; i < res.size(); i++) {
			max= (res.get(i).size()>max.size())?res.get(i):max;
		}
		return max;
	}

	private static void print(ArrayList<Elephant> elephants) {
		for (int i = 0; i < elephants.size(); i++) {
			System.out.println(elephants.get(i).getN()+" "+elephants.get(i).getSize()+" "+elephants.get(i).getIq());
		}
		
	}

	static class Elephant implements Comparable<Elephant>{
		private int n, size, iq;
		public Elephant(int n, int size, int iq){
			this.setN(n);
			this.setSize(size);
			this.setIq(iq);
		}
		public int getSize() {
			return size;
		}
		public void setSize(int size) {
			this.size = size;
		}
		public int getIq() {
			return iq;
		}
		public void setIq(int iq) {
			this.iq = iq;
		}
		public int getN() {
			return n;
		}
		public void setN(int n) {
			this.n = n;
		}
		@Override
		public int compareTo(Elephant other) {
			int otherSize = other.getSize();
			if(size>otherSize)
				return 1;
			else if(size==otherSize)
				return 0;
			else
				return -1;
		}
		
	}

}
