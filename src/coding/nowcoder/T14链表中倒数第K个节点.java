package coding.nowcoder;

/*
 * 题目描述 输入一个链表，输出该链表中倒数第k个结点。
 */
public class T14链表中倒数第K个节点 {
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
	public class Solution {
		public ListNode FindKthToTail(ListNode head, int k) {
			if (k < 0)
				return null;
			ListNode index1 = head, index2 = head;
			for (int i = 0; i < k; i++) {
				if (index1 == null)
					return null;
				index1 = index1.next;
			}
			while (index1 != null) {
				index1 = index1.next;
				index2 = index2.next;
			}
			return index2;
		}
	}
}
