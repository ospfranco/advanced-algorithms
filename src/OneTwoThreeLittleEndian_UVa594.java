package Capitulo2;
import java.util.Scanner;
import java.math.BigInteger;
public class OneTwoThreeLittleEndian_UVa594 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int n = scan.nextInt();
			String binaryN = Integer.toBinaryString(n);
			while(binaryN.length()<32)
				binaryN=0+binaryN;
			String[] cadN = new String[4];
			cadN[0]=binaryN.substring(0,8);
			cadN[1]=binaryN.substring(8,16);
			cadN[2]=binaryN.substring(16,24);
			cadN[3]=binaryN.substring(24,32);

			String aux = cadN[3];
			cadN[3]=cadN[0];
			cadN[0]=aux;
			aux=cadN[2];
			cadN[2]=cadN[1];
			cadN[1]=aux;
			String Sres = cadN[0]+cadN[1]+cadN[2]+cadN[3];
			int res=0;
			int conf = 32;
			String Nres="";
			if(Sres.charAt(0)=='1'){
				for(int i =1;i<32;i++){
					if(Sres.charAt(32-i) =='1') {conf = 32-i;break;}
				}
				for(int i = 0;i<conf;i++){
					Nres+= Sres.charAt(i)=='1'? '0':'1';
				}
				for(int i = conf;i<32;i++){
					Nres+=Sres.charAt(i);
				}
				System.out.println(n+" converts to -"+Integer.parseInt(Nres,2));
			}
			else{
				res = Integer.parseInt(Sres,2);
				System.out.println(n+" converts to "+res);}
		}
	}
}
