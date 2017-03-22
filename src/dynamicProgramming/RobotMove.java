package dynamicProgramming;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

/**
 * ������һ��m�к�n�еķ���
 * һ�������˴�����0,0�ĸ��ӿ�ʼ�ƶ���ÿһ��ֻ�������ң��ϣ����ĸ������ƶ�һ��
 * ���ǲ��ܽ�������������������λ֮�ʹ���k�ĸ��ӡ�
 * ���磬��kΪ18ʱ���������ܹ����뷽��35,37������Ϊ3+5+3+7 = 18��
 * ���ǣ������ܽ��뷽��35,38������Ϊ3+5+3+8 = 19�����ʸû������ܹ��ﵽ���ٸ����ӣ�
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
