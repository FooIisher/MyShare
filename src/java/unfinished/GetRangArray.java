package unfinished;

/**
 * 给定一个无序数组，指定一个下标范围如7-17，给出其中第7到第17范围的的数据集合
 */

public class GetRangArray {

    public static void main(String[] args) {
        int[] nums = {1,2,4,6,7,3,8,10,5,9};
        int left = 1;
        int right = 2;
        sort(nums,0,nums.length-1,left-1,right-1);
        for(int num:nums){
            System.out.print(num+" ");
        }
    }

    private static void sort(int[] nums, int begin, int off, int left, int right) {
        if (begin>=off){
            return;
        }
        int temp = nums[begin];
        int i = begin;
        int j= off;
        while (i<j){
            while (i<j&&nums[j]>=temp){
                j--;
            }
            if (i<j){
                nums[i]=nums[j];
            }
            while (i<j&&nums[i]<=temp){
                i++;
            }
            if (i<j){
                nums[j]=nums[i];
            }
        }
        nums[i]=temp;
        if (i<=left){
            sort(nums,i+1,off,left,right);
        }else if (i>left&&i<right){
            sort(nums,begin,i-1,left,right);
            sort(nums,i+1,off,left,right);
        }else {
            sort(nums,begin,i-1,left,right);
        }

    }
}
