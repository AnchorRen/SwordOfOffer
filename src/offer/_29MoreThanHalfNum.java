package offer;

/**
 * 题目描述
 * 
 * 		数组中有一个数字出现的次数超过数组长度的一半， 请找出这个数字。
 * 		例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 		由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。 如果不存在则输出0。
 * 
 * 
 * 思路：
 * 		数组中出现次数大于数组长度一半的数字。对数组同时去掉两个不同的数字，
 * 到最后剩下的一个数就是该数字。如果剩下两个，那么这两个也是一样的，就是结果。
 * 		因此，我们可以在遍历数组的时候保存两个值，一个值用于存储数组中的元素，
 * 一个用于保存次数。当我们遍历下一个的时候，如果下一个元素与这个元素相等，
 * 则次数加1，否则次数减1.如果次数为0，则保存下一个元素，次数设置为1.
 * 由于我们要找的数字出现的次数比其他所有数字出现的次数之和还要多。因此最后剩下的数字
 * 才有可能是我们寻找的数字
 * 
 * @author REN
 * @date 2016年7月6日 上午9:43:42
 */
public class _29MoreThanHalfNum {

	public int MoreThanHalfNum_Solution(int[] array) {
		int length = array.length;
		if (array == null || length <= 0) {
			return 0;
		}

		int result = array[0];
		int times = 1;
		for (int i = 1; i < length; i++) {
			if (times == 0) {
				result = array[i];
				times = 1;
			} else {
				if (array[i] == result) {
					times++;
				} else {
					times--;
				}
			}
		}
		//经过上面的遍历已经找到了最后剩下Result 是唯一可能次数超过数组长度一半的数字。
		//遍历数组，统计result出现的次数
		times = 0;
		for (int i = 0; i < length; i++) {
			if (result == array[i]) {
				times++;
			}
		}
		//如果result次数大于数组长度的一半，则返回
		if (times * 2 < length) {
			result = 0;
		}
		return result;
	}
}
