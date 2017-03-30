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
		System.out.print(fs.FindContinuousSequence(100));

	}

}
