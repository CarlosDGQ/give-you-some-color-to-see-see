public class FindPath_25 {

	/**
	 * 输入一个二叉树和一个整数，打印二叉树中节点值的和为输入的整数的所有路径。从树的根节点开始往下
	 * 一直到叶节点所经过的所有节点形成一条路径。
	 * 思路：前序遍历加上回溯。
	 * 当用前序遍历访问某一个节点的时候，将该节点添加到路径之中，并且累加该节点的值，如果该节点为叶节点并且
	 * 路径之中的累加值刚好等于输入的整数，则当前路径符合要求，我们将它打印出来。如果当前节点不是叶节点，则继续
	 * 访问它的子节点，当访问结束后，递归函数将自动返回父节点，因此我们需要在函数退出前将路径之中的当前节点删除并且
	 * 减去当前的值。
	 */
	public static void main(String[] args) {
		int target = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入整数值：");
		target = scanner.nextInt();
		
		BinaNode root = new BinaNode();
		root.val = 10;
		root.left = null;
		root.right = null;
		
		BinaNode node1 = new BinaNode();
		node1.val = 5;
		node1.left = null;
		node1.right = null;
		
		BinaNode node2 = new BinaNode();
		node2.val = 12;
		node2.left = null;
		node2.right = null;
		
		BinaNode node3 = new BinaNode();
		node3.val = 4;
		node3.left = null;
		node3.right = null;
		
		BinaNode node4 = new BinaNode();
		node4.val = 7;
		node4.left = null;
		node4.right = null;
		
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		
		FindPath.findPath(root, target);
	}
}

class BinaNode {
	int val;
	BinaNode left;
	BinaNode right;
}

class FindPath {
	public static void findPath(BinaNode root, int target) {
		if(root == null) {
			return;
		}
		Stack<BinaNode> path = new Stack<BinaNode>();
		findPath(path, root, target, 0);
	}
	public static void findPath(Stack<BinaNode> path, BinaNode root, int target, int current) {
		if(root == null) {
			return;
		}
		path.push(root);
		current += root.val;
		//打印路径
		if(root.left == null && root.right == null && current == target) {
			for(int i = 0; i < path.size(); i++) {
				BinaNode node = path.get(i);
				System.out.print(node.val+" ");
			}
			System.out.println();
		} 
		if(root.left != null) {//遍历左子树节点
			findPath(path, root.left, target, current);
		}
		if(root.right!= null) {//遍历右子树节点
			findPath(path, root.right, target, current);
		}
		path.pop();//递归函数退出之后自动回到父节点。在回到父节点之前，需要将当前节点从路径之中删除
	}
}
