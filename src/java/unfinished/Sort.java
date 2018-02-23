package unfinished;


public class Sort {
	
	/**
	 * ��������
	 * @param nums
	 * ʱ�临�Ӷ�ΪO(n`2) 
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
	 * ������
	 * @param nums
	 * ͨ���������ѣ�����С���ѣ������С�Դ�ѡ��������λ�ý���
	 * ʱ�临�Ӷ�ΪO(nlog(n)) 
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
	 * ��������������λ�õ�ֵ
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
	 * �����󶥶�
	 * @param nums
	 * @param index
	 * ע�⣺������i=(index-1)/2  ��ʾiλ�õĵĸ��ڵ�   ���ж��б���������������ÿ�λὫ������������ֵ�Ƶ���ǰ��
	 */
	private static void createMaxHead(int[] nums, int index) {
		for(int i=(index-1)/2;i>=0;i--){
			int k = i;//�����һ��ڵ�
			while(2*k+1<=index){
				//���ýڵ���ӽڵ����
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
	 * ϣ������
	 * @param nums
	 * �ֽ������������Ԫ�طֳɶ�������У�ʹ��ÿ�������е�Ԫ�ظ�����Խ��٣�
	 * Ȼ��Ը��������зֱ����ֱ�Ӳ������򣬴������������С��������򡱺�����ڶ�����Ԫ�ؽ���һ��ֱ�Ӳ�������
	 * ʱ�临�Ӷ�ΪO(nlog(n)) 
	 */
	public static void shellSort(int[] nums){
		if(nums==null||nums.length==0){
			return;
		}
		int range = nums.length/2;
		while(range>=1){
			for(int i=0;i<nums.length;i++){
				for(int j=i;j<nums.length-range;j=j+range){
					//���в�������
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
	 * ѡ������
	 * @param nums
	 * ÿ�α����ҳ���С������Ԫ�� ��ǰһ��Ԫ�ؽ���λ��
	 * ʱ�临�Ӷ�ΪO(n`2) 
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
	 * �ϲ�����
	 * @param nums
	 * @param start
	 * @param end
	 * �����������������ϣ������ϲ���һ���µ������ ���Ѵ��������з�Ϊ���ɸ������У�ÿ��������������ġ�
	 * Ȼ���ٰ����������кϲ�Ϊ������������ 
     * ʱ�临�Ӷ�ΪO(nlogn) 
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
	 * �鲢�������˼·���������������У�start-mid��mid+1-end�����кϲ�����
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
	 * ��������
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
	 * ð������
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
