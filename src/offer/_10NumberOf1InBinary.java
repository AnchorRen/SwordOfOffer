package offer;
/**
 * 	题目描述

	输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
	
	 //从n的2进制形式的最右边开始判断是不是1
    /*
    * 该解法如果输入时负数会陷入死循环，
    * 因为负数右移时，在最高位补得是1
    * 二本题最终目的是求1的个数，那么会有无数个
    * 1了。
 * @author REN
 * @date 2016年6月21日 上午10:02:47
 */
public class _10NumberOf1InBinary {

	public static void main(String[] args) {
		_10NumberOf1InBinary n = new _10NumberOf1InBinary();
		int result = n.NumberOf1(-9);
		System.out.println(result);
	}
	
	public int NumberOf1(int n) {
		int count = 0;
		int flag = 1;
		while (flag != 0) {
			if ((n & flag) != 0) {
				count++;
			}
			flag = flag << 1; //每次向左移动flag。这样可以防止移动n，n为负数时候出现死循环的情况。
		}
		return count;
	}
}
