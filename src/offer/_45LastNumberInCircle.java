package offer;
/**
 * 约瑟夫环问题。
 * 
 * 		0,1,2，，，n-1 这n个数字排成一个圆圈。从数字0开始每次从这个圆圈中删除第m个数字。求出这个圆圈中
 * 剩下的最后一个数字。
 * 
 * 解法思路：
 * 		使用一个数组模拟约瑟夫环。
 * 		定义一个数组，长度为n. 从下标为0开始遍历。到第m个的时候，设置这个数组值为-1。然后从下一个
 * 再次开始计数，遇到值为-1的就是标记过的，跳到下一个，每走一步计数器加1.到m时候再标记一个数字。
 * 一直循环这个步骤，直到最后数组中都为-1的时候，这时候数组中的共标记了n次。最后一次标记的数字下标就是要
 * 求的数字。
 * 		
 * @author REN
 * @date 2016年9月7日 下午9:57:23
 */
public class _45LastNumberInCircle {

	 public int LastRemaining_Solution(int n, int m) {
		 
		 if(n < 1 || m < 1)
			 return -1;
		 int [] array = new int[n]; //使用数组模拟约瑟夫环
		 int i = -1; //数组下标指针
		 int step = 0; //计数器
		 int count = n; //找到的个数倒数计数器
		 
		 while(count > 0){
			 i ++;
			 if(i >= n){
				 i = 0; //模拟环，到了最后一个跳到第一个
			 }
			 if(array[i] == -1)
				 continue;
			 step ++; //步数加1
			 if(step == m){
				 array[i] = -1;
				 step = 0; //计步器归零
				 count -- ; //倒数计数器减一
			 }
		 }
		 
		 return i;
	 }
}
