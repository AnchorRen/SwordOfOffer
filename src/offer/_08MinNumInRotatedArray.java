package offer;
/**
 * 旋转数组的最小数字。
 * 题目描述

	把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
	输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
	例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
	NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 
 *  思路： 使用类似于二分查找的方法。借用两个指针
 *  		第一个指针永远指向前面序列，第二个指针指向后面的序列。
 *  		当中间指针大于等于第一个指针的时候，则更新第一个指针为中间指针。
 *  		当中间指针小于等于第二个指针的时候，则更新第二个指针为中间指针。
 *  		当中间指针等于第一个指针且等于第二个指针的时候，只能用顺序遍历的方法。
 * @author REN
 * @date 2016年6月20日 下午9:54:06
 */
public class _08MinNumInRotatedArray {

	public static void main(String[] args) {
		_08MinNumInRotatedArray solution = new _08MinNumInRotatedArray();
		int[] array = {4,5,6,1,2,3};
		int result = solution.minNumberInRotateArray(array);
		System.out.println(result);
	}
	
	public int minNumberInRotateArray(int [] array) {
	    if(array == null || array.length == 0)
	    	return 0;
	    int index1 = 0; //第一个指针
	    int index2 = array.length - 1;//第二个指针
	    int indexMid = index1; //中间指针
	    
	    while(array[index1] >= array[index2]){
	    	if(index2 - index1 == 1){ //当两个指针相邻时候，就是停止的时候。后面的数字是最小的
	    		indexMid = index2; 
	    		break;
	    	}
	    	indexMid = (index1 + index2)/2; //中间指针
	    	
	    	//如果下标为index1、index2、indexMid 指向的三个数字相同。则只能顺序查找。
	    	if(array[index1] == array[index2] && array[indexMid] == array[index1])
	    		return MinInOrder(array,index1,index2);
	    	
	    	if(array[indexMid] >= array[index1])
	    		index1 = indexMid;
	    	
	    	else if(array[indexMid] <= array[index2])
	    		index2 = indexMid;
	    }
	    return array[indexMid];
    }

	/**
	 * 顺序查找最小值
	 * @param array
	 * @param index1
	 * @param index2
	 * @return
	 */
	private int MinInOrder(int[] array, int index1, int index2) {

		int result = array[index1];
		for(int i = index1 + 1;i < index2;i++){
			if(result > array[i])
				result = array[i];
		}
		return result;
	}
}
