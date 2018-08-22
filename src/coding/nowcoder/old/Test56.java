package coding.nowcoder.old;

import java.util.ArrayList;

/* 一个链表中包含环，请找出该链表的环的入口结点。 */
public class Test56 {

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
	public class Solution {
		public ListNode EntryNodeOfLoop(ListNode pHead) {
			return pHead;

		}
	}
	public class Solution2 {
		public ListNode EntryNodeOfLoop(ListNode pHead) {
			if (pHead == null || pHead.next == null)
				return null;
			ArrayList<ListNode> al = new ArrayList<ListNode>();
			ListNode index = pHead;
			while (index != null) {
				if (al.contains(index))
					return index;
				al.add(index);
				index = index.next;
			}
			return null;
		}
	}
}
