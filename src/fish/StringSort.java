package fish;

import java.util.Scanner;

/**
 * ��һ���ַ��Ĵ�д��ĸ�ŷŵ��ַ������棬�Ҳ��ı������λ��
 * ���磺OsadaSHjk
 * �����sadajkOSH
 * Ҫ�󾡿��ܲ��������ռ�
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
