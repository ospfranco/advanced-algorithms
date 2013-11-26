package Capitulo1;
import java.util.Scanner;
public class RomanNumerals_UVa11616 {
	public static void main(String []args){
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int n = 0;
			int resEnt = 0;
			String lin=scan.nextLine();
			char[] l = lin.toCharArray();
			if(l[0]>='A'){
				int aux = 0;
				for(int i = 0;i<l.length;i++){
					int value = romarb(l[i]);
					if(i!=l.length-1){
						int value2 = romarb(l[i+1]);
						if(value==value2)
							aux+=value;
						if(value<value2){
							resEnt+=value2-aux-value;
							i++;
							aux=0;}
						if(value>value2){
							resEnt+=value+aux;
							aux = 0;}
						}
					else{
						resEnt+=value+aux;
					}
				}
				System.out.println(resEnt);
			}
			else{
				String res="";
				n = Integer.parseInt(lin);
				int orden=1;
				while(n!=0){
					res= arbrom(n%10,orden)+res;
					n=n/10;
					orden++;
							}
				System.out.println(res);
			}
		}
	}
	public static int romarb(char a){
		int res = 0;
		switch(a){
			case 77: res = 1000;
			break;
			case 68: res = 500;
			break;
			case 67: res = 100;
			break;
			case 76: res = 50;
			break;
			case 88: res = 10;
			break;
			case 86: res = 5;
			break;
			case 73: res = 1;
			break;
			default: res = 0;
			break;
		}
		return res;
	}
	public static String arbrom(int a, int orden){
		String res="";
		if(orden==1)
			switch(a){
				case 1:res="I";
				break;
				case 2:res="II";
				break;
				case 3:res="III";
				break;
				case 4:res="IV";
				break;
				case 5:res="V";
				break;
				case 6:res="VI";
				break;
				case 7:res="VII";
				break;
				case 8:res="VIII";
				break;
				case 9:res="IX";
				break;
			}
		if(orden==2)
			switch(a){
				case 1:res="X";
				break;
				case 2:res="XX";
				break;
				case 3:res="XXX";
				break;
				case 4:res="XL";
				break;
				case 5:res="L";
				break;
				case 6:res="LX";
				break;
				case 7:res="LXX";
				break;
				case 8:res="LXXX";
				break;
				case 9:res="XC";
				break;
			}
		if(orden==3)
			switch(a){
				case 1:res="C";
				break;
				case 2:res="CC";
				break;
				case 3:res="CCC";
				break;
				case 4:res="CD";
				break;
				case 5:res="D";
				break;
				case 6:res="DC";
				break;
				case 7:res="DCC";
				break;
				case 8:res="DCCC";
				break;
				case 9:res="CM";
				break;
			}
		if(orden==4)
			for(int i = 0;i<a;i++)
				res+="M";
		return res;
	}
}
