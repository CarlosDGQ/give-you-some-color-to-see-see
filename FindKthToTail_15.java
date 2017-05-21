public class FindKthToTail_15 {

	/**
	 * 得到链表中倒数第k个节点。
	 * 思路：使用两个指针，开始时都指向链表的头结点；然后第一个指针向后移动k - 1个节点之后；
	 * 第二个指针开始向后移动，直到第一个指针达到链表最后。
	 * 特别注意代码的鲁棒性：
	 * 1.k需要大于0
	 * 2.k需要小于等于链表的长度
	 * 3.链表不能为空。
	 */
	public static void main(String[] args) {
		Node1 node1 = new Node1();
		node1.val = 1;
		Node1 node2 = new Node1();
		node2.val = 4;
		Node1 node3 = new Node1();
		node3.val = 5;
		Node1 node4 = new Node1();
		node4.val = 0;
		node4.next = null;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		Node1 node = FindKthToTail.findKthToTail(3, node1);
		if(node != null) {
			System.out.println(node.val);
		}
		
	}

}

class Node1{
	int val;
	Node1 next;
}

class FindKthToTail {
	public static Node1 findKthToTail(int k, Node1 head) {
		Node1 pNode1 = head;
		if(k <= 0 || head == null) {//链表为空或者k小于等于0，直接返回null
			return null;
		}
		int length = 0;//链表长度
		while(pNode1 != null) {
			length++;
			pNode1 = pNode1.next;
		}
		if(k > length) {//k大于链表的长度，直接返回null
			return null;
		}
		
		Node1 p1 = head;
		Node1 p2 = head;
		for(int i = 1; i <= k - 1; i++) {
			p1 = p1.next;//向后走k-1步
		}
		while(p1.next != null) {//p1没有到达链表尾
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}
}
