package offer;
/**
 * 题目描述

		输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
		使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
		并保证奇数和奇数，偶数和偶数之间的相对位置不变。
	思路：
		定义一个新数组，用于存储排序好后的数组。
		定义两个指针，分别指向奇数和偶数的位置，奇数指针从0开始，偶数指针从奇数个数开始。
 * @author REN
 * @date 2016年6月21日 下午3:01:50
 */
public class _14ReorderArray {

	public void reOrderArray(int [] array) {
		if(array.length <= 1)
			return;
		
		int oddBegin = 0;//指向新数列的首位
		int oddCount = 0; //指向新数列偶数首位
		for (int i : array) {
			if((i&1) == 1 )
				oddCount ++;
		}
		int[] newArray = new int[array.length]; //新数列
		
		for(int i =0; i < array.length ; i ++){
			if((array[i]&1) == 1){
				newArray[oddBegin++] = array[i];
			}else{
				newArray[oddCount++] = array[i];
			}
		}
		
		for(int i = 0; i< array.length ; i++){
			
			array[i] = newArray[i];
		}
	}
}
