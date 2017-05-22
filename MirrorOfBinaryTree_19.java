public class MirrorOfBinaryTree_19 {

	/**
	 * 输出二叉树的镜像
	 * 思路：我们主要使用树的前序遍历。
	 * 从树的根节点开始，如果存在左子节点或者右子节点，则交换；
	 * 遍历左子树，如果当前节点存在左子节点或者右子节点，交换，
	 * 遍历右子树，相同，交换。
	 * 直到所有的非叶子节点的子节点都已经交换，则返回。（遇到叶子节点则不再交换）
	 */
	public static void main(String[] args) {

	}

}

class TreeNode {
	int val;
	TreeNode leftNode;
	TreeNode rightNode;
}

class MirrorOfBinaryTree {
	public static void mirrorOfBinaryTree(TreeNode root) {
		
		if(root == null) {//空树直接返回
			return;
		}
		if(root.leftNode == null && root.rightNode == null) { //当前节点不存在左右子节点，直接返回
			return;
		}
		
		//交换当前节点的左右子树（因为交换的是指针，所以是交换的树，并不是交换的节点的值）
		TreeNode tempNode = root.leftNode;
		root.leftNode = root.rightNode;
		root.rightNode = tempNode;
		mirrorOfBinaryTree(root.leftNode);//遍历左子树，交换，求左子树的镜像
		mirrorOfBinaryTree(root.rightNode);//遍历右子树，交换，求右子树的镜像
	}
}
