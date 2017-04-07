package fish;

import java.util.Scanner;

public class Or {
	
	public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt() ;
        int first = Integer.valueOf(in.next(),2);
        int second = Integer.valueOf(in.next(),2);
        System.out.println(first^second);    
        in.close();
    }
}
