package tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * @author fish
 *
 *	利用栈来存储每次遍历的路径  
 *	利用动态规划的思想来处理 每个点处理完后与剩下部分组成的结果集
 */

public class GetSumPaths {
	
	public ArrayList<ArrayList<Integer>> handler(TreeNode root,int target){
		ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
		Stack<Integer> path = new Stack<Integer>();
		findPaths(root,target,path,listAll);
		return listAll;
	}

	private void findPaths(TreeNode root, int target, Stack<Integer> path,
			ArrayList<ArrayList<Integer>> listAll) {
		if(root==null){
			return;
		}
		
		if(root.left==null&&root.right==null){
			if(root.val==target){
				ArrayList<Integer> list = new ArrayList<Integer>();
				for(int num:path){
					list.add(num);
				}
				list.add(root.val);
				listAll.add(list);
			}
		}else{
			path.push(root.val);
			findPaths(root.left, target-root.val, path, listAll);
			findPaths(root.right, target-root.val, path, listAll);
			path.pop();
		}
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
