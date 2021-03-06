package coding.nowcoder;

/*
 * 题目描述 输入一个链表，反转链表后，输出链表的所有元素。
 */
public class T15反转链表 {
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
	public class Solution {
		public ListNode ReverseList(ListNode head) {
			if (head == null)
				return head;
			ListNode left = head, right = head.next, temp;
			left.next = null;
			while (right != null) {
				temp = right;
				right = right.next;
				temp.next = left;
				left = temp;
			}
			return left;
		}
	}
}
