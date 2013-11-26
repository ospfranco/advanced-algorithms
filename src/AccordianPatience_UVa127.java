package Capitulo2;

import java.io.*;
import java.util.*;

public class AccordianPatience_UVa127 {
	static int total=0;
	static Stack[] og = new Stack[52];
	public static void main(String[] args) throws IOException{
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		String li1 = scan.readLine();
		String li2;
		for (int i = 0; i < og.length; i++) {
			og[i] = new Stack<String>();
		}
		StringBuffer sb = new StringBuffer();
		while(!li1.equals("#")){
			li2 = scan.readLine();
			total = 52;
			String l = (li1+" "+li2);
			StringTokenizer token = new StringTokenizer(l);
			ArrayList<Stack<String>> stacks = new ArrayList<Stack<String>>();
			stacks.clear();
			for(int i = 0;i<52;i++){
				stacks.add(og[i]);
				stacks.get(i).push(token.nextToken());
				}
			Accordian(stacks);
			if(stacks.size()>1){
				sb.append(total+" piles remaining:");
				for(int i = 0;i<total;i++){
					sb.append(" "+stacks.get(i).size());
					stacks.get(i).clear();}
				sb.append("\n");}
			else
				sb.append("1 pile remaining: 52\n");
			li1 = scan.readLine();
		}
		System.out.print(new String(sb));
	}
	
	public static void Accordian(ArrayList<Stack<String>> list){
		int i;
		
		for(i=0;i<total;i++){
			if(i >= 3 && (list.get(i-3).peek().charAt(0)==list.get(i).peek().charAt(0)||list.get(i-3).peek().charAt(1)==list.get(i).peek().charAt(1))){
				list.get(i-3).push(list.get(i).pop());
				if(list.get(i).isEmpty()){
					total--;
					list.remove(i);
				}
				i = i - 4;
			}
			else if(i>=1 && (list.get(i-1).peek().charAt(0)==list.get(i).peek().charAt(0)||list.get(i-1).peek().charAt(1)==list.get(i).peek().charAt(1))){
				list.get(i-1).push(list.get(i).pop());
				if(list.get(i).isEmpty()){
					total--;
					list.remove(i);
				}
				i = i - 2;
			}
		}
	}
}
