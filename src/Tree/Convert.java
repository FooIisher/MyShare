package Tree;
/**
 * ����һ�ö��������������ö���������ת����һ�������˫������
 * Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
 * @author fish
 *
 */
public class Convert {
	
	public TreeNode convert(TreeNode head){
		if(head == null){
			return null;
		}
		
		//���һ���ڵ����Ϊ���Ҳ��Ҷ�ӽڵ�
		if(head.left==null&&head.right==null){
			return head;
		}
		//��������ת��Ϊ˫������������ͷ���
		TreeNode left = convert(head.left);

		TreeNode leftLast = left;
		while(leftLast!=null&&leftLast.right!=null){
			leftLast=leftLast.right;//����������������Ժ�һ����
		}
	    //����������������ڵ���������
		if(left!=null){
			leftLast.right = head;
			head.left = leftLast;
		}
		
		TreeNode right = convert(head.right);
		//��������ת��������͸��ڵ����ƴ��
		if(right!=null){
			head.right=right;
			right.left = head;
		}
		
		return left!=null?left:head;
	}
}
