package unfinished;


public class Sort {
	
	/**
	 * 插入排序
	 * @param nums
	 * 时间复杂度为O(n`2) 
	 */
	public static void insertSort(int[] nums){
		if(nums==null||nums.length==0){
			return;
		}
		for(int i=1;i<nums.length;i++){
			if(nums[i-1]>nums[i]){
				int j = i-1;
				int temp = nums[i];
				while(nums[j]>temp){
					nums[j+1]=nums[j];
					j--;
				}
				nums[j+1]=temp;
			}
		}
	}
	
	/**
	 * 堆排序
	 * @param nums
	 * 通过创建顶堆（或者小顶堆）将最大、小以此选出来进行位置交换
	 * 时间复杂度为O(nlog(n)) 
	 */
	public static void headSort(int[] nums){
		if(nums==null||nums.length==0){
			return;
		}
		for(int i=0;i<nums.length;i++){
			createMaxHead(nums,nums.length-1-i);
			swap(nums,0,nums.length-1-i);
		}
	}
	
	/**
	 * 交互数组中俩个位置的值
	 * @param nums
	 * @param i
	 * @param j
	 */
	private static void swap(int[] nums, int i, int j) {
		if(i==j){
			return;
		}
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	/**
	 * 创建大顶堆
	 * @param nums
	 * @param index
	 * 注意：数组中i=(index-1)/2  表示i位置的的父节点   进行堆中遍历交换，大顶推中每次会将数据中最大的数值移到最前端
	 */
	private static void createMaxHead(int[] nums, int index) {
		for(int i=(index-1)/2;i>=0;i--){
			int k = i;//标记上一层节点
			while(2*k+1<=index){
				//若该节点的子节点存在
				int biggerIndex = 2*k+1;
				if(biggerIndex<index){
					if(nums[biggerIndex]<nums[biggerIndex+1]){
						biggerIndex++;
					}
				}
				if(nums[k]<nums[biggerIndex]){
					swap(nums, k, biggerIndex);
					k=biggerIndex;
				}else{
					break;
				}
				
			}
		}
		
	}

	/**
	 * 希尔排序
	 * @param nums
	 * 现将待排序的数组元素分成多个子序列，使得每个子序列的元素个数相对较少，
	 * 然后对各个子序列分别进行直接插入排序，待整个待排序列“基本有序”后，最后在对所有元素进行一次直接插入排序。
	 * 时间复杂度为O(nlog(n)) 
	 */
	public static void shellSort(int[] nums){
		if(nums==null||nums.length==0){
			return;
		}
		int range = nums.length/2;
		while(range>=1){
			for(int i=0;i<nums.length;i++){
				for(int j=i;j<nums.length-range;j=j+range){
					//进行插入排序
					if(nums[j]>nums[j+range]){
						int temp = nums[j];
						nums[j] = nums[j+range];
						nums[j+range] = temp;
					}
				}
			}
			range = range/2;
		}
	}
	
	/**
	 * 选择排序
	 * @param nums
	 * 每次遍历找出最小或最大的元素 与前一个元素交换位置
	 * 时间复杂度为O(n`2) 
	 */
	public static void selectSort(int[] nums){
		if(nums==null||nums.length==0){
			return;
		}
		int temp = 0,index=0;
		for(int i =0;i<nums.length;i++){
			temp=nums[i];
			index = i;
			for(int j = i ;j<nums.length;j++){
				if(temp>nums[j]){
					temp=nums[j];
					index=j;
				}
			}
			nums[index]=nums[i];
			nums[i]=temp;
		}
	}
	
	/**
	 * 合并排序
	 * @param nums
	 * @param start
	 * @param end
	 * 将两个（或两个以上）有序表合并成一个新的有序表 即把待排序序列分为若干个子序列，每个子序列是有序的。
	 * 然后再把有序子序列合并为整体有序序列 
     * 时间复杂度为O(nlogn) 
	 */
	public static void mergeSort(int[] nums,int start,int end){
		if(start<end){
			int mid = (start+end)/2;
			mergeSort(nums,start,mid);
			mergeSort(nums,mid+1,end);
			mergeSortHandler(nums, start,mid, end);
		}
		return;
	}
	
	/**
	 * 归并排序核心思路：将两个有序序列（start-mid，mid+1-end）进行合并排序
	 * @param nums
	 * @param start
	 * @param mid
	 * @param end
	 */
	private static void mergeSortHandler(int[] nums, int start, int mid, int end) {
		int[] temp = new int[end-start+1];
		int i =start;
		int j =mid+1;
		int k =0;
		while(i<=mid&&j<=end){
			if(nums[i]<nums[j]){
				temp[k++] = nums[i++];
			}else{
				temp[k++] = nums[j++];
			}
		}
		
		while(i<=mid){
			temp[k++]=nums[i++];
		}
		
		while(j<=end){
			temp[k++]=nums[j++];
		}
		
		for(int m=0;m<temp.length;m++){
			nums[start+m] = temp[m];
		}
	}


	/**
	 * 快速排序
	 * @param nums
	 * @param start
	 * @param end
	 */
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
	
	/**
	 * 冒泡排序
	 * @param nums
	 */
	private static void bubboSort(int[] nums) {
		for(int i=0;i<nums.length;i++){
			for(int j=1;j<nums.length-i;j++){
				if(nums[j-1]>nums[j]){
					int temp = nums[j-1];
					nums[j-1] = nums[j];
					nums[j] = temp;
				}
			}
		}
	}


	public static void main(String[] args) {
		int[] nums = {1,2,4,6,7,3,6,8,10};
//		fastSort(nums, 0, nums.length-1);
//		mergeSort(nums, 0, nums.length-1);
//		selectSort(nums);
//		shellSort(nums);
//		headSort(nums);
//		insertSort(nums);
		bubboSort(nums);
		for(int num:nums){
			System.out.print(num+" ");
		}
	}

	
}
