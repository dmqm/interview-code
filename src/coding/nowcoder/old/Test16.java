package coding.nowcoder.old;
// 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
public class Test16 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution.Merge(getList(), getList());
	}

	public static ListNode getList() {
		ListNode head = null;
		head = new ListNode(1);
		head.next = new ListNode(3);
		head.next.next = new ListNode(5);
		return head;

	}


	public static class Solution {
		public static ListNode Merge(ListNode list1, ListNode list2) {
			ListNode index1 = list1, index2 = list2, old = null;
			if (index1 == null || index2 == null)
				return index1 == null ? index2 : index1;
			while (index1 != null && index2 != null) {
				if (index1.val >= index2.val) {
					old = index2;
					index2 = index2.next;
				}
				else {
					if (old != null) {
						ListNode temp = index1;
						index1 = index1.next;
						old.next = temp;
						temp.next = index2;
						old = temp;
					} else {
						ListNode temp = index1;
						index1 = index1.next;
						temp.next = list2;
						list2 = temp;
						old = list2;
					}
				}
			}
			while (index1 != null) {
				old.next = index1;
				old = index1;
				index1 = index1.next;
			}
			return list2;

		}
	}
}


class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}
