package coding.recruit17;

import java.util.Scanner;

/*
 * 题目描述 对于一个整数X，定义操作rev(X)为将X按数位翻转过来，并且去除掉前导0。例如: 如果 X = 123，则rev(X) = 321; 如果 X = 100，则rev(X) = 1.
 * 现在给出整数x和y,要求rev(rev(x) + rev(y))为多少？ 输入描述:
 * 
 * 输入为一行，x、y(1 ≤ x、y ≤ 1000)，以空格隔开。
 * 
 * 输出描述:
 * 
 * 输出rev(rev(x) + rev(y))的值
 */
public class T25数字翻转 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int x = in.nextInt(), y = in.nextInt();
			System.out.println(rev(rev(x) + rev(y)));
		}
	}

	public static int rev(int t) {
		StringBuilder sb = new StringBuilder();
		sb.append(t);
		sb.reverse();
		return Integer.parseInt(sb.toString());
	}


	public static int rev2(int num) {
		int x = 0;
		while (num != 0) {
			x = 10 * x + num % 10;
			num = num / 10;
		}
		return x;
	}
}
