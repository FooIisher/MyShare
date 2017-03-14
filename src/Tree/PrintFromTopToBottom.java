package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * @author fish
 *
 */
public class PrintFromTopToBottom {

	public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
       ArrayList<Integer> result = new ArrayList<Integer>();
       Queue<TreeNode> temp = new LinkedList<TreeNode>();
       temp.add(root);
       while(temp.peek()!=null){
    	   TreeNode first = temp.poll();
    	   result.add(first.val);
    	   if(first.left!=null){
    		   temp.add(first.left);
    	   }
    	   if(first.right!=null){
    		   temp.add(first.right);
    	   }
       }
       
       return result;
       
    }
	
}
