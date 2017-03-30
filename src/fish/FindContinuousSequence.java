package fish;

import java.util.ArrayList;
import java.util.TreeMap;

import fish.Test.A;
/**
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * @author fish
 *
 */
public class FindContinuousSequence {
	
	/** 
	 * 思路2：
	 * 初始化small=1，big=2;
	 * small到big序列和小于sum，big++;大于sum，small++;
	 * 当small增加到(1+sum)/2是停止
	 * @param sum
	 * @return
	 */
	 public ArrayList<ArrayList<Integer>> FindContinuousSequence2(int sum) {
		 
		 ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		 ArrayList<Integer> one = null;
		 if(sum<2){
			 return result;
		 }
		 int first =1;
		 int last =2;
		 while(first!=(sum+1)/2){
			 int temp =getSum(first,last);
			 if(temp==sum){
				 one = new ArrayList<Integer>();
				 for(int i=first;i<=last;i++){
					 one.add(i);
				 }
				 result.add(one);
				 first++;
				 last++;
			 }
			 if(temp<sum){
				 last++;
			 }
			 if(temp>sum){
				 first++;
			 }
			 
		 }
		 return result;
		 
	 }
	
	 /**
	  * 求和
	  * @param first
	  * @param last
	  * @return
	  */
	 private int getSum(int first, int last) {
		int sum = 0;
		for(int i=first;i<=last;i++){
			sum = sum+i;
		}
		return sum;
	}

	 /**
	  * 思路1：
	  * 利用连续求和的可分配性质来做 
	  * 但是无法保障顺序
	  * @param sum
	  * @return
	  */
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		 ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		 ArrayList<Integer> one = null;
		 
		 for(int i=1;i<sum;i++){
			 if(i==1){
				 int n = sum/i;
				 if(n%2==1){
					 one = new ArrayList<Integer>();
					 int start = n/2;
					 for(int j=0;j<2;j++){
						 one.add(start++);
					 }
					 result.add(one);
				 }
				 
			 }else{
				 if(i%2==1){
					 if(sum%i==0){
						 //当能被奇数整除时
						 int n = sum/i;
						
						 one = new ArrayList<Integer>();
						 int start = n-i/2;
						 if(start>0){
							 for(int j=0;j<i;j++){
								 one.add(start++);
							 }
							 result.add(one); 
						 }
						 
					 }
					 
				 }else{
					 if(sum%i==0&&i>1){
						 //当能够被偶数整除时
						 int n = sum/i;
						 if(n%2==1&&n>i){
							 one = new ArrayList<Integer>();
							 int start = (n+1)/2-i;
							 if(start>0){
								 for(int j=0;j<2*i;j++){
									 one.add(start++);
								 }
								 result.add(one);
							 }
						 }
					 }				 
				 }
			 }
		 }
		
		 TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();
		 for( ArrayList<Integer> temp:result){
			 map.put(temp.get(0), temp);
		 }
		 result.clear();
		 for(Object obj: map.values().toArray()){
			 ArrayList<Integer> in =  (ArrayList<Integer>) obj;
			 result.add(in);
		 }
		 return  result;


	 }

	public static void main(String[] args) {
		FindContinuousSequence fs = new FindContinuousSequence();
		System.out.print(fs.FindContinuousSequence2(100));

	}

}
