package fish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/**
 * ��N���ַ��������뽫��Щ�ַ������࣬����Ϊ�����ַ���A��B����ͬһ����Ҫ��������������
 * A�н�������λ�õ������ַ������տ��Եõ�B�������Ĵ������ޡ����磺abc��bca����ͬһ���ַ�����
 * ����ţţ��֪����N���ַ������Էֳɼ��ࡣ 
 * @author fish
 * ˼·�����ȥ�ֽ⣬���б�͵�һ���ַ����Ƿ�Ϊһ�࣬����Ǿͱ����ˣ���������ӵ�other�б��м�¼
 *  	��ȥ����other�б����ַ������м��࣬���δ���ֱ�� other�в���������
 * 
 *  �ж������ַ����Ƿ�Ϊһ����㷨��Ҫע�� aab ��abb ���ְ����ظ��ַ��������
 * 
 */
public class DevideClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		ArrayList<String> ins = new ArrayList<String>();
		for(int i=0;i<num;i++){
			ins.add(sc.next());
		}
		System.out.print(hander(num,ins));
		sc.close();
	}

	private static int hander(int num, ArrayList<String> ins) {
		if(num==0){
			return 0;
		}
		
		if(num==1){
			return 1;
		}
		
		String first = ins.get(0);
		ArrayList<String> other = new ArrayList<String>();
		int result=1;
		for(int i=1;i<ins.size();i++){
			if(!check2(first,ins.get(i))){
				other.add(ins.get(i));
			}
		}
		if(other.size()!=0){
			result = result+ hander(other.size(), other);
		}

		return result;
	}

	/**
	 * ����������ַ����Ƿ�����һ��
	 * @param in
	 * @param check
	 * @return
	 */
	private static boolean check(String in, String check) {
		if(in.length()!=check.length()){
			return false;
		}
		
		char[] ins = in.toCharArray();
		char[] checks =check.toCharArray();
		int flag[] = new int[checks.length];
		for(char inchar:ins){
			boolean find = false;
			for(int i=0;i<check.length();i++){
				if(inchar==checks[i]&&flag[i]==0&&!find){
					flag[i]=1;
					find = true;
				}
			}
		}
		
		for(int out:flag){
			if(out==0){
				return false;
			}
		}
		return true;
	}

	private static boolean check2(String in, String check) {
		if(in.length()!= check.length()){
			return false;
		}
		
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		char[] ins = in.toCharArray();
		for(char inchar:ins){
			if(map.containsKey(inchar)){
				int count = map.get(inchar);
				map.put(inchar, count+1);
			}else{
				map.put(inchar, 1);
			}
		}
		
		char[] checks =check.toCharArray();
		for(char checkChar:checks){
			if(map.containsKey(checkChar)){
				int count=map.get(checkChar);
				map.put(checkChar, count-1);
			}else{
				return false;
			}
		}
		
		for(Integer count:map.values()){
			if(count!=0){
				return false;
			}
		}
		return true;
	}
	
}
