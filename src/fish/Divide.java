package fish;

import java.util.Scanner;

public class Divide {

	 public static void main(String[] args){
	        Scanner sc  = new Scanner(System.in);
	        int start = sc.nextInt();
	        int end = sc.nextInt();
	        int num = sc.nextInt();
	        System.out.println(handler(start,end,num));
	        sc.close();
	    }
	    
	    public static int handler(int start,int end , int num){
	    	if(start>0){
	    		start = start+(num-start%num);
	    	}else {
	    		start = start-start%num;
	    	}
	    	if(end>0){
	    		end = end-end%num;
	    	}else {
	    		end = end+end%num;
	    	}
	        return (end-start)/num+1;
	    }
}
