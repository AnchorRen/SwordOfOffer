package offer;
/**
 * 	题目描述

		给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
		
		
 * @author REN
 * @date 2016年6月21日 下午2:15:45
 */
public class _11Power {

	public double Power(double base, int n) {
	    double res = 1,curr = base;
	    int exponent;
	    if(n>0){
	        exponent = n;
	    }else if(n<0){
	        if(base==0)
	            throw new RuntimeException("分母不能为0"); 
	        exponent = -n;
	    }else{// n==0
	        return 1;// 0的0次方
	    }
	    /**
	     * 如果expose为32，则如果求出了其16次方。则只需乘方就可得出32次方。
	     * 不需要连城32次，这样效率更高。
	     */
	    while(exponent!=0){
	        if((exponent&1)==1)//此时exponent为奇数。
	            res*=curr;
	        curr*=curr;// 乘方运算
	        exponent>>=1;// 右移一位，幂除以2
	    }
	    return n>=0?res:(1/res);       
	}
}
