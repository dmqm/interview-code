package coding.recruit17;

import java.util.Scanner;

/*
 * 题目描述 假定一种编码的编码范围是a ~ y的25个字母，从1位到4位的编码，如果我们把该编码按字典序排序，形成一个数组如下： a, aa, aaa, aaaa, aaab, aaac, …
 * …, b, ba, baa, baaa, baab, baac … …, yyyw, yyyx, yyyy 其中a的Index为0，aa的Index为1，aaa的Index为2，以此类推。
 * 编写一个函数，输入是任意一个编码，输出这个编码对应的Index. 输入描述:
 * 
 * 输入一个待编码的字符串,字符串长度小于等于100.
 * 
 * 输出描述:
 * 
 * 输出这个编码的index
 * 
 * 示例1 输入 复制
 * 
 * baca
 * 
 * 输出 复制
 * 
 * 16331
 * 
 * 
 */
public class T41编码 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char[] src = in.nextLine().toCharArray();
		int res = 0;
		int muti = 1;
		int[] sum = new int[4];
		sum[3] = 1;
		for (int i = 2; i >= 0; i--) {
			muti *= 25;
			sum[i] = sum[i + 1] + muti;
		}
		for (int i = 0; i < src.length; i++) {
			res += (src[i] - 'a') * sum[i] + 1;
		}
		System.out.println(res - 1);
	}

}
