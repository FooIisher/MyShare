package dynamicProgramming;

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
 *	思路：利用数组 record[i][j] 来标记s.sub(i,j)是否存在字典中中，根据记录值进行递归（时间复杂度过高！leetcode不通过）
 */
public class MatchDict {

	 public static ArrayList<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String> result = new  ArrayList<String>();
		int[][] records = new int[s.length()][s.length()+1];
		for(int i=0;i<s.length();i++){
			for(int j=i+1;j<s.length()+1;j++){
				if(j==s.length()){
					if(dict.contains(s.substring(i))){
						records[i][j]=1;
					}
				}else{
					if(dict.contains(s.substring(i, j))){
						records[i][j]=1;
					}
				}
			}
		
		}
		StringBuilder sb = new StringBuilder();
		find(result,0,sb,records,s);
		
		return result;
	 }
	

	private static void find(ArrayList<String> result, int row, StringBuilder sb, int[][] records, String s) {
		for(int i=0;i<=s.length();i++){
			if(records[row][i]==1){
				if(row==0){
					sb = new StringBuilder();	
				}
				
				if(i==s.length()){
					sb.append(s.substring(row)+" ");
					result.add(sb.toString().trim());
				}else{
					sb.append(s.substring(row,i)+" ");
					find(result, i, sb, records, s);
				}
					
			}
		}
		
		
	}


	public static void main(String[] args) {
		String s ="a";
		Set<String> dict = new HashSet<String>();
		String[] ins = {"a"};
		for(String in:ins){
			dict.add(in);
		}
		
		System.out.println(wordBreak(s, dict));
	}

}
