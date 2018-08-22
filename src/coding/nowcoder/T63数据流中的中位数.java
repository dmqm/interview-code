package coding.nowcoder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * ��Ŀ����
 * ��εõ�һ���������е���λ����������������ж�����������ֵ����ô��λ������������ֵ����֮��λ���м����ֵ��������������ж���ż������ֵ����ô��λ������������ֵ����֮���м���������ƽ��ֵ��
 */
public class T63�������е���λ�� {
	public class Solution {
		LinkedList<Integer> list = new LinkedList<Integer>();

		public void Insert(Integer num) {
			if (list.size() == 0 || num < list.getFirst()) {
				list.addFirst(num);
			} else {
				boolean insertFlag = false;
				for (Integer e : list) {
					if (num < e) {
						int index = list.indexOf(e);
						list.add(index, num);
						insertFlag = true;
						break;
					}
				}
				if (!insertFlag) {
					list.addLast(num);
				}
			}
		}

		public Double GetMedian() {
			if (list.size() == 0) {
				return null;
			}
			if (list.size() % 2 == 0) {
				int i = list.size() / 2;
				Double a = Double.valueOf(list.get(i - 1) + list.get(i));
				return a / 2;
			}
			list.get(0);
			Double b = Double.valueOf(list.get((list.size() + 1) / 2 - 1));
			return Double.valueOf(list.get((list.size() + 1) / 2 - 1));
		}
	}

	public class Solution2 {
		private Heap maxHeap = new Heap(Heap.isMaxHeap);
		private Heap minHeap = new Heap(Heap.isMinHeap);

		/**
		 * ����������˼·�� 1��ֱ�Ӳ������У�֮�������ѳߴ�֮�����1(Ҳ����2)����Ӵ���е����Ѷ�Ԫ�ز����뵽С���� ������֮�����1����ֱ�Ӳ������м��ɡ�
		 * 2�������������뵽����У�ż���������뵽С���У� ���� ���ܻ���ֵ�ǰ�����������С�ѶѶ�Ԫ�ش󣬴�ʱ��Ҫ��Ԫ���Ȳ��뵽С�ѣ�Ȼ��С�ѶѶ�Ԫ�ص��������뵽�����
		 * ����ż��ʱ����С�ѵ������һ���ĵ���why? ��ΪҪ��֤���ѵ�Ԫ��Ҫ����С�ѵ�Ԫ�ض�ҪС��
		 * 
		 * @param num
		 */
		public void Insert(Integer num) {
			// ���ܳߴ�Ϊż���������󶥶���
			if (((maxHeap.size()) & 1) == 0) {
				if (minHeap.size() != 0 && num > minHeap.peek()) {
					minHeap.add(num);
					maxHeap.add(minHeap.pop());
				} else {
					maxHeap.add(num);
				}
			} else {
				if (maxHeap.size() != 0 && num < maxHeap.peek()) {
					maxHeap.add(num);
					minHeap.add(maxHeap.pop());
				} else {
					minHeap.add(num);
				}
			}
		}

		public Double GetMedian() {
			double res = 0.0;
			if (((maxHeap.size()) & 1) == 0) {
				res = (maxHeap.peek() + minHeap.peek()) / 2.0;
			} else {
				res = maxHeap.peek();
			}
			return res;
		}

		// ���࣬��ֱ������������С��
		class Heap {
			public List<Integer> list = null;
			public static final boolean isMaxHeap = true;
			public static final boolean isMinHeap = false;
			private boolean flag = true; // true��ʾ���ѣ�false��ʾ��С��

			public Heap() {
				this.list = new ArrayList<Integer>();
			}

			public Heap(boolean flag) {
				this.list = new ArrayList<Integer>();
				this.flag = flag;
			}

			// ��ȡ�Ѵ�С
			public int size() {
				return this.list.size();
			}

			// ��ȡ�Ѷ�Ԫ��
			public int peek() {
				if (list.size() == 0)
					return 0;
				return list.get(0);
			}

			// ����Ԫ�أ��Ӳ���㿪ʼ���ϵ�����
			public void add(int val) {
				this.list.add(val);
				int i = list.size() - 1, index, parent, cur;
				while (i > 0) {
					index = (i - 1) / 2;
					parent = list.get(index);
					cur = list.get(i);
					if (flag == true && parent < cur) {
						swap(index, i);
					} else if (flag == false && parent > cur) {
						swap(index, i);
					}
					i = index;
				}
			}

			/**
			 * ���Ѷ�Ԫ��ȡ��,�����µ����ѡ� 1>ȡ���Ѷ�Ԫ�� 2>�����һ��Ԫ�طŵ��Ѷ� 3>���µ�����
			 */
			public int pop() {
				if (list.size() == 0)
					return -1;
				int res = list.get(0);
				list.set(0, list.get(list.size() - 1));
				list.remove(list.size() - 1);
				int len = list.size() - 1, i = 0;
				int left, right;
				while (i < len) {
					left = (i << 1) + 1;
					right = (i << 1) + 2;
					int maxIndex = i;
					if (flag == true) {
						if (left < len && list.get(left) > list.get(maxIndex))
							maxIndex = left;
						if (right < len && list.get(right) > list.get(maxIndex))
							maxIndex = right;
					} else {
						if (left < len && list.get(left) < list.get(maxIndex))
							maxIndex = left;
						if (right < len && list.get(right) < list.get(maxIndex))
							maxIndex = right;
					}
					if (maxIndex != i) {
						swap(maxIndex, i);
						i = maxIndex;
					} else
						break;
				}
				return res;
			}

			// ����list������λ�õ�Ԫ��
			public void swap(int i, int j) {
				int temp = list.get(i);
				list.set(i, list.get(j));
				list.set(j, temp);
			}
		}
	}
}
