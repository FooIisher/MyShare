package dynamicProgramming;

import java.util.Scanner;

/**
 * 欢滑雪百这并不奇怪， 因为滑雪的确很刺激。
 * 可是为了获得速度，滑的区域必须向下倾斜，而且当你滑到坡底，你不得不再次走上坡或者等待升降机来载你。
 * Michael想知道载一个区域中最长底滑坡。区域由一个二维数组给出。数组的每个数字代表点的高度
 * @author fish
 *
 */
public class FindPath {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int weith = sc.nextInt();
		int length = sc.nextInt();
		int map[][] = new int[weith][length];
		for(int i=0;i<weith;i++){
			for(int j=0;j<length;j++){
				map[i][j]=sc.nextInt();
			}
		}
		System.out.println("FindMaxPathLength: "+ findMaxPathLength(map,weith,length));
	}

	/**
	 * 对地图中所有点分别进行求其最大路径 
	 * [i][j]点的最大值为其周边点最大值+1
	 * @param map
	 * @param weith
	 * @param length
	 * @return
	 */
	private static int findMaxPathLength(int[][] map, int weith,
			int length) {
		int records[][] = new int[weith][length];
		for(int i=0;i<weith;i++){
			for(int j=0;j<length;j++){
				records[i][j]=-1;
			}
		}
		int max =-1;
		for(int i=0;i<weith;i++){
			for(int j=0;j<length;j++){
				records[i][j]=getMaxPath(records,map,i,j);
				if(records[i][j]>max){
					max = records[i][j];
				}
			}
		}
		return max;
	}

	/**
	 * 找出当前点的最长路径值 (递归)
	 * @param map
	 * @param map2 
	 * @param i
	 * @param j
	 * @return
	 */
	private static int getMaxPath(int[][] records, int[][] map, int i, int j) {
		
		if(records[i][j]!=-1){
			return records[i][j];
		}
		int max=-1;
		//up
		if(i>0){
			if(map[i][j]>map[i-1][j]&&getMaxPath(records,map, i-1, j)>max){
				max = getMaxPath(records,map, i-1, j);
			}
		}
		
		//right
		if(j<map[0].length-1){
			if(map[i][j]>map[i][j+1]&&getMaxPath(records,map, i, j+1)>max){
				max = getMaxPath(records,map, i, j+1);
			}
		}
		
		//down
		if(i<map.length-1){
			if(map[i][j]>map[i+1][j]&&getMaxPath(map,records, i+1, j)>max){
				max = getMaxPath(map,records, i+1, j);
			}
		}
		
		//left
		if(j>0){
			if(map[i][j]>map[i][j-1]&&getMaxPath(map,records, i, j-1)>max){
				max = getMaxPath(map,records, i, j-1);
			}
		}
		
		//若max值未变  则说明无法继续寻找
		if(max==-1){
			max =1;
		}
		return max;
	}

}
