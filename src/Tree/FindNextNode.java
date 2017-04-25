package Tree;
/**
 * ����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء�
 * ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣
 * @author fish
 *
 */
public class FindNextNode {

	public class TreeLinkNode {
	    int val;
	    TreeLinkNode left = null;
	    TreeLinkNode right = null;
	    TreeLinkNode next = null;

	    TreeLinkNode(int val) {
	        this.val = val;
	    }
	}
	
	public TreeLinkNode GetNext(TreeLinkNode pNode){
		if(pNode==null){
			return null;
		}
		//�����������������������������ߵĽڵ�
		if(pNode.right!=null){
			TreeLinkNode node = pNode.right;
			while(node.left!=null){
				node = node.left;
			}
			return node;
		}
		//û�����������ҵ�һ����ǰ�ڵ��Ǹ��ڵ����ӵĽڵ�
		while(pNode.next!=null){
			if(pNode.next.left==pNode){
				//��ǰ�ڵ�ʱ������
				return pNode.next;
			}
			pNode = pNode.next; 
		}
		return null;
        
    }
}
