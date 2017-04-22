package linkList;
/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 *
 * @author fish
 *	思路： 在原有链表每个节点后面。插入一个完全一样的节点，复制前一个节点的随机指针
 *		最后将该链表进行分割。
 */
public class RandomListNodeClone {

	public class RandomListNode {
	    int label;
	    RandomListNode next = null;
	    RandomListNode random = null;

	    RandomListNode(int label) {
	        this.label = label;
	    }
	}
	
	 public RandomListNode Clone(RandomListNode pHead){
		 if(pHead==null){
			 return null;
		 }
		 RandomListNode p = pHead;
		 RandomListNode temp = null;
		 while(p!=null){
			 temp = new RandomListNode(p.label);
			 temp.next = p.next;
			 p.next = temp;
			 p = temp.next;
		 }
		 
		 p=pHead;
		 while(p!=null){
			 temp = p.next;
			 if(p.random!=null){
				 temp.random = p.random.next;
			 }
			 p = temp.next;
		 }

		 
		 RandomListNode cloneHead=new RandomListNode(0);
		 RandomListNode q = cloneHead;
		 p = pHead;
		 while(p!=null){
			 RandomListNode tmp = p.next;
			 p.next = tmp.next;
			 tmp.next = null;
			 q.next = tmp;
			 q = q.next;
			 p = p.next;
		 }
		 return cloneHead.next;
	 }
}
