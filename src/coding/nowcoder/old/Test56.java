package coding.nowcoder.old;

import java.util.ArrayList;

/* һ�������а����������ҳ�������Ļ�����ڽ�㡣 */
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
