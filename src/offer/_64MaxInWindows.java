package offer;

import java.util.ArrayList;

/**
 * 滑动窗口的最大值.
 * 	
 * 	给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 *  {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， 
 *  {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * 	
 * @author REN
 * @date 2016年9月10日 上午11:45:29
 */
public class _64MaxInWindows {

	public static void main(String[] args) {
		int[] nums = {2,3,4,2,6,2,5,1};
		ArrayList<Integer> result = maxInWindows(nums,3);
		System.out.println(result.toString());
	}
	
	public static  ArrayList<Integer> maxInWindows(int [] nums, int size)
    {
		ArrayList<Integer> list = new ArrayList<Integer>();
        if(nums.length < size || size == 0)
        	return list;
        for(int i = 0 ,j = 0 + size - 1; i < nums.length && j < nums.length; i++,j++){
        	Integer max = getMaxInArray(nums,i, j);
        	list.add(max);
        }
        return list;
    }
	
	public static Integer getMaxInArray(int[] nums, int start, int end){
		int max = nums[start];
		for(int i = start; i <= end; i++){
			if(nums[i] > max)
				max = nums[i];
		}
		return max;
	}
}
