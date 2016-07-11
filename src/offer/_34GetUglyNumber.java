package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 题目描述

		把只包含因子2、3和5的数称作丑数（Ugly Number）。
		例如6、8都是丑数，但14不是，因为它包含因子7。 
		习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
	
	思路：
		
		从小到大逐个添加丑数到一个List中。一直到指定的数量。
	可知1是第一个丑数，2是第二个丑数，3个第三个丑数，4是第四个丑数，5是第五个丑数，6是第六个丑数......
	每个丑数都是已有丑数再乘以 2|3|5 得到的。所以可以以集合中已有丑数为基础，分别乘以2|3|5 进行比较，然后顺序添加
	最小者。首先添加1，然后以1为基数，分别乘以2|3|5，得到2|3|5，从中找到最小的2 添加。这时候集合中添加了2，所以这时候需要
	考虑2*2了，此时比较 2*2|3|5，添加3。然后3需要乘以集合中第二个元素然后再次比较。2*2|2*3|5，添加4。.......
 * @author REN
 * @date 2016年7月11日 下午8:57:51
 */
public class _34GetUglyNumber {

	public int GetUglyNumber_Solution(int index) {
        
		if(index <= 0)
			return 0;
		List<Integer> list = new ArrayList<>();
		list.add(1);
		int i2 = 0,i3 = 0,i5 = 0; //记录各个丑数乘以集合中数的索引
		while(list.size() < index){
			int r2 = list.get(i2)*2;
			int r3 = list.get(i3)*3;
			int r5 = list.get(i5)*5;
			int minOf3 = Math.min(r2, Math.min(r3, r5)); 
			list.add(minOf3); //添加最小的
			//对刚添加的数更新索引。
			if(minOf3 == r2) 
				i2 ++ ;
			if(minOf3 == r3)
				i3 ++ ;
			if(minOf3 == r5)
				i5 ++ ;
		}
		return list.get(list.size() - 1);
    }
}
