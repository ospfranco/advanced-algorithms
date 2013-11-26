package Capitulo2;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Arrays;
public class PermutationArray_UVa482 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		HashMap<Integer,String> numeros = new HashMap<Integer, String>();
		int n = Integer.parseInt(scan.nextLine());
		for(int i = 0 ;i<n;i++){
			scan.nextLine();
			String nums = scan.nextLine();
			String doubles = scan.nextLine();
			String[] num = nums.split(" ");
			String[] doubless = doubles.split(" ");
			for(int j = 0;j<num.length;j++)
				numeros.put(Integer.parseInt(num[j]),doubless[j]);
			Object[] llaves = numeros.keySet().toArray();
			
			Arrays.sort(llaves);
			for(int j = 0;j<llaves.length;j++)
				System.out.println(numeros.get(llaves[j]));
			numeros.clear();
			if(i!=(n-1))
			System.out.println();
		}
	}
}
