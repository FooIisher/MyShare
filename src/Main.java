import java.text.DecimalFormat;
import java.util.Scanner;
/**
 *С��ͬѧ���ѧϰ�˸����ۣ����˽⵽��ѧ�����Ķ��壺��XΪһ�����������X����ȡn�ֲ�ͬ��ȡֵx1,x2,x3,��,xn��ȡx1�ĸ���Ϊp1,ȡx2�ĸ���Ϊp2,�Դ����ơ������������X����ѧ����Ϊ��E[X]=x1*p1+x2*p2+��+xn*pn��
 *С���ص����У������̼�����ѧ���������ܰ�����ô��
 * @author fish
 *
 */
public class Main{
	public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x[] = new int[n];
        int p[] = new int[n];
        for(int i=0;i<n;i++){
        	x[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }
        System.out.println(handler(n,x,p));
    }
      
    public static String handler(int n,int[] x,int[] p){
    	double result = 0;
        for(int i=0;i<n;i++){
        	result = result+ x[i]*p[i];
        }
        double out = result/100;  
        DecimalFormat df = new DecimalFormat("0.000");
        String st = df.format(out);
        return st; 
    }
}