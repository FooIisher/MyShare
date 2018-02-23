package fish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/**
 * 有N个字符串，他想将这些字符串分类，他认为两个字符串A和B属于同一类需要满足以下条件：
 * A中交换任意位置的两个字符，最终可以得到B，交换的次数不限。比如：abc与bca就是同一类字符串。
 * 现在牛牛想知道这N个字符串可以分成几类。 
 * @author fish
 * 思路：逐个去分解，先判别和第一个字符串是否为一类，如果是就被过滤，不是则添加到other列表中记录
 *  	再去处理other列表中字符，看有几类，依次处理直到 other中不存在数据
 * 
 *  判断两个字符串是否为一类的算法，要注意 aab 和abb 这种包含重复字符串的情况
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
	 * 检查验连个字符串是否属于一类
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
