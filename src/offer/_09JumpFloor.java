package offer;
/**
 * 
 * 题目描述

	一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *  
 *  思路：
 *     1级台阶，有一种跳法。
 *     2级台阶，有两种跳法。
 *     
 *     n级台阶，如果第一级跳一个，则有f(n-1)种跳法。
 *     		   如果第一级跳两个，则有f(n-2)种跳法。
 *     所以，f(n) = f(n-1) + f(n-2);
 *     
 *     所以这是一个斐波那契数列问题。
 * @author REN
 * @date 2016年6月20日 下午10:40:03
 */
public class _09JumpFloor {

public int JumpFloor(int target) {
		if(target <= 2)
            return target;
		
		int fibOne = 2;
		int fibTwo = 1;
		int fibN = 0;
		//循环计算
		for(int i = 3 ; i <= target ; i++){
			fibN = fibOne + fibTwo;
			fibTwo = fibOne;
			fibOne = fibN;
		}
		return fibN;
    }

public int JumpFloorII(int target) {
    if(target <= 2)
        return target;
    return (int) Math.pow(2,target-1);
}
}
