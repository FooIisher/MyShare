import java.text.DecimalFormat;
import java.util.Scanner;
/**
 *小明同学最近学习了概率论，他了解到数学期望的定义：设X为一个随机变量，X可以取n种不同的取值x1,x2,x3,…,xn。取x1的概率为p1,取x2的概率为p2,以此类推。定义随机变量X的数学期望为：E[X]=x1*p1+x2*p2+…+xn*pn。
 *小明回到家中，他想编程计算数学期望，你能帮助他么？
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