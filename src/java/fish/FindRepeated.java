package fish;

/**
 * ��һ�������д������ɸ���ĸ���и���ĸ���ֵĴ�������������������һ�룬�ҳ������ĸ
 * Ҫ�������ٵ�ʱ�临�ӶȺͿռ临�Ӷ�ȥ���
 * @author fish
 *	˼·����ʾ������������һ�α����������
 *	������������͸���ĸ���ֵĴ��������������һ�������������
 *	��������һ���洢��ǰ�������ַ����͸��ַ��������ֵĴ���
 *	������ͬ�ַ�������+1����ͬ-1��������Ϊ0�󣬼�¼���ַ�
 *	����¼�µ�һ��Ϊ���ظ����ַ�
 */
public class FindRepeated {

	public static void main(String[] args) {
		int[] nums  = {4,3,4,4,4,4,5,5,5,1,2,3,4,4,4,5,4};
		handler(nums);
	}

	private static void handler(int[] nums) {
		int tempChar = nums[0];
		int tempCount = 1;
		for(int num:nums){
			if(num==tempChar){
				tempCount++;
			}else{
				tempCount--;
				if(tempCount==0){
					tempChar = num;
					tempCount = 1;
				}
			}
		}
		System.out.println(tempChar);
	}

}
