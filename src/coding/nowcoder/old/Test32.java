package coding.nowcoder.old;
import java.util.Scanner;

// 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
public class Test32 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println(Solution.NumberOf1Between1AndN_Solution(n));
	}

	public static class Solution {
		public static int NumberOf1Between1AndN_Solution(int n) {
			int ans = 0, a, b;
			for (int i = 1; i <= n; i *= 10) {
				a = n / i;
				b = n % i;
				ans = ans + i * (a + 8) / 10 + (a % 10 == 1 ? 1 : 0) * (b + 1);
			}
			return ans;
		}
	}
}
