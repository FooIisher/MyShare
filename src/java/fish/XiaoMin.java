package fish;

import java.util.Scanner;

public class XiaoMin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			int m = sc.nextInt();
			System.out.println(handler(n,m));
		}
		
		sc.close();
	}

	private static int handler(int n, int m) {
		if(m>=240){
			return 0;
		}
		int left = 240-m;
		for(int i=1;i<=n;i++){
			int use = 5 * i*(i+1)/2;
			if(use>left){
				return i-1;
			}
		}
		return n;
		
	}

}
