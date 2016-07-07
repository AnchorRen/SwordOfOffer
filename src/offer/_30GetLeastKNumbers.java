package offer;

import java.util.ArrayList;

/**
 * 题目描述
 * 
 * 		输入n个整数，找出其中最小的K个数。 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 * 
 * 思路：
 * 		就是利用简单选择排序，向量初始为一个无序区，每次从无序区中选出一个最小元素与无序区的第一个元素交换，
 * 		并将其输出，这样经过k趟排序，就能得到最小的k个数了。
 * 
 * @author REN
 * @date 2016年7月6日 下午2:34:24
 */
public class _30GetLeastKNumbers {

	public static void main(String[] args) {
		int[] nums = {4,5,1,6,2,7,3,8};
		ArrayList<Integer> result = new _30GetLeastKNumbers().GetLeastNumbers_Solution(nums,4);
		System.out.println(result);
		
	}
	
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(input.length == 0 || k<=0 || k>input.length)
			return list;
		//i用来循环k次，j用来从无序区遍历元素，index标记最小元素下标
		int i = 0,j = 0, index = 0;
		for(;i<k;i++){
			index = i;
			for(j = i + 1;j<input.length;j++){
				if(input[j]<input[index])
					index = j; //找到最小元素下标
			}
			list.add(input[index]);
			if(index != i)
				swap(input,i,index);//交换此数到数组前面
		}
		return list;
	}

	private void swap(int[] nums,int i ,int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
