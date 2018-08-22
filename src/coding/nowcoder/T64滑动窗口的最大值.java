package coding.nowcoder;

/*
 * 题目描述
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6
 * ,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
import java.util.ArrayList;

public class T64滑动窗口的最大值 {
	public class Solution {
		public ArrayList<Integer> maxInWindows(int[] num, int size) {
			int count = num.length - size, maxIndex;
			ArrayList<Integer> res = new ArrayList<Integer>();
			if (size == 0 || count < 0)
				return res;
			if (count == 0) {
				res.add(num[getMax(num, 0, num.length - 1)]);
				return res;
			}
			maxIndex = getMax(num, 0, size - 1);
			res.add(num[maxIndex]);
			for (int i = 1; i <= count; i++) {
				if (maxIndex != i - 1) {
					if (num[maxIndex] <= num[i + size - 1])
						maxIndex = i + size - 1;
					res.add(num[maxIndex]);
				} else {
					maxIndex = getMax(num, i, i + size - 1);
					res.add(num[maxIndex]);
				}
			}
			return res;
		}

		public int getMax(int[] num, int strIndex, int endIndex) {
			int index = strIndex;
			for (int i = strIndex + 1; i <= endIndex; i++)
				if (num[i] >= num[index])
					index = i;
			return index;
		}
	}
}
