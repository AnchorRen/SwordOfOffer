package offer;

import java.util.ArrayList;

/**
 * 题目描述

	小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,
	他马上就写出了正确答案是100。但是他并不满足于此,
	他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
	没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
	现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck! 
	
输出描述:
	输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
	
	思路：
	
	最少为两连续正整数。设置两个数，start = 1，end = 2;计算和与sum比较。如果小于sum，则end后移一个，重新计算curSum。
	如果大于了Sum,则start后移。重新计算curSum。找到服务规范的则计入结果中。
	结束标志为:start == (sum + 1) / 2;

 * @author REN
 */
public class _41ContinuesSequenceWithSum {
	public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
	       
		int start = 1;
		int end = 2;
		int middle = (1+sum)/2;
		int curSum = start + end;
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		while(start < middle){
			if(curSum == sum){
				ArrayList<Integer> list = new ArrayList<>();
				for(int i = start; i<= end;i++){
					list.add(i);
				}
				result.add(list);
			}
			while(curSum > sum && start < middle){
				curSum -= start;
				start ++ ;
				if(curSum == sum){
					ArrayList<Integer> list = new ArrayList<>();
					for(int i = start; i<= end;i++){
						list.add(i);
					}
					result.add(list);
				}
			}
			++end;
			curSum += end;
		}
		return result;
    }
	
	
}
