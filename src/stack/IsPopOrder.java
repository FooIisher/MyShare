package stack;

import java.util.Stack;


/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 * @author fish
 *
 */
public class IsPopOrder {

	public static void main(String[] args) {
		int [] pushA={1,2,3,4,5};
//		int [] popA={4,3,5,1,2};
		int [] popA={3,5,4,2,1};
		System.out.println(isPopOrder(pushA, popA));

	}
	
	private static boolean isPopOrder(int [] pushA,int [] popA) {
		if(pushA.length==0||popA.length==0){
			return false;
		}
		
		if(pushA.length==0||popA.length==0){
			return false;
		}
        
        if(pushA.length==1&&popA.length==1){
            if(pushA[0]==popA[0]){
                return true;
            }else{
                return false;
            }
            
        }
		
        Stack<Integer> stack = new Stack<Integer>();
        int i=0,j=0;
        while(i<pushA.length&&j<popA.length){
        	if(pushA[i]!=popA[j]){
        		stack.push(pushA[i]);
        		i++;
        	}
        		
        	if(pushA[i]==popA[j]){
        		if(i<pushA.length-1){
        			i++;
        			j++;
        		}
        		
        	}
        	
        	if(i==pushA.length-1){
        		while(!stack.empty()){
        			if(popA[j+1]!=stack.pop()){
        				return false;
        			}else{
        				j++;
        			}
        		}
        		return true;
        	}
        }
        return false;
    }

}
