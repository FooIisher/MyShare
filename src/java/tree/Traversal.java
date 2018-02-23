package tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * ���ı���
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
	 * �ҳ����ĸ��ڵ㵽����Ҷ�ӽڵ��·��
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
//		����ط�����ͨ�����ݹ�������⣬����Ҷ�ӽ�������㻹���ҽ�㣬���ᾭ��������һ��������������Ҫ
		onePath.remove(onePath.size()-1);
		return paths;
	}

	/**
	 * ����������ȱ���
	 * @param root
	 * @return
	 * ����һ��ջ���洢���Ľڵ㣬�����Ƚ�������ص㣬����¼���ұߵĺ��ӽڵ㣬��֤���������ұߺ��ӽڵ�
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
