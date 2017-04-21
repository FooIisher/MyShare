package linkList;
/**
 * 一个链表中包含环，请找出该链表的环的入口结点。
 * @author fish
 * 思路：
 * 1、找环中相汇点。分别用fast，slow指向链表头部，slow每次走一步，fast每次走二步，直到slow==fast找到在环中的相汇点。
 * 2、当slow==fast时，fast所经过节点数为2x,slow所经过节点数为x,设环中有n个节点,fast比slow多走一圈有2x=n+x;
 * 	n=x;可以看出slow实际走了一个环的步数，再让fast指向链表头部，slow位置不变，slow,fast每次走一步直到slow==fast;
 *  此时slow指向环的入口。
 */
public class EntryNodeOfLoop {
	
	 public ListNode entryNodeOfLoop(ListNode pHead){
		if(pHead==null){
			return null;
		}
		ListNode slow = pHead;
		ListNode fast = pHead;
		while(slow!=null&&fast!=null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow==fast){
				fast = pHead;
				while(fast!=slow){
					slow = slow.next;
					fast = fast.next;
				}
				if(fast==slow){
					return slow;
				}
			}
		}
		return null;
	 }
}
