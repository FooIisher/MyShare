package unfinished;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

/**
 * һ���ַ���S��ż�����ҽ���S�е�ÿһ���ַ���������ż���Ρ����ַ�����aabccb����һ��ż������Ϊ�ַ�a,b,c�����������Ρ����ַ�����abbcc������ż������Ϊ�ַ�a������һ�Ρ�
 * ���ڸ���һ������Ϊn���ַ���T=t1,t2,t3,��,tn���ַ������Ӵ�Ϊ������������һ�Ρ�T����Ϊ1���Ӵ���n��������Ϊ2���Ӵ���n-1�����Դ����ƣ�Tһ����n(n+1)/2���Ӵ�������T������������ж��ٸ��Ӵ���ż����
 * @author fish
 * 
 * ����ʱ�临�Ӷ�Ϊn�����η���δ��� �����Ż�
 *
 */
public class DoubleSubString {

	public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	while(sc.hasNext()){
             System.out.println(handler1(sc.next()));
        }
    	sc.close();
    }
      
	
    private static int handler1(String in ) {
    	int count = 0;//��¼�ܵ�ż����Ŀ
		int gi = 0; //gi���õ�26bit��int��32bit����ʾ�±�Ϊ[0,i]���Ӵ���ӵ�ֱ��е���ĸ��ż������0��������������1����
		Map<Integer,Integer> map = new HashMap<Integer,Integer>(); //����ÿ��gi���ִ���
        map.put(0, 1);//giΪ0����ʾ���е���ĸ������ż���Σ���1��ż�������Ը���ֵ1
		for(int i=0; i< in.length(); i++){
			int x =  in.charAt(i) - 'a'; //����¼��������ַ���bitλ��
			gi ^= (1 << x);  //���������ַ���ԭ����giӵ����ĸ��������ż�ԡ����������0����ʾ������ַ�����ż������ĸ����������������
			if(map.containsKey(gi)){
				count += map.get(gi);//g0,g1,g2...g(i-1)��gi��ȵģ������Եõ�һ��ż�����ж���ٸ���ȣ����ж��ٸ�ż���� 
				map.put(gi, map.get(gi)+1); //����1
			}else{
				map.put(gi, 1); 
			}
		}
		return count;
		    
	}

	public static int handler(String str){
    	if(str.length()==0||str.length()==1){
        	return 0;
        }
        int result=0;
        for(int i=0;i<str.length();i++){
        	for(int j=i+1;j<str.length();j++){
            	String temp = str.substring(i,j+1);
                 if(check(temp)){
                       result++;
                 }
            }
        }
        return result;  
    }
      
    public static boolean check(String str){
    	if(str.length()==0||str.length()%2==1){
        	return false;
        }
        HashSet<Character> set =new HashSet<Character>();
        char[] ins = str.toCharArray();
        for(char in:ins){
        	if(set.contains(in)){
                set.remove(in);
            }else{
            	set.add(in);
            }
        }
         if(set.size()==0){
             return true;
          }else{
             return false;   
          }        
    }

}
