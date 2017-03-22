package dynamicProgramming;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

/**
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * @author fish
 *
 */
public class RobotMove {


	public static int movingCount(int threshold, int rows, int cols) {
		int[][] flag = new int[rows][cols];
		return handler(0,0,rows,cols,flag,threshold);
	}

	private static int handler(int i, int j, int rows, int cols, int[][] flag,
			int threshold) {
		if(i<0||i>=rows||j<0||j>cols||numCount(i,j)>threshold||flag[i][j]==1){
			return 0;
		}
		flag[i][j] =1;
		return handler(i-1, j, rows, cols, flag, threshold)+
				handler(i+1, j, rows, cols, flag, threshold)+
				 handler(i, j+1, rows, cols, flag, threshold)+
				  handler(i, j-1, rows, cols, flag, threshold)+1;
	}

	private static int numCount(int i, int j) {
		int sum = 0;
		while(i!=0){
			sum = + i%10;
			i = i/10;
		}
		
		while(j!=0){
			sum = + j%10;
			i = j/10;
		}

		return sum;
	}
	
	public static void main(String[] args){
		System.out.print("result :"+ movingCount(5, 10, 10));
	}
}
