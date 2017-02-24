package fish;

import java.util.Scanner;

public class ReplaceSpace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuffer in = new StringBuffer();;
		String input = sc.nextLine();
		in.append(input);
		System.out.print(replaceSpace(in));
	}

	public static String replaceSpace(StringBuffer str) {
    	StringBuffer output = new StringBuffer();
//        String temp[] = str.toString().split(" ");
//        for(int i=0;i<temp.length;i++){
//            output.append(temp[i]);
//            if(i!=temp.length-1)
//                output.append("%20");
//        }
    	for(int i=0;i<str.length();i++){
    		if(str.toString().charAt(i)==' ')
    			output.append("%20");
    		else
    			output.append(str.toString().charAt(i));
    		
    	}
        return output.toString();
    }
	

}
