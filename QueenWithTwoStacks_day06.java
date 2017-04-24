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
	 *扩展：使用两个队列实现栈
	 *思路：入栈操作:若队列1和队列2都为空则压入队列1；若队列2不为空则将元素压入队列2；否则压入队列1.
	 *	      出栈操作：队列1和队列2都没有元素，返回一个负数；
	 *			队列2中是否有元素，有则留下一个元素，其余的元素放入队列1，出队列2的最后一个元素；
	 *			队列2没有元素，队列1中的元素留下一个，其余的元素出队列到队列2，队列1的最后一个元素出队列。
	 *思路来源：举个简单的例子理解一下：
	 *比如现在有三个元素a,b,c要入栈，我们可以将他们全部放入队列1中，在出栈的时候，本来应该是最后入栈的元素c先出，
	 * 但是由于队列的先进先出的特性，我们只能渠道队列1的队头元素a，我们发现队列2还没有使用，可以将队列1的元素a,b先出队列，放入
	 * 队列2中，然后删除队列1的队头元素c；就完成了出栈的操作。在下次入栈的时候，直接将元素放入非空队列就可以了，但是在出栈的时候，
	 * 需要先判断队列2中是否有元素，若队列2中元素的个数大于1，则只留一个元素在队列2中，其余的元素全部放入队列1，然后队列2中最后一个元素
	 * 出队列；若队列2中的元素个数等于1，直接出队列即可。
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackWithTwoQueun stackWithTwoQueun = new StackWithTwoQueun();
		stackWithTwoQueun.push(0);
		stackWithTwoQueun.push(1);
		System.out.println(stackWithTwoQueun.pop());
	}
}
//使用两个栈实现队列
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

//使用两个队列实现栈
class StackWithTwoQueun {
	LinkedList<Integer> queue1 = new LinkedList<Integer>();
	LinkedList<Integer> queue2 = new LinkedList<Integer>();
	//入栈
	public void push(int node) {
		if(queue1.size() == 0 && queue2.size() == 0) {
			queue1.offer(node);
		}
		if(queue2.size() != 0) {
			queue2.offer(node);
		} else {
			queue1.offer(node);
		}	
	}
	//出栈
	public int pop() {
		if(queue1.size() == 0 && queue2.size() == 0) {//两个队列中不存在元素
			return -9999999;
		}
		if(queue2.size() != 0) {//队列2不为空，在队列2中只留下一个元素，其余的元素出队列到队列1
			int size = queue2.size();//注意：poll删除元素之后，size会发生变化
			for(int i = 0; i < size - 1; i++) {
				queue1.offer(queue2.poll());
			}
			return queue2.poll();//队列2中的最后一个元素出队列
		} else { //队列2为空，队列1不为空，将队列1中的元素留下一个，其余的元素出队列到队列2
			int size = queue1.size();//注意：poll删除元素之后，size会发生变化
			for(int i = 0; i < size - 1; i++) {
				queue2.offer(queue1.poll());
			}
			return queue1.poll();//队列1中最后一个元素出队列
		} 
	}
}
