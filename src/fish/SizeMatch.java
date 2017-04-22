package fish;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;
/*
 * ֱ����һ��TreeSet �������������дһ��compare��������֤��С�����˳��
 * �����αȽϼ���һ�£���������x��yֵ�Ƿ������ok��
 */
public class SizeMatch{
	
	private int x ;
	private int y ;
	

	public SizeMatch(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		TreeSet<SizeMatch> set = new TreeSet<SizeMatch>(new Comparator<SizeMatch>() {

			@Override
			public int compare(SizeMatch o1, SizeMatch o2) {
				if(o1.x<o2.x){
					return -1;
				}else if(o1.x>o2.x){
					return 1;
				}else{
					if(o1.y<o2.y){
						return -1;
					}else if(o1.y>o2.y){
						return 1;
					}else{
						return 0;
					}
				}
			}
			
		});
		
		for(int i=0;i<n;i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			set.add(new SizeMatch(x, y));
		}
		handler(set);
		sc.close();

	}


	private static void handler(TreeSet<SizeMatch> set) {
		int result = 1;
		SizeMatch fisrt = set.first();
		int x= fisrt.x;
		int y= fisrt.y;
		for(Object size : set.toArray()){
			SizeMatch temp = (SizeMatch) size;
			if(x<temp.x&&y<temp.y){
				result++;
				x = temp.x;
				y = temp.y;
			}
		}
		System.out.println(result);
	}

}
