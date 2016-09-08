package offer;
/**
 * 题目：
 * 		求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 
 * @author REN
 * @date 2016年9月7日 下午10:13:50
 */
public class _46Accumulate {

	public static int Sum_Solution(int n) {
        int sum  = n;
        boolean flag  = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }
	
	public static void main(String[] args) {
		
		int result = Sum_Solution(100);
		System.out.println(result);
	}
}
