package tree;

public class GetTreeDepth {
	 public int TreeDepth(TreeNode root) {
		if(root==null){
	        return 0;
	    }
	        
	    if(root.left==null&&root.right==null){
			return 1;
		} 
			
		if(root.left==null&&root.right!=null){
			return TreeDepth(root.right)+1;
		}
			
		if(root.left!=null&&root.right==null){
			return TreeDepth(root.left)+1;
		}
			
		if(root.left!=null&&root.right!=null){
			return (TreeDepth(root.left)>TreeDepth(root.right)?TreeDepth(root.left):TreeDepth(root.right))+1;
		}

		return 0;
	}
}
