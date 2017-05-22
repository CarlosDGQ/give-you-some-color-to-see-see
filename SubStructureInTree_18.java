public class SubStructureInTree_18 {

	/**
	 * 输入两颗二叉树A和B,判断B是不是A的子结构。
	 * 思路：第一步，遍历树A，看其中是否存在与B的根节点值相同的节点（树的遍历）。
	 * 第二步，如果找到了根节点，记为R，判断A中以R为根节点的树，是否与B中的结构相同。（判断二叉树A是否包含二叉树B）。
	 */
	public static void main(String[] args) {
		//二叉树A
		BinaryTreeNode root = new BinaryTreeNode();
		root.val = 8;
		root.leftTreeNode = root.rightTreeNode = null;
		BinaryTreeNode node1 = new BinaryTreeNode();
		BinaryTreeNode node2 = new BinaryTreeNode();
		node1.val = 8;
		node1.leftTreeNode = node1.rightTreeNode = null;
		node2.val = 7;
		node2.leftTreeNode = node2.rightTreeNode = null;
		root.leftTreeNode = node1;
		root.rightTreeNode = node2;
		BinaryTreeNode node3 = new BinaryTreeNode();
		BinaryTreeNode node4 = new BinaryTreeNode();
		node3.val = 9;
		node3.leftTreeNode = node3.rightTreeNode = null;
		node4.val = 2;
		node4.leftTreeNode = node4.rightTreeNode = null;
		node1.leftTreeNode = node3;
		node1.rightTreeNode = node4;
		BinaryTreeNode node5 = new BinaryTreeNode();
		BinaryTreeNode node6 = new BinaryTreeNode();
		node5.val = 4;
		node5.leftTreeNode = node5.rightTreeNode = null;
		node6.val = 7;
		node6.leftTreeNode = node6.rightTreeNode = null;
		node4.leftTreeNode = node5;
		node4.rightTreeNode = node6;
		//二叉树B
		BinaryTreeNode root2 = new BinaryTreeNode();
		root2.val = 8;
		root2.leftTreeNode = root2.rightTreeNode = null;
		BinaryTreeNode node7 = new BinaryTreeNode();
		BinaryTreeNode node8 = new BinaryTreeNode();
		node7.val = 9;
		node7.leftTreeNode = node7.rightTreeNode = null;
		node8.val = 2;
		node8.leftTreeNode = node8.rightTreeNode = null;
		root2.leftTreeNode = node7;
		root2.rightTreeNode = node8;
		
		System.out.println(SubStructureInTree.subStructureInTree(root, root2));
	}

}

//二叉树结构
class BinaryTreeNode {
	int val;
	BinaryTreeNode leftTreeNode;
	BinaryTreeNode rightTreeNode;
}

class SubStructureInTree {
	public static boolean subStructureInTree(BinaryTreeNode pRoot1,BinaryTreeNode pRoot2) {//遍历树，在数A中查找是否存在与树B的根节点值一样的节点
		if(pRoot1 == null && pRoot2 == null) {//二叉树为空，直接返回false
			return false;
		}
		boolean res = false;
		if(pRoot1.val == pRoot2.val) {//找到与B根节点值相同的节点，然后判断子结构是否相同
			res = doesTree1HasTree2(pRoot1, pRoot2);
		} 
		if(!res) //在左子树中寻找
			res = subStructureInTree(pRoot1.leftTreeNode, pRoot2);//遍历左子树，查找与B根节点值相同的节点，然后判断子结构是否相同
		if(!res) //遍历完左子树没有找到对应节点，在右子树中查找
			res = subStructureInTree(pRoot1.rightTreeNode, pRoot2);//遍历右子树，查找与B根节点值相同的节点，然后判断子结构是否相同
		return res;
	}
	
	public static boolean doesTree1HasTree2 (BinaryTreeNode pRoot1,BinaryTreeNode pRoot2) {//判断数A是否包含树B
		if(pRoot2 == null) {//注意这句代码一定要位于最前面，因为在判断B是否在A中的时候，如果达到B的最下一层子节点时，还能继续往下搜索，说明B已经遍历完成，树A中是存在B的，可以直接返回
			return true;
		}
		if(pRoot1 == null) {
			return false;
		}
		if(pRoot1.val != pRoot2.val) {
			return false;
		}
		boolean res1 = doesTree1HasTree2(pRoot1.leftTreeNode,pRoot2.leftTreeNode);
		boolean res2 = doesTree1HasTree2(pRoot1.rightTreeNode,pRoot2.rightTreeNode);
		return res1 && res2;
	}
}
