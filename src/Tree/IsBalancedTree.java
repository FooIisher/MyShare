package Tree;

public class IsBalancedTree {
	 public boolean IsBalanced_Solution(TreeNode root) {
		
		if(root==null){
			return true;
		} 
		 
		if(root.left==null&&root.right==null){
			return true;
		} 
		 
		if(root.left!=null&&root.right==null){
			return root.left.val<root.val&&IsBalanced_Solution(root.left);
		} 
		
		if(root.left==null&&root.right!=null){
			return root.right.val>root.val&&IsBalanced_Solution(root.right);
		} 
		 
		if(root.left!=null&&root.right!=null){
			return root.left.val<root.val&&root.right.val>root.val&&IsBalanced_Solution(root.right)&&IsBalanced_Solution(root.left);
		} 
		
		return false;
		 
	 }
}
