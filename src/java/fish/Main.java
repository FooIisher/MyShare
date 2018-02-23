package fish;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
	        while (in.hasNextInt()) {
	            int off = in.nextInt();
	            int n = in.nextInt();
	            int len1 = in.nextInt();
	            int len2 = in.nextInt();
	            System.out.println(getResult(off,n,len1,len2));
	      }

	}

	private static String getResult(int off, int n, int len1, int len2) {
		int start1=0,end1=0,start2=0,end2=0;
	
		if(off<len1){
			start1 = off;
			if(n<(len1-off)){
				end1 = off + n;
				start2=0;
				end2=0;
			}else{
				end1 =len1;
				start2 =0;
				end2 =n-(len1-off);
			}
		}else if(off<len1+len2){
			start1 = len1;
			end1 = len1;
			if(n<len2-(off-len1)){
				start2 = off-len1;
				end2 = n + off -len1;
			}else{
				start2 = off-len1;
				end2 =len2;
			}
		
		}else{
			start1 = len1;
			end1 = len1;
			start2 = len2;
			end2 = len2;
		}
		
		return start1+" "+end1+" "+start2+" "+end2;
	}

}
