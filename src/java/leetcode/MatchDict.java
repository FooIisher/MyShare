package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, 
 * add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 * For example, given
 * s ="catsanddog",
 * dict =["cat", "cats", "and", "sand", "dog"].
 * A solution is["cats and dog", "cat sand dog"].
 * @author fish
 *	思路：利用数组 record[i][j] 来标记s.sub(i,j)是否存在字典中中，根据记录值进行递归（空间复杂度过高！leetcode不通过）
 */
public class MatchDict {

	
	/**
	 * 利用矩阵来解决 超时遍历
	 * 
	 * @param s
	 * @param dict
	 * @return
	 */
	public static ArrayList<String> wordBreak2(String s, Set<String> dict) {
		ArrayList<String> result = new  ArrayList<String>();
		ArrayList<String> one = new ArrayList<String>();
		int[][] records = new int[s.length()][s.length()+1];
		for(int i=0;i<s.length();i++){
			for(int j=i+1;j<=s.length();j++){
				if(dict.contains(s.substring(i, j))){
					records[i][j] = 1;
				}
			}
		}
		find2(result,one,0,records,s);
		return result;
	}
	
	
	

	 private static void find2(ArrayList<String> list, ArrayList<String> one,
			int start, int[][] records, String s) {
		 if(start==s.length()){
				StringBuilder sb = new StringBuilder();
				for(String word:one){
					sb.append(word+" ");
				}
				list.add(sb.toString().trim());
			}else{
				for(int i=start;i<=s.length();i++){
					if(records[start][i]==1){
						one.add(s.substring(start, i));
						find2(list, one, i, records, s);
						one.remove(one.size()-1);
					}
				}
			}
		
	}




	public static ArrayList<String> wordBreak(String s, Set<String> dict) {
			ArrayList<String> list = new  ArrayList<String>();
			ArrayList<String> one = new ArrayList<String>(); 
			find(0,one,list,s,dict);
			return list;
		 }
		
	

	private static void find(int start, ArrayList<String> one,
			ArrayList<String> list, String s, Set<String> dict) {
		if(start==s.length()){
			StringBuilder sb = new StringBuilder();
			for(String word:one){
				sb.append(word+" ");
			}
			list.add(sb.toString().trim());
		}else{
			for(int i=start;i<=s.length();i++){
				if(dict.contains(s.substring(start, i))){
					one.add(s.substring(start, i));
					find(i, one, list, s, dict);
					one.remove(one.size()-1);
				}
			}
		}
		
	}


	public static void main(String[] args) {
		String s ="catsanddog";
		Set<String> dict = new HashSet<String>();
		String[] ins = {"cat", "cats", "and", "sand","dog"};
		for(String in:ins){
			dict.add(in);
		}
		
		System.out.println(wordBreak2(s, dict));
//		System.out.println(wordBreak(s, dict));
	
	}




}
