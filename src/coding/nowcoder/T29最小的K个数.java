package coding.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * 题目描述 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class T29最小的K个数 {
	public class Solution {
		public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
			ArrayList<Integer> result = new ArrayList<Integer>();
			if (input == null || input.length == 0 || input.length < k) {
				return result;
			}
			// 构建大顶堆
			for (int i = k / 2 - 1; i >= 0; i--) {
				adjustHeap(input, i, k - 1);
			}
			// 我们前k个元素的大顶堆已经构建好了，剩下的就是其余的和大顶堆的最大值比较了
			for (int i = k; i < input.length; i++) {
				if (input[i] < input[0]) {
					int temp = input[i];
					input[i] = input[0];
					input[0] = temp;
					adjustHeap(input, 0, k - 1);
				}
			}
			// 我们将调整好的前k个数放进链表里面
			for (int i = 0; i < k; i++) {
				result.add(input[i]);
			}
			return result;
		}

		// 构建大顶堆,这个经典
		public void adjustHeap(int[] input, int i, int k) {
			// 先把最上面根节点保存了
			int temp = input[i];
			for (int j = i * 2 + 1; j <= k; j = j * 2 + 1) {
				// j可以等于k，但是下面的程序不能，我们还要判断j和j+1呢
				if (j < k && input[j] < input[j + 1]) {
					j++;
				}
				if (temp > input[j]) {
					break;
				}
				input[i] = input[j];
				i = j;
			}
			input[i] = temp;
		}
	}
	public class Solution2 {
		public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
			ArrayList<Integer> des = new ArrayList<Integer>();
			if (input.length < k)
				return des;
			Arrays.sort(input);
			for (int i = 0; i < k; i++)
				des.add(input[i]);
			return des;
		}
	}
}
