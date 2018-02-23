package tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * ����һ�Ŷ�������һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����
 * ·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
 * @author fish
 *
 *	����ջ���洢ÿ�α�����·��  
 *	���ö�̬�滮��˼�������� ÿ���㴦�������ʣ�²�����ɵĽ����
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
