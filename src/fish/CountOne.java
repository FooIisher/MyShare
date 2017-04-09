package fish;

import java.util.Scanner;

/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 * @author fish
 *
 */
public class CountOne {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			handler(sc.nextInt());
		}
		sc.close();

	}

	private static void handler(int in) {
		int result=0;
		int i=in;
		while(i>0){
			char[] ins = String.valueOf(i).toCharArray();
			for(char inChar:ins){
				if(inChar=='1'){
					result++;
				}
			}
		}
		i--;
		System.out.println(result);
		
	}

}
