package fish;
import java.util.ArrayList;
import java.util.Scanner;


public class FindWay {
	


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		for(int i=0;i<n;i++){
			x[i]=sc.nextInt();
		}
		for(int i=0;i<n;i++){
			y[i]=sc.nextInt();
		}
		int gx = sc.nextInt();
		int gy = sc.nextInt();
		int walkTime = sc.nextInt();
		int talkTime = sc.nextInt();
		System.out.println(handler(n,x,y,gx,gy,walkTime,talkTime));
		sc.close();

	}

	private static int handler(int n, int[] x, int[] y, int gx, int gy,
			int walkTime, int talkTime) {
		ArrayList<Integer> ways = new  ArrayList<Integer>();
		int distance = getDistance(0,gx)+getDistance(0, gy);
		ways.add(distance*walkTime);
		for(int i=0;i<n;i++){
			int walk = getDistance(0,x[i])+getDistance(0, y[i]);
			int talk = getDistance(x[i],gx)+getDistance(y[i],gy);
			ways.add(walk*walkTime+ talk*talkTime);
		}
		int result=ways.get(0);
		for(int i:ways){
			if(result>i){
				result=i;
			}
		}
		return result;
	}

	private static int getDistance(int i, int gx) {
		int sum =0;
		if(i>=0&&gx>=0){
			sum =  gx -i>0? gx-i:i-gx;
		} else if(i<0&& gx<0){
			sum =  gx -i>0? gx-i:i-gx;
		}else{
			if(gx<0){
				sum = i-gx; 
			}else{
				sum = gx-i; 
			}
			
		}
		return sum;
	}

}
