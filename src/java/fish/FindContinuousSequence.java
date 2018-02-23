package fish;

import java.util.ArrayList;
import java.util.TreeMap;

import fish.Test.A;
/**
 * ������к�ΪS�������������С������ڰ��մ�С�����˳�����м䰴�տ�ʼ���ִ�С�����˳��
 * @author fish
 *
 */
public class FindContinuousSequence {
	
	/** 
	 * ˼·2��
	 * ��ʼ��small=1��big=2;
	 * small��big���к�С��sum��big++;����sum��small++;
	 * ��small���ӵ�(1+sum)/2��ֹͣ
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
	  * ���
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
	  * ˼·1��
	  * ����������͵Ŀɷ����������� 
	  * �����޷�����˳��
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
						 //���ܱ���������ʱ
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
						 //���ܹ���ż������ʱ
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
