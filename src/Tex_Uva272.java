package Capitulo1;
	import java.util.Scanner;
	public class Tex_Uva272 {
		public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			boolean time = false;
			while(scan.hasNext()){
				String linea = scan.nextLine();
				String res = "";
				char[] clinea;
				clinea = linea.toCharArray();
				for(int i = 0;i<clinea.length;i++)
					if(clinea[i]=='"')
						if(time==false){
							res = res + "``";
							time = true;}
						else{
							res = res + "''";
							time = false;}
						
					else
						res = res + clinea[i]; 
				System.out.println(res);
				
			}
		}
	
	}
