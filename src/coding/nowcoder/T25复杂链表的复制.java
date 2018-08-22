package coding.nowcoder;
/*��Ŀ����
����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩�����ؽ��Ϊ���ƺ��������head����ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�*/
public class T25��������ĸ��� {
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
