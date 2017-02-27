package linkList;


public class LinkNode {
     int val;
     LinkNode next;
     
     LinkNode(int x) {
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
			LinkNode temp = this.next;
			while(temp!=null){
				sb.append(" -> "+ temp.val);
				temp=temp.next;
			}
		}
		return "LinkNode ["+sb.toString() + "]";
	}
}