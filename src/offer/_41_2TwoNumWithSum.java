package offer;

import java.util.ArrayList;

/**
 * 题目描述

	输入一个递增排序的数组和一个数字S，在数组中查找两个数，
	使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。 
	
输出描述:
	对应每个测试案例，输出两个数，小的先输出。
	
思路：
	从两头开始夹逼寻找。ps：两个数相差越多积越小。
 * @author REN
 */
public class _41_2TwoNumWithSum {

	public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> result = new ArrayList<>();
		if(array == null || array.length < 2)
			return result;
		int startIndex = 0;
		int endIndex = array.length - 1;
		
		while(startIndex < endIndex){
			int curSum = array[startIndex] + array[endIndex];
			if(curSum == sum){
				result.add(array[startIndex]);
				result.add(array[endIndex]);
				break;//找到的第一对就是积最小的，直接退出
			}else if(curSum > sum){
				endIndex --;
			}else{
				startIndex ++;
			}
		}
		return result;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
