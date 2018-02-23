package tree;

import java.util.ArrayList;
import java.util.Stack;


/**
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，
 * 其他行以此类推。
 * @author fish
 *
 */
public class SnackPrint {
	
	  public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		  ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		  ArrayList<Integer> records = new ArrayList<Integer>();
		  Stack<TreeNode> stack1 = new Stack<TreeNode>();
		  Stack<TreeNode> stack2 = new Stack<TreeNode>();
		  if(pRoot!=null){
			  stack1.add(pRoot);
		  }
		  
		  while(!stack1.empty()||!stack2.empty()){
			  while(!stack1.empty()){
				  TreeNode temp =stack1.pop();
				  if(temp.left!=null){
					  stack2.add(temp.left);
				  }
				  if(temp.right!=null){
					  stack2.add(temp.right);
				  }
				  records.add(temp.val);
			  }
			  if(records.size()!=0){
				  result.add(records);
			  }
			  records = new ArrayList<Integer>();
			  
			  while(!stack2.empty()){
				  TreeNode temp =stack2.pop();
				  if(temp.right!=null){
					  stack1.add(temp.right);
				  }
				  if(temp.left!=null){
					  stack1.add(temp.left);
				  }
				  records.add(temp.val);
			  }
			  if(records.size()!=0){
				  result.add(records);
			  }
			  records = new ArrayList<Integer>();
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
			SnackPrint print = new SnackPrint();
			System.out.print(print.Print(root));
		}
}
