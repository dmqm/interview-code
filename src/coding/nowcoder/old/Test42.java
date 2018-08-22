package coding.nowcoder.old;
import java.util.ArrayList;

/*
 * 题目描述
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,
 * 他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck! 输出描述:
 * 
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */

public class Test42 {
	public class Solution {
		public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
			ArrayList<Integer> div = new ArrayList<Integer>();
			ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
			return res;
		}
	}
	public class Solution2 {
		public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
			ArrayList<Integer> div = new ArrayList<Integer>();
			ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
			if (sum < 3)
				return res;
			for (int i = 1; i < Math.sqrt(2 * sum); i++) {
				if (sum % i == 0)
					div.add(i);
			}
			Integer s;
			for (Integer i : div) {
				s = sum / i;
				if (sum % 2 == 1) {
					ArrayList<Integer> temp = new ArrayList<Integer>();
					for (int j = s / 2 - i + 1; j <= s / 2 + i; j++)
						temp.add(j);
					res.add(temp);
					continue;
				}
				if (i % 2 == 1) {
					ArrayList<Integer> temp = new ArrayList<Integer>();
					for (int j = s - i / 2; j <= s + i / 2; j++)
						temp.add(j);
					res.add(temp);
					continue;
				}


			}
			return res;
		}
	}
}
