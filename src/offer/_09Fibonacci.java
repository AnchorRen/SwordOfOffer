package offer;
/**
 * 
 * 题目描述

	大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * 
 *  使用传统的递归方法很浪费内存空间。
 *  使用两个变量，从小到大计算
 * @author REN
 * @date 2016年6月20日 下午10:21:08
 */
public class _09Fibonacci {

	public int Fibonacci(int n) {

		int [] result = {0,1}; //存储第一项和第二项
		if(n < 2)
			return result[n];
		
		int fibOne = 1;
		int fibTwo = 0;
		int fibN = 0;
		//循环计算
		for(int i =2 ; i <= n ; i++){
			fibN = fibOne + fibTwo;
			fibTwo = fibOne;
			fibOne = fibN;
		}
		return fibN;
    }
}
