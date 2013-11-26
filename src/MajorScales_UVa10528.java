package Capitulo1;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class MajorScales_UVa10528 {
	static List<List<Integer>> scalasValidas = initScalas();
	static List<String> nombreNotas = initNombres();
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String lin = scan.nextLine();
		while(!lin.equals("END")){
			List<List<Integer>> can = new ArrayList<List<Integer>>(scalasValidas);
			String[] l= lin.split(" ");
			for(int i = 0;i<can.size();i++)
				for(int j = 0;j<l.length;j++){
					if(!can.get(i).contains(nombreNotas.indexOf(l[j]))){
						can.remove(i);
						i--;
						break;}
				}
			boolean first = true;
			String spa = "";
			for(List a:can){
				if(first)
					first=false;
				else
					spa=" ";
				System.out.print(spa+nombreNotas.get((Integer) a.get(0)));}
			System.out.println();
			lin=scan.nextLine();
		}
		
	}
	
	private static List<String> initNombres(){
		List<String> res = new LinkedList<String>();
		res.add("C");
		res.add("C#");
		res.add("D");
		res.add("D#");
		res.add("E");
		res.add("F");
		res.add("F#");
		res.add("G");
		res.add("G#");
		res.add("A");
		res.add("A#");
		res.add("B");
		return res;
	}
	
	private static List<List<Integer>> initScalas(){
		ArrayList<List<Integer>> res=new ArrayList<List<Integer>>();
		for(int i = 0;i<12;i++){
			res.add(initScala(i));
		}
		return res;
	}
	
	private static List<Integer> initScala(int i){
		List<Integer> res = new LinkedList<Integer>();
		int nota = i;
		res.add(nota%12);
		nota+=2;
		res.add(nota%12);
		nota+=2;
		res.add(nota%12);
		nota+=1;
		res.add(nota%12);
		nota+=2;
		res.add(nota%12);
		nota+=2;
		res.add(nota%12);
		nota+=2;
		res.add(nota%12);
		nota+=1;
		res.add(nota%12);
		return res;
	}
}
