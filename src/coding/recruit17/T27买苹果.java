package coding.recruit17;

import java.util.Scanner;

/*
 * 题目描述 小易去附近的商店买苹果，奸诈的商贩使用了捆绑交易，只提供6个每袋和8个每袋的包装(包装不可拆分)。
 * 可是小易现在只想购买恰好n个苹果，小易想购买尽量少的袋数方便携带。如果不能购买恰好n个苹果，小易将不会购买。 输入描述:
 * 
 * 输入一个整数n，表示小易想购买n(1 ≤ n ≤ 100)个苹果
 * 
 * 输出描述:
 * 
 * 输出一个整数表示最少需要购买的袋数，如果不能买恰好n个苹果则输出-1
 */
public class T27买苹果 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int res = 3 * (n / 24);
			n = n % 24;
			switch (n) {
				case 0:
					break;
				case 6:
				case 8:
					res += 1;
					break;
				case 12:
				case 14:
				case 16:
					res += 2;
					break;
				case 18:
				case 20:
				case 22:
					res += 3;
					break;
				default:
					res = -1;
			}
			System.out.println(res);
		}
	}

}
