package fish;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 * Given n points on a 2D plane, 
 * find the maximum number of points that lie on the same straight line.
 * @author fish
 *	思路：循环两次，分别求出两个点之间的斜率，利用斜率相同来统计在一条线上的点位
 *		注意垂直的于x轴的点位，斜率不存在的情况
 */
public class MaxPointsOnLine {
	public class Point {
		 int x;
		 int y;
		 Point() { x = 0; y = 0; }
		 Point(int a, int b) { x = a; y = b; }
	 }
	 
	 public static int maxPoints(Point[] points) {
		 if(points==null||points.length==0){
			 return 0;
		 }
		 
		 if(points.length<2){
			return points.length-1;
		 }
		 int result =0;
		 for(int i=0;i<points.length;i++){
			 int dup = 0;//用于统计重复的点数量；
			 int vel = 1;//用于统计与当前点垂直于x轴的线上的点位数量
			 HashMap<Double, Integer> map = new HashMap<Double, Integer>();
			 for(int j=0;j<points.length;j++){
				 if(i==j){
					 continue;
				 }
				 
				 int x = points[j].x - points[i].x;
				 int y = points[j].y - points[i].y;
				
				 if(x==0&&y==0){//判断点位重合点的数统计
					 dup++;
				 }else if(x==0&&y!=0){//统计与当前点垂直于x轴的线上的点位数量
					 vel++;
				 }else{
					 double k = (double)y/ (double)x; //注意精度不要丢失
					 if(map.containsKey(k)){
						 map.put(k, map.get(k)+1);
					 }else{
						 map.put(k, 2);
					 }
				 }
			 }
			 int max = vel;
			 for(double k:map.keySet()){
				 max = Math.max(max, map.get(k));
			 }
			 result = max+dup > result? max+dup : result; 
		 }
		 return result;
	 }
	 
	 public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int n = sc.nextInt();
		 MaxPointsOnLine mp = new MaxPointsOnLine();
		 Point[] ps = new Point[n];
		 for(int i=0;i<n;i++){
			 ps[i] = mp.new Point(sc.nextInt(),sc.nextInt());
		 }
		  maxPoints(ps);
		 sc.close();
	 }
}
