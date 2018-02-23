package tree;

public class IsBalancedTree {
	 public boolean IsBalanced_Solution(TreeNode root) {
	    	if(root==null){
				return true;
			}
			
			int left = getDepth(root.left);
			int right = getDepth(root.right);	
			return Math.abs(left-right)>1?false:true;
			 
		 }

		private int getDepth(TreeNode root) {
			if(root==null){
				return 0;
			}
			return (getDepth(root.left)>getDepth(root.right)?getDepth(root.left):getDepth(root.right))+1;
		}
}
