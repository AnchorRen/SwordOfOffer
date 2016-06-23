package offer;

import java.util.Stack;

/**
 * 题目描述

	定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
	
   思路：
     用两个栈模拟，其中一个栈正常存储数据。另一个栈的栈顶元素存储当前栈中元素的最小值。
 * @author REN
 * @date 2016年6月23日 下午9:52:10
 */
public class _21MinInStack {

	public static void main(String[] args) {
		_21MinInStack stack = new _21MinInStack();
		stack.push(3);
		int min2 = stack.min();
		System.out.println(min2);
	}
	
	Stack<Integer> stack = new Stack<>();//正常栈
	Stack<Integer> min = new Stack<>(); //最小值栈
	
	public void push(int node) {
        stack.push(node);
        if(min == null || min.empty())
        	min.push(node);
        else if(node < min.peek()){ //添加当前栈中的最小值到min中
        	min.push(node);
        }else{
        	min.push(min.peek());
        }
    }
    
    public void pop() {
        if(!stack.empty() && !min.empty()){
        	stack.pop();
        	min.pop();
        }
    }
    
    public int top() {
        	return stack.peek();
    }
    
    public int min() {
        if(!stack.empty() && !min.empty()){
        	return min.peek();
        }
		return 0;
    }
}
