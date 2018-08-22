package coding.nowcoder.old;

// 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
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
		// 注意判定空指针
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
		 * 答案错误:您提交的程序没有通过所有的测试用例 case通过率为0.00%
		 * 
		 * 测试用例: {1,2,3,4,5,3,5,#,2,#}
		 * 
		 * 对应输出应该为:
		 * 
		 * {1,2,3,4,5,3,5,#,2,#}
		 * 
		 * 你的输出为:
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
