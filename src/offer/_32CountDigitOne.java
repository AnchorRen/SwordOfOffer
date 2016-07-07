package offer;
/**
 * 
 * 题目描述

		求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
		为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
		但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,
		可以很快的求出任意非负整数区间中1出现的次数。
 * 
 * 思路：
 * 		For each position, split the decimal representation into two parts, 
	 	for example split n=3141592 into a=31415 and b=92 when we're at m=100 for analyzing the hundreds-digit. 
	    And then we know that the hundreds-digit of n is 1 for prefixes "" to "3141", i.e., 3142 times. 
	    Each of those times is a streak, though. Because it's the hundreds-digit, 
	    each streak is 100 long. So (a / 10 + 1) * 100 times, the hundreds-digit is 1.
		Consider the thousands-digit, i.e., when m=1000. Then a=3141 and b=592. 
		The thousands-digit is 1 for prefixes "" to "314", so 315 times. 
		And each time is a streak of 1000 numbers. However, since the thousands-digit is a 1, 
		the very last streak isn't 1000 numbers but only 593 numbers, 
		for the suffixes "000" to "592". So (a / 10 * 1000) + (b + 1) times, the thousands-digit is 1.
		The case distincton between the current digit/position being 0, 1 and >=2 can easily be done in one expression.
		 With (a + 8) / 10 you get the number of full streaks, and a % 10 == 1 tells you whether to add a partial streak.
 * 		
 * 		对于每一个位置，把一个十进制数分为两部分。例如，分割 n = 3141592 为 a=31415,b=92.
 * 			当我们在 m = 100 的位置分析百位上的数字，然后我们百位上的数字 n 为1，前缀为 " " 到 "3141",共3142个
 * 		因为是百位数字，因此百位数字是 1  一共是（a/10 + 1）* 100 种。
 * 			当 m = 1000, a = 3141, b = 592.
 * 		当千位数为1，前缀从“” 到 “314” ，共 315 次。 每次代表1000个数字，然而，当千位数字为 1 的时候，最后面的数字不是1000个，而是593个。
 * 		后缀从 "000" 到 "592". 因此千位数为1的时候，为（a / 10 * 1000) + （b + 1)次。
 * 			对于上面两种情况， 0, 1 and >=2  可以简单的在一个表达式中进行表示，使用（a + 8) / 10, 而 a % 10 == 1 可以判定是否加上额外的数量。
 * 		
 * @author REN
 * @date 2016年7月6日 下午5:38:36
 */
public class _32CountDigitOne {

	public int countDigitOne(int n) {
	    int ones = 0;
	    for (long m = 1; m <= n; m *= 10) // a = n / m; b = n % m
	        ones += (n/m + 8) / 10 * m + (n/m % 10 == 1 ? n % m + 1 : 0);
	    return ones;
	}
}
