package fish;
/**
 * 顺时针打印一个数组
 * @author fish
 *
 */
public class RevolutionArray {

	public static void main(String[] args) {
		int  num = 4;
		int[][] result = getLostNum(num);
		for(int i=0;i<num;i++){
			for(int j=0;j<num;j++){
				System.out.print(result[i][j]+" ");
			}
			System.out.println("");
		}
	}

	private static int[][] getLostNum(int num) {
		int x=0,y=0,i=1;
		int[][] result = new int[num][num];
		result[0][0] =1;
		while(i<num*num){
			
			while(y+1<num && result[x][y+1]==0){
				result[x][++y] = ++i;
			}
			while(x+1<num && result[x+1][y]==0){
				result[++x][y] = ++i;
			}
			while(y-1>=0 && result[x][y-1]==0){
				result[x][--y] = ++i;
			}
			while(x-1>=0 && result[x-1][y]==0){
				result[--x][y] = ++i;
			}
			
		}
		return result;
	}

	

}
