package fish;

import java.util.Scanner;

public class Divide {

	 public static void main(String[] args){
	        Scanner sc  = new Scanner(System.in);
	        int start = sc.nextInt();
	        int end = sc.nextInt();
	        int num = sc.nextInt();
	        System.out.println(handler(start,end,num));
	  
	    }
	    
	    public static int handler(int start,int end , int num){
	       
	         int last = end%num==0?end/num+1:end/num;  
	      
	         int before = start==0?-1: start/num==0?start/num:start/num+1;   
	        return last-before;
	       
	    }


}
