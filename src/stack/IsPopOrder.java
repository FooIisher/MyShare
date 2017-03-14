package stack;

import java.util.Stack;


/**
 * ���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳��
 * ����ѹ��ջ���������־�����ȡ�
 * ��������1,2,3,4,5��ĳջ��ѹ��˳��
 * ����4��5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У�
 * ��4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С�
 * ��ע�⣺���������еĳ�������ȵģ�
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
