public class DeleteNodeInList_13 {

	/**
	 * 在O(1)时间复杂度内删除链表中给定的节点
	 * 思路：将要删除的节点的后一个节点的值复制给要删除的节点，然后将要删除的节点的next指针指向
	 * next的next。
	 * 特殊情况：1.只有一个节点，直接删除
	 * 		  2.要删除的节点是尾，只能遍历链表，找到尾节点的前一个节点
	 * 时间复杂度：删除的节点在n-1个节点之中（非尾节点），O(1)；删除尾节点O(n)
	 * 平均时间复杂度：((n - 1)*O(1) + O(n)) / n = O(1),常数时间复杂度，满足要求
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NodeLi head = new NodeLi(1,null);
		NodeLi node1 = new NodeLi(2, null);
		head.nextNode = node1;
		DeleteNodeInList.deleteNodeInList(head, head);
		while (head != null) {
			System.out.println(head.value);
			head = head.nextNode;
		}
	}

}
//节点定义
class NodeLi {
	int value;
	NodeLi nextNode;
	public NodeLi(int value, NodeLi nextNode) {
		this.value = value;
		this.nextNode = null;
	}
}

class DeleteNodeInList {
	public static NodeLi deleteNodeInList(NodeLi head, NodeLi toBeDel) {
		NodeLi p = head;
		//只有一个节点而且要删除的节点是头结点
		if(p.nextNode == null && toBeDel == p) {
			p = toBeDel = null;
		} else if(toBeDel.nextNode == null) {//要删除的节点是尾节点
			while(p.nextNode != toBeDel) {//找到尾节点的前一个节点
				p = p.nextNode;
			}
			p.nextNode = null;
		} else {//删除的节点非尾节点
			toBeDel.value = toBeDel.nextNode.value;
			toBeDel.nextNode = toBeDel.nextNode.nextNode;
		}
		return p;
	}
}
