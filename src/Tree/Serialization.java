package Tree;
/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * @author fish
 *
 */
public class Serialization {

	int index =-1;
	
	 String Serialize(TreeNode root) {
		 if(root == null){
			 return null;   
		 }
		 StringBuilder sb = new StringBuilder();
		 serializeHandler(root,sb);
		 return sb.toString();        
	 }
	 
	 private void serializeHandler(TreeNode root, StringBuilder sb) {
		if(root==null){
			sb.append("#,");
			return;
		}
		sb.append(root.val+",");
		serializeHandler(root.left, sb);
		serializeHandler(root.right, sb);
	}

	TreeNode Deserialize(String str) {
		if(str==null){
			return null;
		}
		String[] ins = str.split(",");
		return deserializeHandler(ins);
	 }

	private TreeNode deserializeHandler(String[] ins) {
		index++;
		if(!ins[index].equals("#")){
			TreeNode node = new TreeNode(Integer.valueOf(ins[index]));
			node.left = deserializeHandler(ins);
			node.right = deserializeHandler(ins);
			return node;
		}
		return null;
	}
}
