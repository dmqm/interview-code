package coding.nowcoder.old;
import java.util.ArrayList;
import java.util.Arrays;

// ����n���������ҳ�������С��K��������������4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4,
public class Test29 {
	public class Solution {
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
