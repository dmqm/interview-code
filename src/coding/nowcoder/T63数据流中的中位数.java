package coding.nowcoder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * 题目描述
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class T63数据流中的中位数 {
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
		 * 插入有两种思路： 1：直接插入大堆中，之后若两堆尺寸之差大于1(也就是2)，则从大堆中弹出堆顶元素并插入到小堆中 若两队之差不大于1，则直接插入大堆中即可。
		 * 2：奇数个数插入到大堆中，偶数个数插入到小堆中， 但是 可能会出现当前待插入的数比小堆堆顶元素大，此时需要将元素先插入到小堆，然后将小堆堆顶元素弹出并插入到大堆中
		 * 对于偶数时插入小堆的情况，一样的道理。why? 因为要保证最大堆的元素要比最小堆的元素都要小。
		 * 
		 * @param num
		 */
		public void Insert(Integer num) {
			// 若总尺寸为偶数，则插入大顶堆中
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

		// 堆类，可直接设置最大堆最小堆
		class Heap {
			public List<Integer> list = null;
			public static final boolean isMaxHeap = true;
			public static final boolean isMinHeap = false;
			private boolean flag = true; // true表示最大堆，false表示最小堆

			public Heap() {
				this.list = new ArrayList<Integer>();
			}

			public Heap(boolean flag) {
				this.list = new ArrayList<Integer>();
				this.flag = flag;
			}

			// 获取堆大小
			public int size() {
				return this.list.size();
			}

			// 获取堆顶元素
			public int peek() {
				if (list.size() == 0)
					return 0;
				return list.get(0);
			}

			// 插入元素，从插入点开始向上调整堆
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
			 * 将堆顶元素取出,并重新调整堆。 1>取出堆顶元素 2>将最后一个元素放到堆顶 3>向下调整堆
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

			// 交换list中两个位置的元素
			public void swap(int i, int j) {
				int temp = list.get(i);
				list.set(i, list.get(j));
				list.set(j, temp);
			}
		}
	}
}
