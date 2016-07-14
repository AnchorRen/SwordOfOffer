package offer;
/**
 * 题目描述

		统计一个数字在排序数组中出现的次数。
 * 	
 * 思路：
 * 		当然通过遍历整个数组就能统计出这个数字出现的次数。时间复杂度为 O(n).
 * 但是，这没有用到有序数组这个特性。显然还能通过使用这个特性提高性能。
 * 
 * 		由于是有序数组，我们可以通过找到这个数字首次出现的下标和最后一次出现的下标来计算出出现的次数。
 * 我们可以通过二分查找的方法来找首次出现的下标。
 * 
 * 		首先找出中间位置的元素，如果小于K，则首次出现的K应该在后半部分。如果大于K，则首次出现的位置在前半部分。
 * 如果等于k，则如果前面一个不等于k，则这就是第一次出现的位置。或者此时下标为0，也是首次出现的位置。如果前面一个也是K，
 * 则首次出现的位置在前半部分。接下来进行递归调用，知道找到为止。如果没找到，则返回-1。
 * 		
 * 		对于寻找K最后一次出现的位置也是同理。
 * 
 * @author REN
 * @date 2016年7月14日 下午8:59:46
 */
public class _38GetNumberOfkInASortedArray {

	   public int GetNumberOfK(int [] array , int k) {
	       
			if(array == null || array.length == 0)
				return 0;
			int firstIndex = getFirstK(array,k,0,array.length - 1);
			if(firstIndex < 0)
				return 0;
			int lastIndex  = getLastK(array,k,0,array.length - 1);
			return lastIndex - firstIndex + 1;
			
	    }
		
		public int getFirstK(int[] array,int k,int start,int end){
			
			if(start > end)
				return  -1;
			
			int middleIndex = (end + start)/2;
			int middleValue = array[middleIndex];
			
			if(middleValue == k){
				if((middleIndex > 0 && array[middleIndex - 1] != k) || middleIndex == 0){
					return middleIndex;
				}else{
					end = middleIndex - 1;
				}
			}else if(middleValue < k){
				start = middleIndex + 1;
			}else {
				end = middleIndex - 1;
			}
			return getFirstK(array,k,start,end);
			
		}
		
		public int getLastK(int[] array,int k,int start,int end){
			
			if(start > end)
				return -1;
			int middleIndex = (end + start)/2;
			int middleValue = array[middleIndex];
			
			if(middleValue == k){
				if((middleIndex < array.length - 1  && array[middleIndex + 1] != k)||middleIndex == array.length - 1){
					return middleIndex;
				}else{
					start = middleIndex + 1;
				}
			}else if(middleValue < k){
				start = middleIndex + 1;
			}else{
				end = middleIndex - 1;
			}
			return getLastK(array,k,start,end);
			
		}
}
