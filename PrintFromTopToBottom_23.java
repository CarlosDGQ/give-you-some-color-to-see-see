public class PrintFromTopToBottom_23 {

	/**
	 * 从上到下打印二叉树。
	 * 树的层次遍历（不需要递归，循环加上队列解决）
	 * 思路：每次打印一个子节点的时候，如果该节点有子节点，则将子节点放入队列的末尾；
	 * 接下来取出队列头部最早进入队列的节点，重复上面的节点打印操作，直到所有的节点被
	 * 打印出来为止（队列为空为止）。
	 */
	public static void main(String[] args) {
		//二叉树A
		BinaryNode root = new BinaryNode();
		root.val = 8;
		root.left = root.right = null;
		BinaryNode node1 = new BinaryNode();
		BinaryNode node2 = new BinaryNode();
		node1.val = 8;
		node1.left = node1.right = null;
		node2.val = 7;
		node2.left = node2.right = null;
		root.left = node1;
		root.right = node2;
		BinaryNode node3 = new BinaryNode();
		BinaryNode node4 = new BinaryNode();
		node3.val = 9;
		node3.left = node3.right = null;
		node4.val = 2;
		node4.left = node4.right = null;
		node1.left = node3;
		node1.right = node4;
		BinaryNode node5 = new BinaryNode();
		BinaryNode node6 = new BinaryNode();
		node5.val = 4;
		node5.left = node5.right = null;
		node6.val = 7;
		node6.left = node6.right = null;
		node4.left = node5;
		node4.right = node6;
		
		PrintFromTopToBottom printFromTopToBottom = new PrintFromTopToBottom();
		printFromTopToBottom.printFromTopToBottom(root);

	}

}
class BinaryNode {
	int val;
	BinaryNode left;
	BinaryNode right;
}
class PrintFromTopToBottom {
	
	public  void  printFromTopToBottom(BinaryNode root) {
		ArrayList<BinaryNode> list = new ArrayList<BinaryNode>();
		if(root == null) {
			return;
		}
		list.add(root);
		while (list.size() != 0) {
			BinaryNode node = list.get(0);
			System.out.println(node.val);//打印当前节点
			list.remove(0);//出队列
			if(node.left != null) {//将当前节点的左节点加入队列
				list.add(node.left);
			}
			if(node.right != null) {//将当前节点的左节点加入队列
				list.add(node.right);
			}
		}
	}
}
