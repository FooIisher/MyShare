package unfinished;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Scanner;
/**
 * 求最大公约数
 * @author fish
 *
 */
public class MinCommonDivisor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<n;i++){
			list.add(sc.nextInt());
		}
		handler(list);
		sc.close();
	}

	private static void handler(ArrayList<Integer> list) {
		Collections.sort(list);
		while(list.get(0) >= 1){
			boolean isCommon = true;
			for(int i = 1; i < list.size(); i++){
				if(list.get(i) % list.get(0) != 0){
					isCommon = false;
					break;
				}
			}
			
			if(isCommon){
				break;
			}
			list.set(0,  list.get(0)-1);
		}
		System.out.println(list.get(0));
	}
	
}
