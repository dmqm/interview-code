package coding.recruit17;


/*
 * 题目描述 将一句话的单词进行倒置，标点不倒置。比如 I like beijing. 经过函数后变为：beijing. like I 输入描述:
 * 
 * 每个测试输入包含1个测试用例： I like beijing. 输入用例长度不超过100
 * 
 * 输出描述:
 * 
 * 依次输出倒置之后的字符串,以空格分割
 * 
 * 示例1 输入 复制
 * 
 * I like beijing.
 * 
 * 输出 复制
 * 
 * beijing. like I
 * 
 * 
 */
import java.util.Scanner;

public class T38倒置字符串 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] src = in.nextLine().split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = src.length - 1; i >= 0; i--) {
			sb.append(src[i]).append(" ");
		}
		System.out.println(sb.deleteCharAt(sb.length() - 1));
	}
}
