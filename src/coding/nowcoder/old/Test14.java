package coding.nowcoder.old;
// 输入一个链表，输出该链表中倒数第k个结点。
public class Test14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public class Solution {
		public ListNode FindKthToTail(ListNode head, int k) {
			ListNode index1 = head, index2 = head;
			for (int i = 0; i < k; i++) {
				if (index1 == null)
					return index1;
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
