package dynamicProgramming;

import java.util.Scanner;

/**
 * ����ѩ���Ⲣ����֣� ��Ϊ��ѩ��ȷ�ܴ̼���
 * ����Ϊ�˻���ٶȣ������������������б�����ҵ��㻬���µף��㲻�ò��ٴ������»��ߵȴ������������㡣
 * Michael��֪����һ����������׻��¡�������һ����ά��������������ÿ�����ִ����ĸ߶�
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
	 * �Ե�ͼ�����е�ֱ�����������·�� 
	 * [i][j]������ֵΪ���ܱߵ����ֵ+1
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
	 * �ҳ���ǰ����·��ֵ (�ݹ�)
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
		
		//��maxֵδ��  ��˵���޷�����Ѱ��
		if(max==-1){
			max =1;
		}
		return max;
	}

}
