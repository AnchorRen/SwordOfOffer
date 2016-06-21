package offer;
/**
 * 
 * 	题目描述

		输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 
 * 思路：
 * 		这题考察思考问题的全面性和对递归的使用。
 * 		当两个链表中有任一个为空的时候如何处理。
 * 
 * @author REN
 * @date 2016年6月21日 下午4:54:24
 */
public class _17MergSortedList {

public ListNode Merge(ListNode list1,ListNode list2) {
	
        if(list1 == null)
        	return list2;
        else if(list2 == null)
        	return list1;
        
        ListNode pMergedHead = null;//合并后链表的头结点
        if(list1.val < list2.val){
        	pMergedHead = list1;
        	pMergedHead.next = Merge(list1.next, list2);//递归剩余的部分
        }else{
        	pMergedHead = list2;
        	pMergedHead.next = Merge(list1, list2.next);
        }
        return pMergedHead;
    }

public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
}
