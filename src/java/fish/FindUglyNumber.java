package fish;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * ��ֻ����������2��3��5��������������Ugly Number����
 * ����6��8���ǳ�������14���ǣ���Ϊ����������7��
 *  ϰ�������ǰ�1�����ǵ�һ���������󰴴�С�����˳��ĵ�N��������
 * @author fish
 *	˼·�����������¼֮ǰ�ĳ���������¼��ǰ�������ɼ���2,3,5�˻���϶��� �����εݹ��ж���Сֵ
 */
public class FindUglyNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			System.out.print(handler(sc.nextInt())); 
		}
		sc.close();
	}

	private static int handler(int k) {
		if(k==0){
			return 0;
		}
		if(k==1){
			return 1;
		}
		int count2=0,count3=0,count5=0,index=0;
		int num = 0;
		int[] temp = new int[k];
		temp[index] = 1;
		
		while(k>1){
			num = Math.min(temp[count2]*2, Math.min(temp[count3]*3, temp[count5]*5));
			if(num==temp[count2]*2) count2++;
			if(num==temp[count3]*3) count3++;
			if(num==temp[count5]*5) count5++;
			temp[++index]= num;
			k--;
		}
		return  temp[temp.length-1];
	}

}
