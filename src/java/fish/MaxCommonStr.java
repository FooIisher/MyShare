package fish;

import java.util.Scanner;
/**
 * 两个字符串（可能包含空格）,牛牛想找出其中最长的公共连续子串,希望你能帮助他,并输出其长度。 
 * @author fish
 *
 */
public class MaxCommonStr {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1= sc.nextLine();
		String str2 = sc.nextLine();
		System.out.println(getMaxCommonStrLength(str1,str2));
	}

	private static String getMaxCommonStrLength(String str1, String str2) {
		if(str1.length()==0||str2.length()==0){
			return "No";
		}
		int flag[] = new int [str1.length()];
		char[] ins1 = str1.toCharArray();
		char[] ins2 = str2.toCharArray();
		for(int i=0;i<ins1.length;i++){
			for(int j=0;j<ins2.length;j++){
				int common=0;
				if(ins1[i]==ins2[j]){
					int in1 =i;
					int in2 = j;
					common=1;
					while(in1<ins1.length-1&&in2<ins2.length-1&&ins1[in1+1]==ins2[in2+1]){
						in1++;
						in2++;
						common++;
					}
				}
				if(flag[i]<common){
					flag[i]=common;
				}
				
			}
		}
		int result=0;
		int index=0;
		for(int i=0;i<flag.length;i++){
			
			if(result<flag[i]){
				result = flag[i];
				index =i;
			}
		}
			
		return str1.substring(index, index+result);
	}

}
