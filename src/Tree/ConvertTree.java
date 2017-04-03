package Tree;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö�������
 * ���������ǰ���������������Ľ���ж������ظ������֡�
 * ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}��
 * ���ؽ������������ء�
 * @author fish
 *
 */

public class ConvertTree {
	


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] pre = new int[n];
		int[] in = new int[n];
		for(int i=0;i<n;i++){
			pre[i] = sc.nextInt();
		}
		for(int i=0;i<n;i++){
			in[i] = sc.nextInt();
		}
		TreeNode result = reConstructBinaryTree(pre,in);
		sc.close();
		printLine(result);
	}
	
	 private static void printLine(TreeNode result) {
		if(result==null){
			return;
		}
		 Queue<TreeNode> queue = new LinkedList<TreeNode>();
		 queue.add(result);
		 while(!queue.isEmpty()){
			 TreeNode outNode = queue.poll();
			 System.out.print(outNode.val+" ");
			 if(outNode.left!=null){
				 queue.add(outNode.left);
			 }
			 if(outNode.right!=null){
				 queue.add(outNode.right);
			 }
			 
		 }
		
	}

	public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
	        if(pre.length == 0||in.length == 0){
	            return null;
	        }
	 
	        TreeNode now = new TreeNode(pre[0]);
	        for(int i=0;i<in.length;i++){
	           if(pre[0]==in[i]){
	               now.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i+1),Arrays.copyOfRange(in, 0,i));
	               now.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i+1,pre.length),Arrays.copyOfRange(in, i+1,in.length));      
	           }
	        }
	        return now;
	 }
}
