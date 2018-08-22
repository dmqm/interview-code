package coding.nowcoder.old;
// 输入两个链表，找出它们的第一个公共结点。
public class Test37 {
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
	public class Solution2 {
		public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
			if (pHead1 == null || pHead2 == null)
				return null;
			int len1 = 0, len2 = 0;
			ListNode index1 = pHead1, index2 = pHead2;
			while (index1.next != null) {
				index1 = index1.next;
				len1++;
			}
			while (index2.next != null) {
				index2 = index2.next;
				len2++;
			}
			index1 = pHead1;
			index2 = pHead2;
			if (len1 > len2)
				index1 = FindIndex(index1, len1 - len2);
			else if (len2 > len1)
				index2 = FindIndex(index2, len2 - len1);
			while (index1 != index2 && index1 != null && index2 != null) {
				index1 = index1.next;
				index2 = index2.next;
			}
			return index1;

		}

		public ListNode FindIndex(ListNode tar, int index) {
			while (index > 0) {
				tar = tar.next;
				index--;
			}
			return tar;
		}
	}
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
}
