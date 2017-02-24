package fish;

import java.util.Scanner;

/*
 * 
 * 以上三角形的数阵，第一行只有一个数1，以下每行的每个数，是恰好是它上面的数，左上角数到右上角的数，3个数之和（如果不存在某个数，认为该数就是0）。
 * 求第n行第一个偶数出现的位置。如果没有偶数，则输出-1。例如输入3,则输出2，输入4则输出3。
 * 
 * 
 */

public class TriangleCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		//System.out.println(find(input));
		for(int i=1;i<=input;i++){
			for(int j=1;j<=2*input-1;j++){
				System.out.print(getTriangle(i,j)+" ");
			}
			System.out.println(" ");
		}

	}
	
	public static int getTriangle(int line,int num){
		if(num<1||num>2*line-1)
			return 0;
		else if(num==1||num==2*line-1)
			return 1;
		else 
			return getTriangle(line-1,num-1-1) + getTriangle(line-1,num-1) + getTriangle(line-1,num+1-1);
	}
	
	public static int find(int line){
			for(int i=1;i<=2*line-1;i++){
////			//System.out.print(getTriangle(line,i)+" ");
				if(getTriangle(line,i)%2==0)
					return i;
			}
			return -1;
			
	}

}
