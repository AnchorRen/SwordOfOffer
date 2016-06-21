package offer;

import java.util.Stack;

/**
 * 题目描述

	用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
	
 * @author REN
 * @date 2016年6月20日 下午5:18:50
 */
public class _07CreateAQueneWithTwoStack {

	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(new Integer(node));
    }
    
    public int pop() throws Exception {
    
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop().intValue();
    }
}
