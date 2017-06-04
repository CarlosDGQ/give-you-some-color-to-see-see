public class ConvertBinSearchTree_27 {

	/**
	 * 将二叉搜索树转换为排好序的双向链表。
	 * 要求不能创建新的节点，只能调整二叉树的节点指针的指向。
	 * 思路：将二叉树分为三个部分，根节点，左子树，右子树。
	 * 将左子树、根节点、右子树链接起来。方法如下：将根节点的左指针指向左子树值最大的节点，将根节点的右子针指向右子树值最小的节点，
	 * 至于如何将左子树、右子树内部的节点链接起来，和上述方法相同，使用递归即可。
	 * 由于要求双向链表是排好序的，可以使用中序遍历的方法，中序遍历二叉搜索树得到有序序列。
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class TreeNode1 {
    int val = 0;
    TreeNode1 left = null;
    TreeNode1 right = null;
    public TreeNode1(int val) {
        this.val = val;

    }
}

class ConvertBinSearchTree {
	public TreeNode1 head = null;//记录双向链表的头结点。是二叉搜索树的最左结点。
	public TreeNode1 lastNodeInlist = null;//记录二叉搜索树的最后一个节点。
	public TreeNode1 convertBinSearchTree(TreeNode1 root) {
		if(root == null) {
			return null;
		}
		convert(root);
		return head;
		
	}
	public void convert(TreeNode1 root) {
		if(root == null)
			return;
		if(root.left != null) {
			convert(root.left);
		}
		if(lastNodeInlist == null) {//二叉树最左节点为双向链表的头结点，也是双向链表的第一个节点
			head = root;
			lastNodeInlist = root;
		} else {
			//连接根节点和双向循环链表的最后一个节点
			root.left = lastNodeInlist;
			lastNodeInlist.right = root;
			lastNodeInlist = root;
		}
		if(root.right != null) {
			convert(root.right);
		}
	}
}
