package leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * For example, given
 * s ="leetcode",
 * dict =["leet", "code"].
 * Return true because"leetcode"can be segmented as"leet code".
 * @author fish
 *
 */

public class MatchDict2 {

	public static boolean wordBreak(String s, Set<String> dict) {
	      if(s==null||dict==null){
	    	  return false;
	      }
	      return find(s,0,dict);
	}
	
	private static boolean find(String s, int start, Set<String> dict) {
		for(int i=start+1;i<=s.length();i++){
			if(dict.contains(s.substring(start, i))){
				if(i==s.length()){
					return true;
				}else{
					find(s, i, dict);
				}
			}
		}
		return false;
	}
	

	public boolean wordBreak2(String s, Set<String> dict){
		int len = s.length();
		boolean[] arrays = new boolean[len+1];
		arrays[0] = true;
		for (int i = 1; i <= len; ++i){
			for (int j = 0; j < i; ++j){
				if (arrays[j] && dict.contains(s.substring(j, i))){
					arrays[i] = true;
					break;
				}
			}
		}
		return arrays[len];
	}

	public static void main(String[] args) {
		String s ="leetcode";
		Set<String> dict = new HashSet<String>();
		String[] ins = {"leet", "code"};
		for(String in:ins){
			dict.add(in);
		}
		
		System.out.println(wordBreak(s, dict));
	}

}
