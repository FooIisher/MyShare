package fish;

import java.util.LinkedHashMap;

/**
 * ��ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ���
 * ���磬�����ַ�����ֻ����ǰ�����ַ�"go"ʱ����һ��ֻ����һ�ε��ַ���"g"��
 * ���Ӹ��ַ����ж���ǰ�����ַ���google"ʱ����һ��ֻ����һ�ε��ַ���"l"��
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
