package fish;

import java.util.Scanner;

/*
 * ��Ŀ������
 *
 *		����Ҫ��:
 *      1.���ȳ���8λ       
 *      2.������Сд��ĸ.����.��������,����������������     
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
