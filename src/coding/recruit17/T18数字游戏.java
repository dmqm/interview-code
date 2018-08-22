package coding.recruit17;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 题目描述 小易邀请你玩一个数字游戏，小易给你一系列的整数。你们俩使用这些整数玩游戏。每次小易会任意说一个数字出来，然后你需要从这一系列数字中选取一部分出来让它们的和等于小易所说的数字。 例如：
 * 如果{2,1,2,7}是你有的一系列数，小易说的数字是11.你可以得到方案2+2+7 = 11.如果顽皮的小易想坑你，他说的数字是6，那么你没有办法拼凑出和为6
 * 现在小易给你n个数，让你找出无法从n个数中选取部分求和的数字中的最小数（从1开始）。 输入描述:
 * 
 * 输入第一行为数字个数n (n ≤ 20) 第二行为n个数xi (1 ≤ xi ≤ 100000)
 * 
 * 输出描述:
 * 
 * 输出最小不能由n个数选取求和组成的数
 */
public class T18数字游戏 {
	// 思路
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int[] x = new int[n];
			for (int i = 0; i < n; i++)
				x[i] = in.nextInt();
			Arrays.sort(x);
			System.out.println(match(x, n));
		}
	}

	/*
	 * 从小到大排序，一开始一块钱都凑不出来 下面，为了0~x都有，我需要来一个1元的（不然1元凑不出来） 给了你1元的，下面必须给1+1元以内的，不然2元凑不出来
	 * 如果再给一个1元的，那你现在能凑出0~2元的，接下来+1+2或者+3，都能增大范围而且不会导致中间缺一个数（4元的不行，因为凑不出3了）
	 * ——反正一直往下，直到出现第一个算不出来的值为止。
	 */
	public static int match(int[] x, int n) {
		if (x[0] > 1)
			return 1;
		else if (n == 1)
			return x[0] + 1;
		else {
			int sum = x[0];
			for (int i = 1; i < n; i++) {
				if (x[i] - sum > 1)
					break;
				else
					sum += x[i];
			}
			return sum + 1;
		}
	}
}
