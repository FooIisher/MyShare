package Unfinished;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class Main {


/*������������������ʵ����ĿҪ��Ĺ���*/
/*��Ȼ����Ҳ���Բ������������ģ����������ȫ�����Լ����뷨�� ^-^ */
/******************************��ʼд����******************************/
public  static boolean partition(int[] n){
     if(n.length<1){
    	 return false;
     }
     int sum=0;
     for(int num:n){
        sum=sum+num;
     }
     if(sum%2==0){
    	 fastSort(n, 0, n.length-1);
         int i=0,j=n.length-1;
         int left =n[0],right=n[n.length-1];
         while(i<j){
        	 if(left<right){
        		 i++;
        		 left = left+n[i];
        	 }
        	 
        	 if(left>right){
        		 j--;
        		 right= right+n[j];
        	 }
        	 
        	 if(left==right&&i==j-1){
        		 return true;
        	 }
        	 
        	 if(left==right&&i!=j-1){
        		 i++;
        		 left = left+n[i];
        		 j--;
        		 right= right+n[j];
        	 }
         }
         
         return  false;
     }else{
    	 return  false;
     }
     
    
}

public static void fastSort(int[] nums,int start,int end){
		if(start >= end)
	    {
	        return;
	    }
		int i=start, j=end;
		int temp = nums[i];
		while(i<j){
			while(i<j&&nums[j]>=temp){
				j--;
			}
			if(i<j){
				nums[i] = nums[j];
			}
			while(i<j&&nums[i]<temp){
				i++;
			}
			if(i<j){
				nums[j] = nums[i];
			}
		}
		nums[i] = temp;	
		fastSort(nums, start, i-1);
		fastSort(nums, i+1, end);
	}

/******************************����д����******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[]  input;
        input = in.nextLine().trim().split(" ");
        int[] n =new int [input.length];
        for(int i=0;i<input.length;i++){
        	n[i] = Integer.valueOf(input[i]); 
        }
         boolean  result =  partition (n);
        System.out.println(result);    

    }
}