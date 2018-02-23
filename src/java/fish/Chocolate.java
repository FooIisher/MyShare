package fish;

import java.util.Scanner;

/**
 * 3940649673949178
 * 50
 * @author fish
 *
 */
public class Chocolate {

	public static void main(String[] args){
  		Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
              long num = sc.nextLong();
             System.out.println(handler(num));
 		}
        sc.close();
   }
        

  public static long handler(long n){
  	
        if(n==1){
           return 1;
        }
        long result =(long) (Math.pow(2,n-1)+ 6*Math.pow(2,n-1) - 6);
        return result;
  }

}
