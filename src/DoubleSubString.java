import java.util.HashSet;
import java.util.Scanner;

/**
 * 一个字符串S是偶串当且仅当S中的每一个字符都出现了偶数次。如字符串”aabccb”是一个偶串，因为字符a,b,c都出现了两次。而字符串”abbcc”不是偶串，因为字符a出现了一次。
 * 现在给出一个长度为n的字符串T=t1,t2,t3,…,tn。字符串的子串为其中任意连续一段。T长度为1的子串有n个，长度为2的子串有n-1个，以此类推，T一共有n(n+1)/2个子串。给定T，你能算出它有多少个子串是偶串吗？
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
