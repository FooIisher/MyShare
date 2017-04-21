package linkList;
/**
 * һ�������а����������ҳ�������Ļ�����ڽ�㡣
 * @author fish
 * ˼·��
 * 1���һ������㡣�ֱ���fast��slowָ������ͷ����slowÿ����һ����fastÿ���߶�����ֱ��slow==fast�ҵ��ڻ��е����㡣
 * 2����slow==fastʱ��fast�������ڵ���Ϊ2x,slow�������ڵ���Ϊx,�軷����n���ڵ�,fast��slow����һȦ��2x=n+x;
 * 	n=x;���Կ���slowʵ������һ�����Ĳ���������fastָ������ͷ����slowλ�ò��䣬slow,fastÿ����һ��ֱ��slow==fast;
 *  ��ʱslowָ�򻷵���ڡ�
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
