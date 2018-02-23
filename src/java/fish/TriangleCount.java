package fish;

import java.util.Scanner;

/*
 * 
 * ���������ε����󣬵�һ��ֻ��һ����1������ÿ�е�ÿ��������ǡ������������������Ͻ��������Ͻǵ�����3����֮�ͣ����������ĳ��������Ϊ��������0����
 * ���n�е�һ��ż�����ֵ�λ�á����û��ż���������-1����������3,�����2������4�����3��
 * 
 * 
 */

public class TriangleCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		//System.out.println(find(input));
		for(int i=1;i<=input;i++){
			for(int j=1;j<=2*input-1;j++){
				System.out.print(getTriangle(i,j)+" ");
			}
			System.out.println(" ");
		}

	}
	
	public static int getTriangle(int line,int num){
		if(num<1||num>2*line-1)
			return 0;
		else if(num==1||num==2*line-1)
			return 1;
		else 
			return getTriangle(line-1,num-1-1) + getTriangle(line-1,num-1) + getTriangle(line-1,num+1-1);
	}
	
	public static int find(int line){
			for(int i=1;i<=2*line-1;i++){
////			//System.out.print(getTriangle(line,i)+" ");
				if(getTriangle(line,i)%2==0)
					return i;
			}
			return -1;
			
	}

}
