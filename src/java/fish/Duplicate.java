package fish;

import java.util.LinkedHashMap;

public class Duplicate {

	
	// Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    
	public static boolean duplicate(int numbers[],int length,int [] duplication) {
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		if(length<2){
			return false;
		}
		
		for(int number:numbers){
			if(map.containsKey(number)){
				if(map.get(number)==1){
					map.put(number, -1);
				}
			}else{
				map.put(number, 1);
			}
		}
		
		LinkedHashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
		
		for(Integer number:map.keySet()){
			if(map.get(number)==-1){
//				map.remove(number); //	 遍历过程中删除map中元素会抛出异常at java.util.LinkedHashMap$LinkedHashIterator.nextEntry(Unknown Source)
				temp.put(number, number);
			}
		}
		
		
		
		if(temp.size()==0){
			return false;
		}else{
			duplication = new int[temp.size()];
			int i=0;
			for(Integer number: temp.keySet()){
				duplication[i++]= number;
			}
			
			return true;
		}
    }
	
	public static void main(String[] args) {
		int[] numbers = {2,1,3,1,4};
		int[] duplication = numbers;
		System.out.print(duplicate(numbers,numbers.length,duplication ));
		for(int out: duplication){
			System.out.print(" "+out);
		}
		
	}
	
}
