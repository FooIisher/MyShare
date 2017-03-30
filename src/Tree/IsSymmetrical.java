package Tree;
/**
 * ���һ�����Ƿ�Ϊһ�ž�����
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
