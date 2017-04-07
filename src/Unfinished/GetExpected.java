package Unfinished;

import java.util.Scanner;

public class GetExpected {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] datas = new int[n];
        for(int i=0;i<n;i++){
        	datas[i] = in.nextInt();
        }
        System.out.println(hander(datas));    
        in.close();
	}

	private static double hander(int[] datas) {
		int all = datas.length;
		double d = (double)(all*0.6);
		int t =(int) (all*0.6);
		int right = d-t>0?t+1:t ;
		double result =0;
		for(int i=0;i<=all-right;i++){
			if(i==0){
				double temp = 1;
				for(int data:datas){
					double p = (double)data/100;
					temp = temp *p;
				}
				result = result + temp;
			}
		}
		return result;
	}

}
