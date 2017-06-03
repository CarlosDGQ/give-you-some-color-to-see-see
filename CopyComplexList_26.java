public class CopyComplexList_26 {

	/**
	 * 复制复杂链表，在复杂链表中除了有一个pNext指针指向下一个节点之外，还有一个
	 * pSibing指向链表中的任意节点或者NULL。
	 * 思路：我们可以分步解决。
	 * 第一步：复制链表任意节点N，并创建新节点N',并且将N'链接到N的后面。
	 * 第二步：设置复制出来的节点N'的pSibing，如果节点N的pSibing指向S，则N'的pSibing指向S'.
	 * 第三步：拆分链表。奇数节点为原链表，偶数节点为复制出来的链表。
	 * 因此我们可以分别定义三个函数，分别完成上述功能。
	 */
	public static void main(String[] args) {
		

	}

}

class ComplexListNode {
	int val;
	ComplexListNode pNext;
	ComplexListNode pSibing;
}
class CopyComplexList {
	public static void cloneNode(ComplexListNode head) {
		if(head == null) {
			return;
		}
		ComplexListNode p = head;
		ComplexListNode next = null;
		while (p != null) {
			next = p.pNext;
			ComplexListNode newNode = new ComplexListNode();
			newNode.val = p.val;
			p.pNext = newNode;
			newNode.pNext = next;
			p = next;
		}
	}
	public static void connectSibingNode(ComplexListNode head) {
		if(head == null) {
			return;
		}
		ComplexListNode p = head;
		ComplexListNode next = null;
		while (p != null) {
			next = p.pNext;
			if(p.pSibing == null) {
				next.pSibing = null;
			} else {
				next.pSibing = p.pSibing.pNext;
			}
			p = next.pNext;
		}
	}
	public static ComplexListNode spiltNode(ComplexListNode head) {
		if(head == null)
			return head;
		ComplexListNode newList = head.pNext;
		ComplexListNode p = head;
		while(p != null) {
			ComplexListNode next = p.pNext;
			p.pNext = next.pNext;
			p = next.pNext;
			if(p != null) 
				next.pNext = p.pNext;
			else 
				next.pNext = null;
		}
		return newList;
	}
}
