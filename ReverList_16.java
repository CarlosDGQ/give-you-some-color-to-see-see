public class ReverList_16 {

	/**
	 * 反转链表
	 * 思路：定义三个指针，分别指向当前节点，当前节点的前一个节点、以及后一个节点。
	 * 特殊情况：需要考虑
	 * 1.链表为空
	 * 2.只有一个节点
	 */
	public static void main(String[] args) {
		NodeList node1 = new NodeList();
		node1.val = 1;
		node1.next = null;
		/*
		NodeList node2 = new NodeList();
		node2.val = 4;
		NodeList node3 = new NodeList();
		node3.val = 5;
		NodeList node4 = new NodeList();
		node4.val = 0;
		node4.next = null;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		*/
		NodeList headList = ReverList.reverList(node1);
		while(headList != null) {
			System.out.println(headList.val);
			headList = headList.next;
		}

	}

}

class NodeList {
	int val;
	NodeList next;
}

class ReverList {
	
	public static NodeList reverList(NodeList head) {
		if(head == null) { //空链表
			return null;
		}
		if(head.next == null) {//只有一个节点
			return head;
		}
		NodeList pre = head;
		NodeList p = head.next;
		NodeList later = p.next;
		pre.next = null;
		while(p != null) {
			p.next = pre;
			pre = p;
			p = later;
			if(later != null) 
				later = later.next;
		}
		return pre;
		
	}
} 
