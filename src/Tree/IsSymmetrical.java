package Tree;
/**
 * 检查一颗树是否为一颗镜像树
 * @author fish
 *
 */
public class IsSymmetrical {
	 boolean isSymmetrical(TreeNode pRoot){
		if(pRoot==null){
			return true;
		} 
		return checkMirror(pRoot.left,pRoot.right);
	 }

	private boolean checkMirror(TreeNode left, TreeNode right) {
		if(left==null&&right==null){
			return true;
		}
		if(left!=null&&right!=null){
			return left.val==right.val&&checkMirror(left.left, right.right)&&checkMirror(left.right, right.left);
		}
		return false;
	}
}
