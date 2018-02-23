package fish;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;


/*
 * 输入多行，先输入随机整数的个数，在输入相应个数的整数
 * 返回多行，处理后的结果
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
			//利用TreeSet自动去重复   以及set的comparator方法对元素进行
		}
		
		set.comparator();
		Iterator<Integer> it=set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}

	}

}
