package offer;

/**
 * 
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 
 * 思路：
 * 		定义两个指针，一个指针从头结点开始遍历链表，直到到达下标为k-2的结点，
 * 		此时第二个指针从头开始遍历。两个指针之间相差k-1个。之后两个指针同时遍历
 * 		当第一个指针到达尾结点的时候，第二个结点恰好指向倒数第k个结点。		
 * 
 * @author REN
 * @date 2016年6月21日 下午4:01:56
 */
public class _15KthNodeFromEnd {

	public ListNode FindKthToTail(ListNode head,int k) {

		//如果head为空或者k<=0,则返回null
		if(head == null || k <= 0)
			return null;
		//定义两个指针
		ListNode pHead = head;
		ListNode pBehind = null;
		
		//第一个指针开始遍历
		for(int i =0;i< k-1;i++){
			if(pHead.next != null)
				pHead = pHead.next;
			else{
				return null;//如果结点数小于k，则返回null
			}
		}
		pBehind = head;
		//两个指针同时开始遍历
		while(pHead.next != null){
			pHead = pHead.next;
			pBehind = pBehind.next;
		}
		
		return pBehind;
    }
	
	
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
}
