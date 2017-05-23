public class IsPopOrder_22 {

	/**
	 * 输入两个整数序列，第一个序列表示栈的压入顺序，第二个表示栈的出栈顺序，假设
	 * 压入栈的所有数字都不想等。判断第二个序列是否是该栈的出栈顺序。
	 * 思路：例子分析。例如1,2,3,4,5是入栈的顺序，4,5,3,2,1是出栈顺序。
	 * 由于4要先出栈，则需要将1,2,3,4分别压入栈，4出栈之后，栈顶元素是3，不是下一个要出栈的元素
	 * 所以需要将5入栈，入栈之后，然后出栈，由于之后希望被弹出的数据是3,2,1，每次操作前它们都位于栈顶
	 * 因此直接出栈即可。
	 * 接下来分出栈顺序4,3,5,1,2.第一个弹出的数据4和前面的一样，由于弹出4之后，栈顶的元素是3，是与下一个要出
	 * 栈的元素相同，我们可以直接出栈，在3出栈之后，栈顶元素是2，与下一个要出栈的元素不同，下一个要出栈的元素是5，所以
	 * 我们需要把压栈序列中数字压入栈，直到遇到5，此后栈顶元素是2，但是要出栈的元素是1，此时我们需要将入栈序列入栈，直到遇到
	 * 1，但是我们发现入栈序列已经全部入栈了，所以我们可以得到此出栈序列4,3,5,1,2不是1,2,3,4,5的弹出序列。
	 * 
	 * 总结：定义一个辅助栈，每次查看辅助栈的栈顶元素是否是出栈序列中当前要出栈的元素，如果是则直接出栈，
	 * 如果不是，将入栈序列入栈，直到遇到当前要出栈的元素为止，如果在入栈过程中发现入栈序列所有数组都已经入栈了也没有找到
	 * 当前要出栈的元素，说明当前出栈序列不是入栈序列的弹出序列。
	 */
	public static void main(String[] args) {
		

	}

}

class IsPopOrder {
	Stack<Integer> stack = new Stack<Integer>();
	public  boolean isPopOrder(int[] pushOrder, int[] popOrder) {
		if(popOrder == null || pushOrder == null) {
			return false;
		}
		int count = 0;
		stack.push(pushOrder[count++]);
		for(int i = 0; i < popOrder.length; i++) {
			int current = popOrder[i];
			while(current != stack.peek()) {//当前要出栈的元素不是栈顶元素
				if(count == pushOrder.length) {//入栈序列已经全部入栈，还没有找到当前要出栈的元素
					return false;
				}
				stack.push(pushOrder[count++]);
			}
			stack.pop();//当前要出栈的元素不是栈顶元素，直接出栈
		}
		return true;
	}
}
