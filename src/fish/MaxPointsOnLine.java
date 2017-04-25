package fish;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 * Given n points on a 2D plane, 
 * find the maximum number of points that lie on the same straight line.
 * @author fish
 *	˼·��ѭ�����Σ��ֱ����������֮���б�ʣ�����б����ͬ��ͳ����һ�����ϵĵ�λ
 *		ע�ⴹֱ����x��ĵ�λ��б�ʲ����ڵ����
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
			 int dup = 0;//����ͳ���ظ��ĵ�������
			 int vel = 1;//����ͳ���뵱ǰ�㴹ֱ��x������ϵĵ�λ����
			 HashMap<Double, Integer> map = new HashMap<Double, Integer>();
			 for(int j=0;j<points.length;j++){
				 if(i==j){
					 continue;
				 }
				 
				 int x = points[j].x - points[i].x;
				 int y = points[j].y - points[i].y;
				
				 if(x==0&&y==0){//�жϵ�λ�غϵ����ͳ��
					 dup++;
				 }else if(x==0&&y!=0){//ͳ���뵱ǰ�㴹ֱ��x������ϵĵ�λ����
					 vel++;
				 }else{
					 double k = (double)y/ (double)x; //ע�⾫�Ȳ�Ҫ��ʧ
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
