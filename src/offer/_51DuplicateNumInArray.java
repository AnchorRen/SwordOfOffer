package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 	在一个长度为n的数组里的所有数字都在0到n-1的范围内。 
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数字2或者3。
 * 
 * 思路：使用一个Map进行过滤。把每一个数字存储进map中，
 * 		其中key--数组中的数字。 value--数字出现的次数。
 * 
 * @author REN
 * @date 2016年9月8日 上午10:33:05
 */
public class _51DuplicateNumInArray {
	
	public static void main(String[] args) {
		int[] numbers = {2,1,3,1,4};
		int [] duplication = new int[5];
		boolean result = duplicate(numbers, 5, duplication);
		System.out.println(result);
		System.out.println(duplication[0]);
	}

	/*
	 * 解法1
	 * 借助Map完成。
	 * key--number中的值
	 * value--number中值出现的次数
	 */
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
    
    	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    	
    	for(int i = 0; i< length; i++){
    		Integer value = map.get(numbers[i]);
    		if(value == null){
    			map.put(numbers[i], 1);
    		}else if(value == 1){
    			duplication[0] = numbers[i];
    			return true;
    		}
    	}
    	return false;
    }
    
    /*
     * 解法2（推荐）
     * 利用长度为n的数组里的所有数字都在0到n-1的范围内 这个条件。
     * 可知，值得范围不超过最大下标。则，可以通过一个格外的数组存储，
     * 每个数组下标为要求数组的值。
     */
    public boolean duplicate2(int numbers[],int length,int [] duplication) {
        int[] assist = new int [length];
        for(int i = 0; i < length; i++){
            if(assist[numbers[i]] == 0){ //numbers的数值作为assit的下标，从数组中取值，如果是默认的0，则加1，表示出现了一次了。
                assist[numbers[i]] ++;
            }else{//不为0，则已经出现过了。找到了符合条件的结果。
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }
}
