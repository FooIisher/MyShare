package fish;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/***
 * 在一个字符串(1<=字符串长度<=10000，全部由大写字母组成)中找到第一个只出现一次的字符,并返回它的位置
 * @author fish
 *
 */
public class FirstNotRepeatingChar {

	public static void main(String[] args) {
		String in ="ASADSDSSSSSSSSSDDDDDFDDASDSADASD"; 
		System.out.println(solution(in));
	}

	private static int solution(String input) {
		char[] ins = input.toCharArray();
		
		LinkedHashMap<Character,Integer> map = new LinkedHashMap<Character,Integer>();
		for(int i=0;i<ins.length;i++){
			if(map.containsKey(ins[i])){
				if(map.get(ins[i])!=-1){
					map.put(ins[i], -1);
				}
			}else{
				map.put(ins[i], i);
			}
		}
		
		for(Object  result:map.values().toArray()){
			if((int) result!=-1){
				return (int) result;
			}
		}
		return -1;
	}

}
