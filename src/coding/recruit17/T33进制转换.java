package coding.recruit17;

import java.util.Scanner;

/*
 * 题目描述 给定一个十进制数M，以及需要转换的进制数N。将十进制数M转化为N进制数 输入描述:
 * 
 * 输入为一行，M(32位整数)、N(2 ≤ N ≤ 16)，以空格隔开。
 * 
 * 输出描述:
 * 
 * 为每个测试实例输出转换后的数，每个输出占一行。如果N大于9，则对应的数字规则参考16进制（比如，10用A表示，等等）
 */
public class T33进制转换 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int M = in.nextInt();
			int N = in.nextInt();
			boolean flag = true;
			if (M < 0) {
				flag = false;
				M = -M;
			}
			StringBuilder sb = new StringBuilder();
			while (M != 0) {
				if (M % N > 9)
					sb.insert(0, (char) ('A' + M % N - 10));
				else
					sb.insert(0, M % N);
				M /= N;
			}
			if (!flag)
				sb.insert(0, '-');
			System.out.println(sb.toString());
		}
	}
}
