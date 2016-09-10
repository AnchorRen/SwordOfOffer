package offer;
/**
 * 机器人的运动范围.
 * 
 *  地上有一个m行和n列的方格。
 *  一个机器人从坐标0,0的格子开始移动，
 *  每一次只能向左，右，上，下四个方向移动一格，
 *  但是不能进入行坐标和列坐标的数位之和大于k的格子。
 *  例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 *  但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * 
 * @author REN
 * @date 2016年9月10日 下午4:43:01
 */
public class _66MovingCount {

	
	public int movingCount(int k, int rows, int cols)
    {
		int[][] flag = new int[rows][cols]; //记录点是否访问过，0--未访问；1--访问过。
		return helper(k, rows, cols, 0, 0, flag);
    }
	
	public static int helper(int k,int rows, int cols, int row, int col, int[][] flag){
		
		//合法性校验
		if(row < 0 || row >= rows || col < 0 || col >= cols || numSum(row) + numSum(col) > k || flag[row][col] == 1)
			return 0;
		//标记当前坐标点为访问过
		flag[row][col] = 1;
		//上下左右回溯访问所有的点
		return 1 + helper(k, rows, cols, row - 1, col, flag)
				+ helper(k, rows, cols, row + 1, col, flag)
				+ helper(k, rows, cols, row, col- 1, flag)
				+ helper(k, rows, cols, row, col + 1, flag);
	}
	
	public static int numSum(int num){
		int sum = 0;
		while(num > 0){
			sum += num % 10;
			num = num/10;
		}
		return sum;
	}
}