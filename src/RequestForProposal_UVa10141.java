package Capitulo1;
import java.util.Scanner;
import java.util.ArrayList;
public class RequestForProposal_UVa10141 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int req = scan.nextInt();
		int prop = scan.nextInt();
		int cont = 1;
		while(req!=0&&prop!=0){
			scan.nextLine();
			for(int i = 0;i<req;i++)
				scan.nextLine();
			String[] ccomp = new String[prop];
			double[] price = new double[prop];
			int[] rm = new int[prop];
			for(int i = 0;i<prop;i++){
				ccomp[i]=scan.nextLine();
				price[i] = scan.nextDouble();
				rm[i] = scan.nextInt();
				scan.nextLine();
				for(int j = 0;j<rm[i];j++)
					scan.nextLine();
			}
			ArrayList<Integer> RFP = new ArrayList();
			ArrayList<Integer> mRFP = new ArrayList();
			double max = rm[0];
			for(int a : rm)
				if(a>max)
					max = a;
			for(int i = 0;i<price.length;i++)
				if(rm[i]==max)
					RFP.add(i);
			double min=price[RFP.get(0)];
			for(int i = 0;i<RFP.size();i++)
				if(price[RFP.get(i)]<min)
					min=price[RFP.get(i)];
			for(int i = 0;i<RFP.size();i++)
				if(price[RFP.get(i)]==min)
					mRFP.add(RFP.get(i));
			System.out.println("RFP #"+cont);
			System.out.println(ccomp[mRFP.get(0)]);
			cont++;
			req = scan.nextInt();
			prop = scan.nextInt();
			if(req!=0&&prop!=0)
				System.out.println();
		}
	}
}
