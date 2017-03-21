package linkList;


public class ListNode {
     int val;
     ListNode next;
     
     ListNode(int x) {
         this.val = x;
         this.next = null;
     }
     
     
     /**
      * 重写链表toString方法  能够更好的看到相关结果
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