package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述

		在一个字符串(1<=字符串长度<=10000，全部由大写字母组成)中找到第一个只出现一次的字符。
 * 
 * 思路：
 * 		把所有字符存储在一个数组中。从 a-z或者 A-Z一共有26个字符。数组小标表示从a - z的索引。
 * 数值则存储该字符出现的次数。第一次遍历把字符串扫描一遍。计算出每一个字符出现的次数。初始化完成
 * 数组。然后再次对数组进行遍历，寻找第一个数值为1的下标索引返回。
 * @author REN
 * @date 2016年7月11日 下午10:11:33
 */
public class _35FirstNotRepeatingChar {

	public static void main(String[] args) {
		int index = new _35FirstNotRepeatingChar().FirstNotRepeatingChar("google");
		System.out.println(index);
	}
	
	 public int FirstNotRepeatingChar(String str) {
		 	if(str == null || str.length() == 0)
		 		return -1;
		 	char[] charArray = str.toCharArray();
		 	Map<Character,Integer> map = new HashMap<>();
		 	for (char c : charArray) {
				
		 		if(map.containsKey(c)){
		 			int count = map.get(c);
		 			count++;
		 			map.put(c, count);
		 		}else{
		 			map.put(c, 1);
		 		}
			}
		 	for(int i = 0;i<charArray.length;i++){
		 		if(map.get(charArray[i]) == 1){
		 			return i;
		 		}
		 	}
		 	return -1;
	 }
}
