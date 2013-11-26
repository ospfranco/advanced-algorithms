package Capitulo2;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class ContestScoreboard_UVa10258{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		scan.nextLine();
		boolean outfirst=true;
		int cont=1;
		for (int i = 0; i < n; i++) {
			String line=scan.nextLine();
			ArrayList<team> teams = new ArrayList<team>();
			while(!line.isEmpty()){
				String[] l = line.split(" ");
				char result=l[3].charAt(0);
				int c = search(teams,Integer.parseInt(l[0]));
				int problem = Integer.parseInt(l[1]);
				int time = Integer.parseInt(l[2]);
				if(result=='C')
					if(teams.get(c).solvedC[problem]==false){
						teams.get(c).solved+=1;
						teams.get(c).time+=teams.get(c).acumT[problem]+time;
						teams.get(c).solvedC[problem]=true;
						}				
				if(result=='I')
					if(teams.get(c).solvedC[problem]==false)
						teams.get(c).acumT[problem]+=20;
				if(!scan.hasNext())
					break;
				line=scan.nextLine();
			}
			if(outfirst)
				outfirst=false;
			else
				System.out.println();
			Collections.sort(teams);
			for (int j = teams.size()-1; j >= 0; j--) {
					System.out.println(teams.get(j).id+" "+teams.get(j).solved+" "+teams.get(j).time);
			}
			
			cont++;
		}
	}
	
	public static int search(ArrayList<team> lista, int idx){
		int res = -1;
		for(int i = 0; i < lista.size();i++){
			if(lista.get(i).id==idx)
				res = i;
		}
		if(res==-1){
			lista.add(new team(idx));
			res=lista.size()-1;}
		return res;
	}
	static class team implements Comparable<team>{
		public int id;
		public int solved;
		public boolean[] solvedC = new boolean[10];
		public int[] acumT = new int[10];
		public int time;
		public team(int id){
			this.id =id;
		}

		
		public int compareTo(team teamb) {
			int res = 0;
			if(this.solved>teamb.solved)
				res=1;
			else
				if(this.solved==teamb.solved && this.time<teamb.time)
					res=1;
				else
					if(this.solved<teamb.solved)
						res=-1;
					else
						if(this.solved==teamb.solved && this.time>teamb.time)
							res=-1;
						else
							if(this.id>teamb.id)
								res=-1;
							else
								res=1;
			return res;
		}
	}
}