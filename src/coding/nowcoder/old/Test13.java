package coding.nowcoder.old;
// 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
public class Test13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class Solution {
		public void reOrderArray(int[] array) {
			int index1 = 0, index2 = 0, temp;
			while (index2 < array.length) {
				if (array[index2] % 2 == 0)
					index2++;
				else {
					temp = array[index2];
					for (int i = index2; i > index1; i--)
						array[i] = array[i - 1];
					array[index1] = temp;
					index1++;
					index2++;

				}
			}
		}
	}

}
