package fish;

import java.util.ArrayList;

/**
 * ����һ����������������һ������S���������в������������ǵ����ǵĺ�������S��
 * ����ж�����ֵĺ͵���S������������ĳ˻���С�ġ�
 * @author fish
 *
 */
public class FindNumbersWithSum {

	public static void main(String[] args) {
		int [] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};//[],21
		System.out.print(FindNumbersWithSum(array,21));

	}

	 public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
		 int i=0;
		 int j=array.length-1;
		 ArrayList<Integer> result = new ArrayList<Integer>();
		 while(i<=j){
			 if(array[i]+array[j]<sum){
				 i++;
			 }else if(array[i]+array[j]>sum){
				 j--;
			 }else {
				 if(result.isEmpty()){
					 result.add(array[i]);
					 result.add(array[j]);
					
				 }else{
					  if(result.indexOf(0)*result.indexOf(1)>array[i]*array[j]){
						  result.clear();
						  result.add(array[i]);
						  result.add(array[j]);
					  }
				 }
				 i++;
				 j--;
			 }
		 }
		 
		return result;
	        
	    }
}
