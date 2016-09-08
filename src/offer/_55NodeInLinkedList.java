package offer;

import offer._05PrintListReversingly.ListNode;

/**
 * 链表中环的入口结点
 * 	一个链表中包含环，请找出该链表的环的入口结点。
 * 
 * 思路：
 * 		<1>.找环中的相会点。定义连个指针p1,p2均指向链表头结点。p1每次走1步，p2每次走2步。由于存在环，最终连个指针都会进入
 * 			环中。两个指针会在环中相遇。
 * 		<2>.找入口节点。此时p2走了 2x 则p1走了x步。假设环中共有n个节点。可知p2比p1多走的步数是环中节点n的整数倍。
 * 			此时，再让p2指向头结点，两个节点以1的步速移动，由于此时p1比p2多走了 环的整数倍。所以，在相遇的的结点就是
 * 			环的入口。
 * 
 * @author REN
 * @date 2016年9月8日 下午7:49:07
 */
public class _55NodeInLinkedList {

	 public ListNode EntryNodeOfLoop(ListNode pHead)
	    {
	        if(pHead == null || pHead.next == null)
	        	return null;
	        ListNode p1 = pHead;
	        ListNode p2 = pHead;
	        while(p2 != null && p2.next != null){
	        	p1 = p1.next;
	        	p2 = p2.next.next;
	        	if(p2 == p1){
	        		p2 = pHead;
	        		while(p1 != p2){
	        			p1 = p1.next;
	        			p2 = p2.next;
	        		}
	        		if(p1 == p2){
	        			return p1;
	        		}
	        	}
	        }
			return null;
	        
	    }
	 
	 public class ListNode {
		    int val;
		    ListNode next = null;

		    ListNode(int val) {
		        this.val = val;
		    }
		}
}
