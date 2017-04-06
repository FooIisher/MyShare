package Unfinished;

import java.util.Arrays;

/**
 * �������е��������֣����ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�
 * ����һ������,�����������е�����Ե�����P��
 * ����P��1000000007ȡģ�Ľ������� �����P%1000000007 
 * @author fish
 *���ù鲢����˼·����·����Ŀ
 *�ϲ����飬�ϲ�ʱ������ǰ�������ֵarray[i]���ں�������ֵarray[j]ʱ����ǰ��
 *����array[i]~array[mid]���Ǵ���array[j]�ģ�count += mid+1 - i
 *
 */
public class ReversedInArrays {
	
	public static int handler(int[] nums){
		if(nums==null||nums.length==0){
			return 0;
		}
		int[] temp = Arrays.copyOf(nums, nums.length);
		int result = countReversedPair(nums,temp,0,nums.length-1);
		return result;
	}

	private static int countReversedPair(int[] nums, int[] temp, int start, int end) {
		if(start == end){
			return 0;
		}
		int mid = (start+end)>>1;
		int leftCount = countReversedPair(nums, temp, start, mid);
		int rightCount = countReversedPair(nums, temp, mid+1, end);
		int i = mid,j=end;
		int count=0,tempIndex=end;
		while(i>=start&&j>mid){
			if(nums[i]>nums[j]){
				count+=j-mid;
				if(count>=1000000007){
					count = count % 1000000007;
				}
				temp[tempIndex--]=nums[i--];
			}else{
				temp[tempIndex--]=nums[j--];
			}
		}
		while(i>=start){
			temp[tempIndex--]=nums[i--];
		}
		while(j>mid){
			temp[tempIndex--]=nums[j--];
		}
		for(int k=start;k<=end;k++){
			nums[k]=temp[k];
		}
		
		return (leftCount+rightCount+count)%1000000007;
	}

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,0};
		System.out.println(handler(nums));

	}

}
