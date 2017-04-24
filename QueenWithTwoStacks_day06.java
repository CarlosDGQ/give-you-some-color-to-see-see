public class QueenWithTwoStacks_day06 {

	/**
	 * 使用两个栈实现队列。
	 * 思路：入队列的时候都放入栈1中，在出队列的时候首先判断栈2中是否有元素，有则直接出；
	 * 没有则将栈1的元素全部放入栈2之中，然后出栈。
	 * 思路来源：根据一个实际的例子，比如a,b,c三个元素入队列，我们将他们全部放入栈1之中，在出队列的时候，根据
	 * 队列先进先出的特性，应该是a先出来，但是a在栈1的底部，无法取出；我们发现栈2还没有使用，可以将栈1的元素全部出栈，放入
	 * 栈2之中，这时候a位于栈2的顶部，可以直接出栈。在下次入队列的时候，直接加入栈1就可以了，但是出队列的时候需要判断栈2是否
	 * 为空，不为空则直接从栈2中出栈即可，若为空，则需要将栈1的元素全部出栈到栈2中，然后去栈2的栈顶元素，完成出队列操作。
	 *
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}

class QueenWithTwoStacks {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
	//入队列
	public void push(int node) {
		stack1.push(node);
	}
	//出队列
	public int pop() {
		if(!stack2.empty()) {//如果栈2不为空,直接出
			return stack2.pop();
		} else {//若栈2为空
			while (!stack1.empty()) {//将栈1的元素全部出栈放入栈2之中
				stack2.push(stack1.pop());
			}
			//取栈2的栈顶元素
			return stack2.pop();
		}
	}
}
