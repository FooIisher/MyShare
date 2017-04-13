package Tree;
/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * @author fish
 *
 */
public class Convert {
	
	public TreeNode convert(TreeNode head){
		if(head == null){
			return null;
		}
		
		//最后一个节点可能为最右侧的叶子节点
		if(head.left==null&&head.right==null){
			return head;
		}
		//将左子树转换为双向链表，并返回头结点
		TreeNode left = convert(head.left);

		TreeNode leftLast = left;
		while(leftLast!=null&&leftLast.right!=null){
			leftLast=leftLast.right;//找左子树链表最后以后一个点
		}
	    //把左子树链表与根节点连接起来
		if(left!=null){
			leftLast.right = head;
			head.left = leftLast;
		}
		
		TreeNode right = convert(head.right);
		//将右子树转换的链表和根节点进行拼接
		if(right!=null){
			head.right=right;
			right.left = head;
		}
		
		return left!=null?left:head;
	}
}
