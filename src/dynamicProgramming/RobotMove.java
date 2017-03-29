package dynamicProgramming;



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
	/**
	 * ��̬�滮 dp[i][j]��ʾ�Ƿ���Ե��ͳ��������true�ĸ�������Ϊ���Ե���ĸ�����
	 * @param threshold
	 * @param rows
	 * @param cols
	 * @return
	 */
	public static int movingCount2(int threshold, int rows, int cols) {
		if(threshold<0){
			return 0;
		}
		boolean dp[][] = new boolean[rows][cols];
		dp[0][0] = true;
		for(int i=1;i<rows;i++){
			if(dp[i-1][0]&&numCount(i)+numCount(0)<=threshold){
				dp[i][0]=true;
			}else{
				dp[i][0]=false;
			}
		}
		
		for(int i=1;i<cols;i++){
			if(dp[0][i-1]&&numCount(0)+numCount(i)<=threshold){
				dp[0][i]=true;
			}else{
				dp[0][i]=false;
			}
		}
		
		for(int i=1;i<rows;i++){
			for(int j=1;j<cols;j++){
				if((dp[i-1][j]&&numCount(i)+numCount(j)<=threshold)||
						(dp[i][j-1]&&numCount(i)+numCount(j)<=threshold)){
					dp[i][j]=true;
				}else{
					dp[i][j]=false;
				}
			}
		}
		int result=0;
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				if(dp[i][j]){
					result++;
				}
			}
		}
		return result;
	}


	
	
	public static int movingCount(int threshold, int rows, int cols) {
		int[][] flag = new int[rows][cols];
		return handler(0,0,rows,cols,flag,threshold);
	}

	private static int handler(int i, int j, int rows, int cols, int[][] flag,
			int threshold) {
		if(i<0||i>=rows||j<0||j>=cols||numCount(i)+numCount(j)>threshold||flag[i][j]==1){
			return 0;
		}
		flag[i][j] =1;
		return handler(i-1, j, rows, cols, flag, threshold)+
				handler(i+1, j, rows, cols, flag, threshold)+
				 handler(i, j+1, rows, cols, flag, threshold)+
				  handler(i, j-1, rows, cols, flag, threshold)+1;
	}

	private static int numCount(int i) {
		int sum = 0;
		while(i!=0){
			sum = sum + i%10;
			i = i/10;
		}
		
		return sum;
	}
	
	public static void main(String[] args){
		System.out.print("result :"+ movingCount2(15, 20, 20));
	}
}
