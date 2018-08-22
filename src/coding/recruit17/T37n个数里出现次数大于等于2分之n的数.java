package coding.recruit17;


import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

/*
 * 题目描述 输入n个整数，输出出现次数大于等于数组长度一半的数。 输入描述:
 * 
 * 每个测试输入包含 n个空格分割的n个整数，n不超过100，其中有一个整数出现次数大于等于n/2。
 * 
 * 输出描述:
 * 
 * 输出出现次数大于等于n/2的数。
 * 
 * 示例1 输入 复制
 * 
 * 3 9 3 2 5 6 7 3 2 3 3 3
 * 
 * 输出 复制
 * 
 * 3
 * 
 */
public class T37n个数里出现次数大于等于2分之n的数 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] src = in.nextLine().split(" ");
		int length = src.length;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < length; i++) {
			if (map.containsKey(src[i])) {
				map.replace(src[i], map.get(src[i]) + 1);
			} else {
				map.put(src[i], 1);
			}
		}
		for (Entry<String, Integer> item : map.entrySet()) {
			if (item.getValue() >= length / 2 + length % 2) {
				System.out.println(item.getKey());
			}
		}
	}
}
