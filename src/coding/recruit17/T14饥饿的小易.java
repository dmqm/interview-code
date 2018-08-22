package coding.recruit17;

import java.util.Scanner;

/*
 * 题目描述 小易总是感觉饥饿，所以作为章鱼的小易经常出去寻找贝壳吃。最开始小易在一个初始位置x_0。对于小易所处的当前位置x，他只能通过神秘的力量移动到 4 * x + 3或者8 * x +
 * 7。因为使用神秘力量要耗费太多体力，所以它只能使用神秘力量最多100,000次。贝壳总生长在能被1,000,000,007整除的位置(比如：位置0，位置1,000,000,007，位置2,000
 * ,000,014等)。小易需要你帮忙计算最少需要使用多少次神秘力量就能吃到贝壳。 输入描述:
 * 
 * 输入一个初始位置x_0,范围在1到1,000,000,006
 * 
 * 输出描述:
 * 
 * 输出小易最少需要使用神秘力量的次数，如果使用次数使用完还没找到贝壳，则输出-1
 */
public class T14饥饿的小易 {
	// 发现数字规律
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int x0 = in.nextInt();
			// 2^n爆炸增长，怎么解决？
			// 别人的方法……
			int count = 0;
			while (x0 != 0 && count <= 300000) {
				x0 = ((x0 << 1) + 1) % 1000000007;
				count++;
			}
			int res = (count + 2) / 3;
			System.out.println(res > 100000 ? -1 : res);
		}
	}
}
