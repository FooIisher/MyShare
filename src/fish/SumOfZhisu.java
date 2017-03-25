package fish;
import java.util.Scanner;
public class SumOfZhisu{
  public static void main(String[] args){
  	Scanner sc = new Scanner(System.in);
    while(sc.hasNext()){
    	int in = sc.nextInt();
      System.out.println(handler(in));
    }
  }
  
  public static int handler(int num){
  	 int result =0;
    int i=1,j=num;
    while(i<=j){
    	while(!check(i)&&i<j){
    		i++;
    	}
    	while(!check(j)&&j>i){
    		j--;
    	}
    	
    	if(i+j>num){
    		j--;
    	}else if(i+j==num){
    		result++;
    		i++;
    		j--;
    		
    	}else{
    		i++;
    	}
    	
    }
    return result;
  }
  
  public static boolean check(int num){
    if(num<3){
    	return true;
    }else{
      for(int i=2;i<=num/2;i++){
        if(num%i==0){
        	return false;
        }
      }
      return true;
    }
  }
}