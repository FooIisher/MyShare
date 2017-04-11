package fish;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;
/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
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
				if(i==start||charArray[i]!=charArray[start]){//去掉重复字母位置交换
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
