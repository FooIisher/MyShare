package fish;

import java.util.Scanner;

public class Transfor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true){
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();
			System.out.println(getAve(input));
		}
		
	}

	public static String getAve(int input) {
		// TODO Auto-generated method stub
		int sum=0;
		for(int i=2;i<input;i++){
			sum = sum + getAll(input, i);
		}
		return sum+"/"+(input-2);
	}

	public static int getAll(int num,int cal) {
		// TODO Auto-generated method stub
		int count=0;
		int yushu;
		while(num!=0){
			yushu = num%cal;
			//System.out.print(yushu);
			count = count + yushu;
			num=num/cal;
		}
		//System.out.println(" ");
		return count;
	}

}
