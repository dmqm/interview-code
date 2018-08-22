package coding.recruit17;

import java.util.Scanner;

/*
 * 题目描述 输入一个正整数n,求n!(即阶乘)末尾有多少个0？ 比如: n = 10; n! = 3628800,所以答案为2 输入描述:
 * 
 * 输入为一行，n(1 ≤ n ≤ 1000)
 * 
 * 输出描述:
 * 
 * 输出一个整数,即题目所求
 */
public class T32末尾的0个数 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int res = 0, temp;
			for (int i = 1; i <= n; i++) {
				temp = i;
				while (temp % 5 == 0) {
					res++;
					temp /= 5;
				}
			}
			System.out.println(res);
		}
	}

	public static void others() {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int res = 0;
			while (n > 0) {
				n /= 5;
				res += n;
			}
			System.out.println(res);
		}
	}
}
