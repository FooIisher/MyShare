package linkList;

import java.util.Stack;

/**
 * �������������ҳ����ǵĵ�һ��������㡣
 * @author fish
 *
 */
public class FindFirstCommonNode {
	
	public LinkNode getCommonNode(LinkNode link1,LinkNode link2){
		Stack<LinkNode> stack1= new Stack<LinkNode>();
		Stack<LinkNode> stack2= new Stack<LinkNode>();
		
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
