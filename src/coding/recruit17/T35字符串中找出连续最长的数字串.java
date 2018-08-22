package coding.recruit17;


import java.util.Scanner;

/*
 * 题目描述 读入一个字符串str，输出字符串str中的连续最长的数字串 输入描述:
 * 
 * 个测试输入包含1个测试用例，一个字符串str，长度不超过255。
 * 
 * 输出描述:
 * 
 * 在一行内输出str中里连续最长的数字串。
 * 
 * 示例1 输入 复制
 * 
 * abcd12345ed125ss123456789
 * 
 * 输出 复制
 * 
 * 123456789
 * 
 */
public class T35字符串中找出连续最长的数字串 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		int max = 0, offset1 = 0;
		int now = 0, offset2 = 0;
		for (int i = 0; i < str.length(); i++) {
			char t = str.charAt(i);
			if (t >= '0' && t <= '9') {
				offset2++;
				if (offset2 > offset1) {
					max = now;
					offset1 = offset2;
				}
			} else {
				now = i + 1;
				offset2 = 0;
			}
		}
		System.out.println(str.substring(max, max + offset1));
	}

}
