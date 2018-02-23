package fish;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;


/**
 * ����һ������ΪN����������A�� ���������е���������������������������0<=X <= Y <N��������A[X], A[X+1] �� A[Y]����A��һ����Ƭ������(X, Y)��
 * �������±� m1, m2, m3�±��������� 0 < m1, m1 + 1 < m2, m2 +1 < m3 < N �C 1��
 * ���԰������������ֳ�(0, m1-1), (m1+1, m2-1), (m2+1, m3-1), (m3+1, N-1) �ĸ���Ƭ��������ĸ���Ƭ�е����������ȣ��������ĵȷ֡���
 * ��дһ����������һ�����������������Ƿ�����ĵȷ֣�������ԣ�����һ���������͵�true����������Է���һ���������͵�false��
 * ���������� ����A�����1,000,000������е�����ȡֵ��Χ����-1,000,000��1,000,000֮�䡣
 * Ҫ�� �����ļ��㸴�Ӷ�ΪO(N)��ʹ�õĶ���洢�ռ䣨�������������֮�⣩���ΪO(N)��
 * ���ӣ�
 * ��������A=[2, 5, 1, 1, 1, 1, 4, 1, 7, 3, 7] �����±� 2, 7, 9ʹ������ֳ��ĸ���Ƭ[2, 5], [1, 1, 1, 4], [7], [7]����������Ƭ������֮����ȣ����Զ���������飬����Ӧ�÷���true��
 * �������� A=[10, 2, 11, 13, 1, 1, 1, 1, 1]�� �Ҳ����ܰ������ĵȷֵ��±꣬���Ժ���Ӧ�÷���false��
 * @author fish
 *
 */
public class SeperateArrayList {

		   
	public static void main(String[] args){

		int []  A ={1, 1, 1, 1, 1, 1, 1};
		Boolean res = resolve(A);
		System.out.println(String.valueOf(res));
		
	}
	
	/**
	 * ����˼·�� ���ҷֱ�ʼ�ۼ���� �����Сʱ����±����ƣ��ұ�Сʱ�ұ��±�����
	 * ֵ���������ʱ��ȡ�м䲿���ڶ�����һ�����ϵ�������ͶԱȹ��̿��ܷ��ҵ��м��ƽ���
	 * �ǵ�ҪЧ�� ƽ���ĺ���֮ǰ�ĺ��Ƿ����
	 * 
	 * ps ��������߱���⣬��ʱ����ʱ���е��±�û������
	 * 
	 * @param a
	 * @return
	 */
	private static Boolean resolve(int[] a) {
		boolean result = false;
		int i=0;
		int j=a.length-1;
		int left =a[i];
		int right =a[j];
		while(i<j){
			if(left<right){
				i++;
				left +=a[i];
			}else if(left>right){
				j--;
				right +=a[j];
			}else if(left == right){
				result = checkMiddle(i+1,j-1,left,a);
				if(result){
					return result;
				}else{
					i++;
					left +=a[i];
				}
			}
			
		}
		return result;
	}

	private static boolean checkMiddle(int start, int end, int sum, int[] a) {
		int i = start+1;
		int j = end -1;
		int left =a[i];
		int right =a[j];
		while(j>i){
			if(left<right){
				i++;
				left +=a[i];
			}else if(left>right){
				j--;
				right +=a[j];
			}else if(left == right){
				if(j-i==2&&left == sum){
					return true;
				}else{
					return false;
				}
				
			}
			
		}
		return false;
	}
	
		   
		
	
	

}
