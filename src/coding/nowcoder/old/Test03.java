package coding.nowcoder.old;
import java.util.ArrayList;

// ����һ��������β��ͷ��ӡ����ÿ���ڵ��ֵ��
public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class Solution {
		public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
			ListNode index = listNode;
			ArrayList<Integer> res = new ArrayList<Integer>();
			while (index != null) {
				res.add(0, index.val);
				index = index.next;
			}
			return res;

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
