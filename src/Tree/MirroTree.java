package Tree;
/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * @author fish
 *
 */
public class MirroTree {
	   public void Mirror(TreeNode root) {
	        if (root==null)
	            return;
	        
	        if(root.left!=null){
	         
	            TreeNode temp = root.left;
	            root.left =  root.right;
	            root.right = temp;
	     
	            if(root.left!=null){
	                Mirror(root.left);
	            }
	            Mirror(root.right);
	        }else {
	            if(root.right!=null){
	                TreeNode temp = root.right;
	            	root.right =  root.left;
	             	root.left = temp;
	                
	           		Mirror(root.left);
	            }
	        }
	  
	    }
}
