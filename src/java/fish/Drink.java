package fish;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * ������һ�������⣺��ĳ�̵�涨����������ˮƿ���Ի�һƿ��ˮ��С��������ʮ������ˮƿ���������Ի�����ƿ��ˮ�ȣ�������5ƿ���������£�����9����ƿ�ӻ�3ƿ��ˮ���ȵ�3ƿ���ģ������Ժ�4����ƿ�ӣ���3���ٻ�һƿ���ȵ���ƿ���ģ���ʱ��ʣ2����ƿ�ӡ�Ȼ�������ϰ��Ƚ����һƿ��ˮ���ȵ���ƿ���ģ������Ժ���3����ƿ�ӻ�һƿ���Ļ����ϰ塣���С��������n������ˮƿ�������Ի�����ƿ��ˮ�ȣ�
 * 
 * 
 */

public class Drink {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		List list = new ArrayList();
		while (true) {
            int n = sc.nextInt();
            if (n == 0)
                break;
            list.add(n);
        }
		
		for(int i=0;i<list.size();i++){
			System.out.println(drink(Integer.parseInt(list.get(i).toString())));
		}
	}
	
	public static int drink(int num){
		int drink = num;
		int change = 0;
		while(num>2){
			drink=drink+num/3;
			change = change + num/3;
			num = num/3 + num % 3;
			
		}
		if(num==2)
			change = change + 1;
			drink=drink+1;
			
		return change;
		
	}

}
