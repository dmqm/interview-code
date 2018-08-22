package coding.nowcoder.old;

// ����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩�����ؽ��Ϊ���ƺ��������head����ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
public class Test25 {
	public class RandomListNode {
		int label;
		RandomListNode next = null;
		RandomListNode random = null;

		RandomListNode(int label) {
			this.label = label;
		}
	}
	public class Solution {
		// ע���ж���ָ��
		public RandomListNode Clone(RandomListNode pHead) {
			if (pHead == null)
				return null;
			RandomListNode index = pHead;
			while (null != index) {
				RandomListNode node = new RandomListNode(index.label);
				node.next = index.next;
				index.next = node;
				index = index.next.next;
			}
			index = pHead;
			while (null != index) {
				if (index.random != null)
					index.next.random = index.random.next;
				index = index.next.next;
			}
			RandomListNode res = pHead.next;
			index = pHead;
			RandomListNode indexC = res;
			while (null != index) {
				index.next = index.next.next;
				if (indexC.next != null)
					indexC.next = indexC.next.next;
				index = index.next;
				indexC = indexC.next;
			}
			return res;
		}
	}
	public class Solution2 {
		/*
		 * �𰸴���:���ύ�ĳ���û��ͨ�����еĲ������� caseͨ����Ϊ0.00%
		 * 
		 * ��������: {1,2,3,4,5,3,5,#,2,#}
		 * 
		 * ��Ӧ���Ӧ��Ϊ:
		 * 
		 * {1,2,3,4,5,3,5,#,2,#}
		 * 
		 * ������Ϊ:
		 * 
		 * java.lang.NullPointerException
		 */
		public RandomListNode Clone(RandomListNode pHead) {
			if (pHead == null)
				return null;
			RandomListNode index = pHead;
			RandomListNode newHead = new RandomListNode(index.label);
			RandomListNode newIndex = newHead;
			index = index.next;
			while (null != index) {
				newIndex.next = new RandomListNode(index.label);
				index = index.next;
				newIndex = newIndex.next;
			}
			index = pHead;
			newIndex = newHead;
			RandomListNode posNode;
			int pos = 0;
			while (null != index) {
				pos = getIndex(index.random, pHead);
				posNode = newHead;
				while (pos > 0)
					posNode = posNode.next;
				newIndex.random = posNode;
				index = index.next;
				newIndex = newIndex.next;
			}
			return newHead;
		}

		public int getIndex(RandomListNode desNode, RandomListNode pHead) {
			int res = 0;
			RandomListNode index = pHead;
			while (null != index && desNode != index) {
				res++;
				index = index.next;
			}
			return index == desNode ? res : -1;
		}
	}
}
