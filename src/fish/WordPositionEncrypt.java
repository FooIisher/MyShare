package fish;

import java.util.Scanner;

/*
 * 
 * 
 */

public class WordPositionEncrypt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.print( encryptWords(input));
	}

	public static String encryptWords(String phrase){
	    // INSERT YOUR CODE HERE
	    String temp[] = phrase.split(" ");
	    StringBuffer out = new StringBuffer();
	    
	    for(int i=0;i<temp.length;i++){
	        for(int j=0;j<temp[i].length();j++){
	            int len= temp[i].length()-j-1;
	            char word = temp[i].charAt(j);
	            //System.out.print(changeChar(word,len));
	            out.append(changeChar(word,len));
	        }
	        //System.out.print(" ");
	        out.append(" ");
	    }
	    
	    return out.toString();
	  }
	
	public static char changeChar(char word,int n){
		if(word+n>'z')
			return (char)((word+n-'a')%26+'a');
		else
			return (char)(word+n);
	}
}
