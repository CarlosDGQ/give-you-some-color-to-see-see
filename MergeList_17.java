public class MergeList_17 {

	/**
	 * 合并两个有序的递增链表，使合并之后的链表仍是有序的。
	 * 思路：我们首先分析合并的过程，合并两个链表从链表的头结点开始，如果链表1的头结点小于链表2
	 * 的头结点，则链表1的头节点是合并之后的链表的头结点；在剩余的节点中（相当于去下了链表1的头结点），继续进行相同的比较
	 * 递归。
	 */
	public static void main(String[] args) {
		ListNode node1 = new ListNode();
		node1.val = 1;
		ListNode node2 = new ListNode();
		node2.val = 2;
		ListNode node3 = new ListNode();
		node3.val = 3;
		ListNode node4 = new ListNode();
		node4.val = 6;
		node4.next = null;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		ListNode node5 = new ListNode();
		node5.val = 2;
		ListNode node6 = new ListNode();
		node6.val = 4;
		ListNode node7 = new ListNode();
		node7.val = 6;
		ListNode node8 = new ListNode();
		node8.val = 9;
		node8.next = null;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		
		ListNode head = MergeList.mergeList(node1, node5);
		
		while(head.next != null) {
			System.out.println(head.val);
			head = head.next;
		}
		

	}

}

class ListNode {
	int val;
	ListNode next;
}

class MergeList {
	public static ListNode mergeList(ListNode head1,ListNode head2) {
		if(head1 == null && head2 == null) {
			return null;
		}
		if(head1 == null) {
			return head2;
		}
		if(head2 == null) {
			return head1;
		}
		ListNode meList = null;
		if(head1.val < head2.val) {
			meList = head1;
			meList.next = mergeList(head1.next, head2);
		} else {
			meList = head2;
			meList.next = mergeList(head1, head2.next);
		}
		return meList;
	}
}
