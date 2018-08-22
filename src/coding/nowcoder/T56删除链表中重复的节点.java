package coding.nowcoder;

/*
 * 题目描述 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class T56删除链表中重复的节点 {
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
	public class Solution {
		public ListNode deleteDuplication(ListNode pHead) {
			ListNode pHeadNew = new ListNode(-1);
			pHeadNew.next = pHead;
			ListNode index = pHead;
			ListNode indexPre = pHeadNew;
			while (index != null)
				if (index.next != null && index.val == index.next.val) {
					index = index.next;
					while (index != null && indexPre.next.val == index.val)
						index = index.next;
					indexPre.next = index;
				} else {
					indexPre = index;
					index = indexPre.next;
				}
			return pHeadNew.next;
		}
	}
}
