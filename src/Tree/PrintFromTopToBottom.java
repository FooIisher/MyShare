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
	
	 public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		  ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		  ArrayList<Integer> records = new ArrayList<Integer>();
		  Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
		  Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
		  if(pRoot!=null){
			  queue1.add(pRoot);
		  }
		  
		  while(!queue1.isEmpty()||!queue2.isEmpty()){
			  while(!queue1.isEmpty()){
				  TreeNode temp = queue1.poll();
				  if(temp.left!=null){
					  queue2.offer(temp.left);
				  }
				  if(temp.right!=null){
					  queue2.offer(temp.right);
				  }
				  records.add(temp.val);
			  }
			  if(records.size()!=0){
				  result.add(records);
			  }
			  records =  new ArrayList<Integer>(); 
			  
			  
			  while(!queue2.isEmpty()){
				  TreeNode temp = queue2.poll();
				  if(temp.left!=null){
					  queue1.offer(temp.left);
				  }
				  if(temp.right!=null){
					  queue1.offer(temp.right);
				  }
				  records.add(temp.val);
			  }
			  if(records.size()!=0){
				  result.add(records);
			  }
			  records =  new ArrayList<Integer>();   
		  }
		return result;
	 }
	 
	 public static void main(String[] args){
			//{8,6,10,5,7,9,11},1
			TreeNode root = new TreeNode(1);
			root.left = new TreeNode(2);
			root.left.left = new TreeNode(4);
			root.left.right = new TreeNode(5);
			root.right = new TreeNode(3);
			root.right.left = new TreeNode(6);
			root.right.right = new TreeNode(7);
			PrintFromTopToBottom print = new PrintFromTopToBottom();
			System.out.print(print.Print(root));
		}
}
