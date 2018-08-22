package coding.recruit17;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * 题目描述 找出n个数里最小的k个 输入描述:
 * 
 * 每个测试输入包含空格分割的n+1个整数，最后一个整数为k值,n 不超过100。
 * 
 * 输出描述:
 * 
 * 输出n个整数里最小的k个数。升序输出
 * 
 * 示例1 输入 复制
 * 
 * 3 9 6 8 -10 7 -11 19 30 12 23 5
 * 
 * 输出 复制
 * 
 * -11 -10 3 6 7
 * 
 */
public class T36n个数里最小的k个 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String src = in.nextLine();
		String[] array = src.split(" ");
		int k = Integer.parseInt(array[array.length - 1]);
		array[array.length - 1] = String.valueOf(Integer.MAX_VALUE);
		Arrays.sort(array, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int s1 = Integer.parseInt(o1);
				int s2 = Integer.parseInt(o2);
				return s1 - s2;
			}
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < k; i++) {
			sb.append(array[i]).append(" ");
		}
		System.out.println(sb.deleteCharAt(sb.length() - 1));
	}

}
