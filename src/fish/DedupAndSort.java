package fish;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;


/*
 * ������У���������������ĸ�������������Ӧ����������
 * ���ض��У������Ľ��
 * 
 * 
 */



public class DedupAndSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		TreeSet<Integer> set=new TreeSet<Integer>();
		for(int i=0;i<num;i++){
			set.add(sc.nextInt());
			//����TreeSet�Զ�ȥ�ظ�   �Լ�set��comparator������Ԫ�ؽ���
		}
		
		set.comparator();
		Iterator<Integer> it=set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}

	}

}
