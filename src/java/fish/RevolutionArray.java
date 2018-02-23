package fish;

import java.util.ArrayList;

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
		System.out.println("-----------------------------");
		ArrayList<Integer> list = printMatrix(result);
		System.out.print(list);
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
	

	/**
	 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
	 * @param matrix
	 * @return
	 */
	private static ArrayList<Integer> printMatrix(int [][] matrix) {
	        ArrayList<Integer> result = new ArrayList<Integer>();
	      	int weith = matrix.length;
	        int length = matrix[0].length;
	        int x=0,y=0;
	        int i=1;
	       
	        result.add(matrix[0][0]);
	        matrix[0][0]=-1;
	        
	        while(i<weith*length){
	            while(y+1<length&&matrix[x][y+1]!=-1){
	            	++y;
	            	result.add(matrix[x][y]);
	                matrix[x][y]=-1;
	                i++;
	            }
	            
	             while(x+1<weith&&matrix[x+1][y]!=-1){
	            	 ++x;
	                result.add(matrix[x][y]);
	                matrix[x][y]=-1;
	                i++;
	            }
	            
	            while(y-1>=0&&matrix[x][y-1]!=-1){
	            	--y;
	                result.add(matrix[x][y]);
	                matrix[x][y]=-1;
	            	i++;
	            }
	            
	            while(x-1>=0&&matrix[x-1][y]!=-1){
	            	--x;
	                result.add(matrix[x][y]);
	                matrix[x][y]=-1;
	                i++;
	            }
	        }
	        return result;
	    }

	

}
