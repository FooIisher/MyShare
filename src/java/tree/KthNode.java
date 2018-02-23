package tree;

import java.util.Vector;

/**
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。
 * 例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，
 * 按结点数值大小顺序第三个结点的值为4。
 * @author fish
 *
 */

public class KthNode {

	static int index =0;
	static TreeNode kthNode(TreeNode pRoot, int k){
		 if(pRoot!=null){
			 TreeNode node= kthNode(pRoot.left, k);
			 if(node!=null){
				 return node;
			 }
			 index++;
			 if(index==k){
				 return pRoot;
			 }
			 node= kthNode(pRoot.right, k);
			 if(node!=null){
				 return node;
			 }
		 }
		return pRoot;    
	}

	
	public static void main(String[] args){
		//{8,6,10,5,7,9,11},1
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(6);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(7);
		root.right = new TreeNode(10);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(11);
//		System.out.print(kthNode(root,1).val);
		System.out.print(kthNode2(root,1).val);
	}


	private static TreeNode kthNode2(TreeNode root, int k) {
		Vector<TreeNode> temp =new Vector<TreeNode>();
		Vector<TreeNode> order = getOrder(root,temp);
		if(k>order.size()||k==0){
			return null;
		}
		return order.get(k-1);
	}


	private static Vector<TreeNode> getOrder(TreeNode root, Vector<TreeNode> temp) {
		if(root!=null){
			if(root.left!=null){
				temp=getOrder(root.left, temp);
			}
			temp.add(root);
			if(root.right!=null){
				temp=getOrder(root.right, temp);
			}
		}	
		return temp;
	}



}
