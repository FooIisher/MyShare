package fish;

import java.util.Scanner;

/**
 * 将一串字符的大写字母放放到字符串后面，且不改变其相对位置
 * 例如：OsadaSHjk
 * 结果：sadajkOSH
 * 要求尽可能不申请额外空间
 * @author fish
 *
 */
public class StringSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String in = sc.next();
			System.out.println("Sort: "+ stringSort(in));
		}
		sc.close();

	}

	private static String stringSort(String in) {
		char[] ins = in.toCharArray();
	
		int length =ins.length;
		while(length!=1){
			boolean hasChanged=false;
			for(int i=1;i<length;i++){
				if(!Character.isLowerCase(ins[i-1]) && Character.isLowerCase(ins[i])){
					char temp = ins[i-1];
					ins[i-1]=ins[i];
					ins[i]=temp;
					hasChanged = true;
				}
			}
			if(!hasChanged){
				break;
			}
			length--;
		}
		
		return new String(ins);
	}

}
