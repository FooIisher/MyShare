package linklist;

import java.util.Stack;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 * @author fish
 *
 */
public class FindFirstCommonNode {
	
	public ListNode getCommonNode(ListNode pHead1,ListNode pHead2){
		if(pHead1==null||pHead2==null){
            return null;
        }
        
        Stack<ListNode> stack1 = new Stack<ListNode>();
        Stack<ListNode> stack2 = new Stack<ListNode>();
        while(pHead1!=null&&pHead1.next!=null){
            stack1.push(pHead1);
            pHead1 = pHead1.next;
        }
        while(pHead2!=null&&pHead2.next!=null){
            stack2.push(pHead2);
            pHead2 = pHead2.next;
        }
        ListNode commom = null;
        while(stack1.empty()&&stack2.empty()){
            if(stack1.peek()==stack2.peek()){
            	commom = stack1.pop();
            	stack2.pop();
            }else{
            	break;
            }
        }
		return commom;
		
	}
	
	
	  public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
			ListNode p1 = pHead1;
	        ListNode p2 = pHead2;
	        while(p1 != p2) {
	        	if(p1 != null) p1 = p1.next;
	        	if(p2 != null) p2 = p2.next;
	        	if(p1 != p2) {
	        		if(p1 == null) p1 = pHead1;
	        		if(p2 == null) p2 = pHead2;
	        	}
	        }
	        return p1;
	    }
	
}
