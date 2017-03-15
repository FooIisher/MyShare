package fish;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/***
 * ��һ���ַ���(1<=�ַ�������<=10000��ȫ���ɴ�д��ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,����������λ��
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
