package fish;

import java.util.Scanner;

/*
 * 题目描述：
 *
 *		密码要求:
 *      1.长度超过8位       
 *      2.包括大小写字母.数字.其它符号,以上四种至少三种     
 *     
 */
public class CodeIsLeagle {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String in = sc.next();
			System.out.println("Code: "+in+" isleagle: "+ isLeagle(in));
		}
	}

	private static boolean isLeagle(String in) {
		int num=0;
		if(in.length()-in.replaceAll("[A-Z]", "").length()>0)
			num++;
		if(in.length()-in.replaceAll("[a-z]", "").length()>0)
			num++;
		if(in.length()-in.replaceAll("[0-9]", "").length()>0)
			num++;
		if(in.replaceAll("[0-9,A-Z,a-z]", "").length()>0)
			num++;
		return num>=3;
	}

}
