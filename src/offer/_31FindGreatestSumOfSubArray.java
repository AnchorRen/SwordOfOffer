package offer;
/**
 * 问题描述：
 * 		输入一个整数数组，数组里有正数也有负数，数组中一个或者多个连续整数组成一个子数组。
 * 		求所有子数组的和的最大值。要求时间复杂度为O(n).
 * 
 * @author REN
 * @date 2016年7月6日 下午4:39:01
 */
public class _31FindGreatestSumOfSubArray {

	public static void main(String[] args) {
		int[] nums = {6,-3,-2,7,-15,1,2,2};
		int result = new _31FindGreatestSumOfSubArray().FindGreatestSumOfSubArray(nums);
		System.out.println(result);
	}
	
	public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length==0 || array == null)
        	return 0;
        int curSum = 0; //当前和
        int greatestSum = Integer.MIN_VALUE; //最大和
        for (int i : array) {
			if(curSum <= 0) //如果当前和小于0了，就取下一项
				curSum = i;
			else			//大于0，则累加
				curSum += i;
			if(curSum > greatestSum) //当前和大于最大和，更新最大和
				greatestSum = curSum;
		}
        return greatestSum;
    }
}
