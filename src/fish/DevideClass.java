package fish;

import java.util.ArrayList;
import java.util.Scanner;

public class DevideClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		ArrayList<String> ins = new ArrayList<String>();
		for(int i=0;i<num;i++){
			ins.add(sc.next());
		}
		System.out.print(hander(num,ins));

	}

	private static int hander(int num, ArrayList<String> ins) {
		if(num==0){
			return 0;
		}
		
		if(num==1){
			return 1;
		}
		
		String first = ins.get(0);
		ArrayList<String> other = new ArrayList<String>();
		int result=1;
		for(int i=1;i<ins.size();i++){
			if(!check(first,ins.get(i))){
				other.add(ins.get(i));
				result++;
			}
		}
		
		result = result+ hander(other.size(), other);
		
		
		return result;
	}

	private static boolean check(String in, String check) {
		if(in.length()!=check.length()){
			return false;
		}
		
		char[] ins = in.toCharArray();
		char[] checks =check.toCharArray();
		int flag[] = new int[checks.length];
		for(char inchar:ins){
			for(int i=0;i<check.length();i++){
				if(inchar==checks[i]&&flag[i]==0){
					flag[i]=1;
				}
			}
		}
		
		for(int out:flag){
			if(out==0){
				return false;
			}
		}
		return true;
	}

}
