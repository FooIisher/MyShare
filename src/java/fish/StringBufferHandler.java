package fish;

import java.util.LinkedHashMap;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * @author fish
 *
 */
public class StringBufferHandler {
	LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
	public void Insert(char ch){
        if(map.containsKey(ch)){
        	map.put(ch, -1);
        }else{
        	map.put(ch, 1);
        }
    }

    public char FirstAppearingOnce(){
		for(Character ch:map.keySet()){
			if(map.get(ch)==1){
				return ch;
			}
		}
		return '#';
    
    }
}
