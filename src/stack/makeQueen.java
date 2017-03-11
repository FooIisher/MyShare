package stack;


import java.util.Stack;

/**
 * ������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
 * @author fish
 *
 */

public class makeQueen {
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
        
    }
    
    public int pop() {
    	 if(stack2.empty()){
             while(!stack1.empty()){
     			stack2.push(stack1.pop());
     		}
     		if(stack2.empty()){
                 return -1;
         	}else{
         	    return stack2.pop();
        		}
         }else{
             return stack2.pop();
         }
    }
}
