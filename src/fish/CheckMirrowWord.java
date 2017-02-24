package fish;

import java.util.Scanner;


/**
 * ¾µÏñµ¥´Ê¼ì²â
 * @author fish
 *
 */
public class CheckMirrowWord {

	public static void main(String[] args) {
		while(true){
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			System.out.println(checkMirrowWor(input));
		}
			
		
		
		
		
	}

	private static boolean checkMirrowWor(String input) {
		int i=0;
		int j=input.length()-1;
	
		while(i<j){
			if(input.charAt(i)==input.charAt(j)){
				i++;
				j--;
			}else
				return false;
		}
		return true;
	}

}
