package dynamicProgramming;



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
	/**
	 * 动态规划 dp[i][j]表示是否可以到达，统计数字中true的个数，即为可以到达的格子数
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
