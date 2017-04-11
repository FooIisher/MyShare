package fish;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;
/**
 * ����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С�
 * ���������ַ���abc,���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,bca,cab��cba��
 * @author fish
 *
 */
public class CombinationOfString {
	
	 public static ArrayList<String> Permutation(String str) {
		 TreeSet<String> res = new TreeSet<String>();
		 ArrayList<String> result = new ArrayList<String>();
		 if(str!=null&&str.length()!=0){
			 handler(str.toCharArray(),0,res);
		 }
		 result.addAll(res);
		 return result;
	       
	  }

	private static void handler(char[] charArray, int start, TreeSet<String> res) {
		if(start==charArray.length-1){
			res.add(String.valueOf(charArray));
		}else{
			for(int i=start;i<=charArray.length-1;i++){
				if(i==start||charArray[i]!=charArray[start]){//ȥ���ظ���ĸλ�ý���
					swap(charArray,start,i);
					handler(charArray, start+1, res);
					swap(charArray,start,i);
				}
			}
		}
		
	}

	private static void swap(char[] charArray, int start, int i) {
		char temp = charArray[i];
		charArray[i] = charArray[start];
		charArray[start] = temp;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			System.out.println(Permutation(sc.next()));
		}
		sc.close();
	}

}
