package Tree;
/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
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
		//如果有右子树，则找右子树中最左边的节点
		if(pNode.right!=null){
			TreeLinkNode node = pNode.right;
			while(node.left!=null){
				node = node.left;
			}
			return node;
		}
		//没右子树，则找第一个当前节点是父节点左孩子的节点
		while(pNode.next!=null){
			if(pNode.next.left==pNode){
				//当前节点时是左孩子
				return pNode.next;
			}
			pNode = pNode.next; 
		}
		return null;
        
    }
}
