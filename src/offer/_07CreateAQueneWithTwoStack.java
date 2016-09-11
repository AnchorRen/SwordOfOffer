package offer;

import java.util.Stack;

/**
 * 题目描述

	用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
	
   思路：
   	举个例子说明：
   		首先空队列中加入三个元素。1，2，3.
   		这三个数字压入栈stack1中。
   		此时从队列中取出一个元素，此时，应该取出最早进队列的1.
   		此时1在stack的栈底。此时，依次从stack1中取出元素，压入栈stack2中。
   		此时stack2中的元素顺序为3,2,1。stack1为空。此时stack2弹出顺序即使入栈的顺序。
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
    
    	//先判断stack2是否为空，不为空则直接弹出，为空则需要从stack1中转移。
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop().intValue();
    }
}
