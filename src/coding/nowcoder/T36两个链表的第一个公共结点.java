package coding.nowcoder;

/*
 * 题目描述 输入两个链表，找出它们的第一个公共结点。
 */
public class T36两个链表的第一个公共结点 {
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
	public class Solution {
		public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
			ListNode index1 = pHead1, index2 = pHead2;
			while (index1 != index2) {
				index1 = index1 == null ? pHead2 : index1.next;
				index2 = index2 == null ? pHead1 : index2.next;
			}
			return index1;
		}
	}
}
