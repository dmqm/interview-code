package coding.nowcoder.old;
// 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
public class Test23 {
	public class Solution {
		public boolean VerifySquenceOfBST(int[] sequence) {
			int size = sequence.length;
			if (size == 0)
				return false;
			if (size == 1)
				return true;
			return FoundMid(sequence, 0, size - 1);
		}

		public boolean FoundMid(int[] seq, int left, int right) {
			if (left >= right)
				return true;
			int root = seq[right];
			while (seq[left] < root && left < right) {
				left++;
			}
			int mid = left - 1;
			while (left < right) {
				if (seq[left] < root)
					return false;
				left++;
			}
			return FoundMid(seq, left, mid) && FoundMid(seq, mid + 1, right - 1);
		}
	}
}
