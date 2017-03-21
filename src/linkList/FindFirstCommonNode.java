package linkList;

import java.util.Stack;

/**
 * �������������ҳ����ǵĵ�һ��������㡣
 * @author fish
 *
 */
public class FindFirstCommonNode {
	
	public ListNode getCommonNode(ListNode link1,ListNode link2){
		Stack<ListNode> stack1= new Stack<ListNode>();
		Stack<ListNode> stack2= new Stack<ListNode>();
		
		while(link1.next!=null){
			stack1.add(link1);
			link1=link1.next;
		}
		
		while(link2.next!=null){
			stack1.add(link2);
			link2=link2.next;
		}
		
		return link2;
		
	}
	

}
