import java.util.HashSet;
import java.util.Scanner;

/**
 * һ���ַ���S��ż�����ҽ���S�е�ÿһ���ַ���������ż���Ρ����ַ�����aabccb����һ��ż������Ϊ�ַ�a,b,c�����������Ρ����ַ�����abbcc������ż������Ϊ�ַ�a������һ�Ρ�
 * ���ڸ���һ������Ϊn���ַ���T=t1,t2,t3,��,tn���ַ������Ӵ�Ϊ������������һ�Ρ�T����Ϊ1���Ӵ���n��������Ϊ2���Ӵ���n-1�����Դ����ƣ�Tһ����n(n+1)/2���Ӵ�������T������������ж��ٸ��Ӵ���ż����
 * @author fish
 *
 */
public class DoubleSubString {

	public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	while(sc.hasNext()){
             System.out.println(handler(sc.next()));
        }
     
    }
      
    public static int handler(String str){
    	if(str.length()==0||str.length()==1){
        	return 0;
        }
        int result=0;
        for(int i=0;i<str.length();i++){
        	for(int j=i+2;j<str.length();j++){
            	String temp = str.substring(i,j+1);
                 if(check(temp)){
                       result++;
                 }
            }
        }
          
        return result;  
    }
      
    public static boolean check(String str){
    	if(str.length()==0||str.length()%2==1){
        	return false;
        }
        HashSet<Character> set =new HashSet<Character>();
        char[] ins = str.toCharArray();
        for(char in:ins){
        	if(set.contains(in)){
                set.remove(in);
            }else{
            	set.add(in);
            }
        }
         if(set.size()==0){
             return true;
          }else{
             return false;   
          }        
    }

}
