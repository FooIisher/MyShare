package tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 树的遍历
 * @author fish
 *
 */
public class Traversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
//		System.out.print(depthFirstTravel(root));
		System.out.print(allTravelPath(root));
	}

	/**
	 * 找出树的根节点到所有叶子节点的路径
	 * @param root
	 * @return
	 */
	private static ArrayList<ArrayList<Integer>> allTravelPath(TreeNode root) {
		ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> onePath = new ArrayList<Integer>();
		paths = findPath(root,onePath,paths);
		return paths;
	}

	private static ArrayList<ArrayList<Integer>> findPath(TreeNode root, ArrayList<Integer> onePath,
			ArrayList<ArrayList<Integer>> paths) {
		if(root==null){
			return paths;
		}
		onePath.add(root.val);
		if(root.left==null&&root.right==null){
			paths.add(new ArrayList<Integer>(onePath));
		}
		findPath(root.left,onePath,paths);
		findPath(root.right,onePath,paths);
//		这个地方可以通过画递归树来理解，无论叶子结点是左结点还是右结点，都会经过下面这一步，而且至关重要
		onePath.remove(onePath.size()-1);
		return paths;
	}

	/**
	 * 树的深度优先遍历
	 * @param root
	 * @return
	 * 利用一个栈来存储树的节点，利用先进后出的特点，优先录入右边的孩子节点，保证最后遍历到右边孩子节点
	 */
	private static ArrayList<Integer> depthFirstTravel(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(root==null){
			return list;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.empty()){
			TreeNode now = stack.pop();
			list.add(now.val);
			if(now.right!=null){
				stack.add(now.right);
			}
			if(now.left!=null){
				stack.add(now.left);
			}
		}
		return list;
	}

}
