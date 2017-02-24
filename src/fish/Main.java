package fish;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double in;
		int out;
		while(sc.hasNext()){
			in = sc.nextDouble();
			int temp= (int) in;
			if(in-temp>=0.5){
				out = (int) Math.round(in);
			}else{
				out =(int) Math.floor(in);
			}
			System.out.println(out);
		}

	}

	private static void getPrimereNumber(int in) {
		if(checkPrimereNumber(in)){
			System.out.print(in+" ");
		}else{
			for(int i=2;i<in;i++){
				if(in% i==0){
					System.out.print(i+" ");
					in = in /i;
					break;
				}
			}
			getPrimereNumber(in);
		}
		
		
	}

	private static boolean checkPrimereNumber(int in) {
		Boolean result = true;
		if(in>3){
			for(int i=2;i<in;i++){
				if(in%i==0){
					result=false;
				}
			}
		}
		return result;
	}

	

}
