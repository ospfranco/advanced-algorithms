import java.util.Scanner;

public class ExcusesExcuses_uva409 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int T = 1;
		while(scan.hasNext()){
			int n = scan.nextInt();
			int e = scan.nextInt();
			scan.nextLine();
			String[] words = new String[n];
			String[] excuses = new String[e];
			String[] ogExcuses = new String[e];
			int[] num = new int[e];
			for (int i = 0; i < n; i++) {
				words[i] = scan.nextLine();
			}
			for (int i = 0; i < e; i++) {
				excuses[i] = scan.nextLine();
				ogExcuses[i] = excuses[i].toLowerCase();
			}
			char[][] excuses2 = new char[20][71];
			for (int i = 0; i < excuses.length; i++) {
				char[] excuse = ogExcuses[i].toCharArray();
				for (int j = 0; j < excuse.length; j++) {
					if(!isAlpha(excuse[j])){
						excuse[j]=' ';
					}
				}
				excuses2[i]=excuse;
			}
			int max = 0;
			for (int i = 0; i < e; i++) {
				
				String[] sentence = new String(excuses2[i]).split(" ");
				for (int j = 0; j < sentence.length; j++) {
					for (int j2 = 0; j2 < words.length; j2++) {
						if(sentence[j].equals(words[j2])){
							num[i]++;
						}
					}
				}
				max = (num[i]>max)?num[i]:max;
			}
			System.out.println("Excuse Set #"+T);
			for (int i = 0; i < excuses.length; i++) {
				if(num[i]==max)
					System.out.println(excuses[i]);
			}
			System.out.println();
			T++;
		}
	}
	
	public static boolean isAlpha(char a){
		
		if((a>='a' && a <= 'z') || (a>='0' && a <='9') )
			return true;
		else
			return false;
	}
	
	public static void print(char[][] arr){
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
}
