package fish;

import java.util.LinkedHashMap;
/**
 *  �����г����������ֵĴ���Ϊ1��������Ϊ���Σ��ҳ���������
 * @author fish
 *
 */
public class FindNumsAppearOnce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<Integer,Integer>();
        for(int in:array){
            if(map.containsKey(in)){
                map.remove(in);
            }else{
            	map.put(in, in);
            }
        }
        Object[] result = map.keySet().toArray();
        num1[0]=(int) result[0];
        num2[0]=(int) result[1];
	}

}
