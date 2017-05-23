public class MinInStack_21 {

	/**
	 * 包含min函数的栈。
	 * 定义一个栈的数据结构，在该类型中实现一个能够得到栈的最小元素的min函数，在该栈中
	 * pop、push、min的时间复杂度都是O(1)
	 * 思路：定义一个辅助栈。
	 * 如果每次将最小的元素压入辅助栈，就能保证辅助栈的栈顶一直都是最小值，当最小元素
	 * 被弹出栈之后，同时弹出辅助栈的栈顶元素，此时辅助栈的栈顶元素就是下一个最小值。
	 */
	public static void main(String[] args) {

	}

}

class MinStack {
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();
	
	public void push(int item) {
		stack.push(item);
		if(minStack.size() == 0) {
			minStack.push(item);
		} else if(item < minStack.peek()) {//如果当前入栈的元素比辅助栈的栈顶元素小
			minStack.push(item);
		} else {
			minStack.push(minStack.peek());
		}
	}
	public int pop() {
		minStack.pop();
		return stack.pop();
	}
	public int min() {
		return minStack.peek();
	}
}
