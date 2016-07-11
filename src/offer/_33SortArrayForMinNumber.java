package offer;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 把数组排成最小的数
 * 
 *   题目描述:

		输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
		打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
		则打印出这三个数字能排成的最小数字为321323
 * 
 * 
 * @author REN
 * @date 2016年7月11日 下午8:11:33
 */
public class _33SortArrayForMinNumber {
	
	public String PrintMinNumber(int [] numbers) {
		List<Integer> list = new LinkedList<>();
		for (int i : numbers) {
			list.add(i);
		}
		Collections.sort(list,new Comparator<Integer>() {

			@Override
			public int compare(Integer num1, Integer num2) {
				String str1 = num1+""+num2;
				String str2 = num2+""+num1;
				return str1.compareTo(str2);
			}
		});
		
		StringBuilder stringBuilder = new StringBuilder();
		for (Integer integer : list) {
			stringBuilder.append(integer);
		}
		
		return stringBuilder.toString();
    }
}
