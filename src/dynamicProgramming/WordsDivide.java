package dynamicProgramming;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 * For example, given
 * s ="catsanddog",
 * dict =["cat", "cats", "and", "sand", "dog"].
 * A solution is["cats and dog", "cat sand dog"].
 * 
 * @author fish
 *
 */

public class WordsDivide {

	public static void main(String[] args) {
		String s="";
		String[] dicts = {"cat", "cats", "and", "sand", "dog"};
		System.out.println(handler(s,dicts));
	}

	public static ArrayList<String> handler(String s, String[] dicts) {
		HashMap<String, List> map = new HashMap<String, List>();
		Set<String> dict = new HashSet<String>();
		for(String str:dicts){
			dict.add(str);
		}
		return dfs(s, dict, map);
	}



	private static ArrayList<String> dfs(String s,  Set<String> dict, HashMap<String, List> map) {
		
		ArrayList<String> lists = new ArrayList<String>();
		
		for(int i=1;i<s.length();i++){
			String subStr = s.substring(i,s.length());
			if(dict.contains(subStr)){

				
			}else{
				
			}
		}

		return lists;
	}

}
