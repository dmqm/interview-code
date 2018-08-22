package coding.nowcoder.old;
import java.util.ArrayList;
import java.util.Comparator;

// 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
public class Test33 {
	public class Solution {
		public String PrintMinNumber(int[] numbers) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < numbers.length; i++)
				list.add(numbers[i]);
			list.sort(new Comparator<Integer>() {

				@Override
				public int compare(Integer T1, Integer T2) {
					// TODO Auto-generated method stub
					String a = T1.toString();
					String b = T2.toString();
					return (a + b).compareTo(b + a);
				}
			});
			StringBuilder ans = new StringBuilder();
			for (int i = 0; i < numbers.length; i++)
				ans.append(list.get(i));
			return ans.toString();
		}
	}
}
