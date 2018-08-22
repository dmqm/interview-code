package coding.nowcoder;
/*题目描述
输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）*/
public class T25复杂链表的复制 {
	public class RandomListNode {
	    int label;
	    RandomListNode next = null;
	    RandomListNode random = null;
	    RandomListNode(int label) {
	        this.label = label;
	    }
	}
	public class Solution {
	    public RandomListNode Clone(RandomListNode pHead)
	    {
	        if(pHead==null)
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
}
