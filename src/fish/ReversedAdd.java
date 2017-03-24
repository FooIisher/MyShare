package fish;
import java.util.Scanner;

/**
 * 两个数翻转后求和
 * @author fish
 *
 */
public class ReversedAdd {

	public static void main(String[] args) {
		 Scanner sc  = new Scanner(System.in);
		 while(sc.hasNext()){
			 String in[] = sc.nextLine().split(",");
		     int num1 = Integer.valueOf(in[0]);
		     int num2=  Integer.valueOf(in[1]);
		     System.out.println(handler(num1,num2));
		 }
		 sc.close();
		

	}

	private static int handler(int num1, int num2) {
		if(num1<1||num1>70000||num2<1||num2>70000){
			return -1;
		}
		return reversed(num1)+reversed(num2);
	}

	private static int reversed(int num) {
		 int result=0;//存反转的数字  
	     while(true)  
	     {  
	         int n=num%10;
	         result=result*10+n;
	         num=num/10;//降位  
	         if(num==0)  
	         {  
	             break;  
	         }  
	     }  
	     return result;
	}

}
