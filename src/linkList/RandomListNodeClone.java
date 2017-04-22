package linkList;
/**
 * ����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩��
 * ���ؽ��Ϊ���ƺ��������head��
 *
 * @author fish
 *	˼·�� ��ԭ������ÿ���ڵ���档����һ����ȫһ���Ľڵ㣬����ǰһ���ڵ�����ָ��
 *		��󽫸�������зָ
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
