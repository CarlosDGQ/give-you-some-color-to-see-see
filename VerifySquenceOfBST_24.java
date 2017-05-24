public class VerifySquenceOfBST_24 {

	/**
	 * 输入一个整数数组，判断这个数组是不是某二叉搜索树的后序遍历序列。若是返回true，
	 * 不是返回false。假设输入的数组任意两个数字都不同。
	 * 思路：在后序遍历序列中最后一个数字是根节点的值，数组中前面的部分可以分为两部分：第一部分是左子树节点的值
	 * 他们都比根节点的值小，第二部分是右子树节点的值，他们都比根节点的值大。
	 * 举个例子：以数组{5,7,6,9,11,10,8}为例，8是根节点的值，在前面的数字之中，前三个数字都比根节点的值要小，
	 * 后三个数字都比根节点的值要大。这样可以把前面的部分划分为两个部分，分别为8的左子树和右子树的节点；
	 * 接下来我们可以用相同的方式来确定数组的每一部分对应的子树，显然这是一个递归的过程。
	 */
	public static void main(String[] args) {
		int[] sequence = {5,7,6};
		boolean res = VerifySquenceOfBST.verifySquenceOfBST(sequence, 0, sequence.length - 1);
		System.out.println(res);
	}
}

class VerifySquenceOfBST {
	public static boolean verifySquenceOfBST(int[] sequence, int start ,int end) {
		if(sequence == null || start < 0 || end < 0 || end > sequence.length || start > end)
			return false;
		if(end <= start)//递归结束条件，记住，最终如果end和start重合，也就是一个节点的时候，说明前面的都是BST，直接返回true即可
			return true;
		int root = sequence[end];//序列的最后一个元素为根元素
		int i = start;
		for(; i < end; i++) {
			if(sequence[i] > root) {
				break;
			}
		}
		int j = i;
		for(; j < end; j++) {
			if(sequence[j] < root) {//后半部分数组，如果出现比根节点小的值，则一定不是BST
				return false;
			}
		}
		boolean left = true;
		boolean right = true;
		//判断前半部分数组是否是BST
		left = verifySquenceOfBST(sequence, start, i - 1);
		//判断后半部分数组是否是BST
		right = verifySquenceOfBST(sequence, i, end - 1) ;
		return left&&right;
	}
}
