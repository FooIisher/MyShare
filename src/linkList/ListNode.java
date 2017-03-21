package linkList;


public class ListNode {
     int val;
     ListNode next;
     
     ListNode(int x) {
         this.val = x;
         this.next = null;
     }
     
     
     /**
      * ��д����toString����  �ܹ����õĿ�����ؽ��
      */
	@Override
	public String toString() {
		
		
		StringBuffer sb = new StringBuffer(""+this.val);
		if(this.next!=null){
			ListNode temp = this.next;
			while(temp!=null){
				sb.append(" -> "+ temp.val);
				temp=temp.next;
			}
		}
		return "LinkNode ["+sb.toString() + "]";
	}
}