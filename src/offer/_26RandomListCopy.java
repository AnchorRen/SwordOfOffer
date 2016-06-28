package offer;
/**
 * 	题目描述

		输入一个复杂链表（每个节点中有节点值，以及两个指针，
		一个指向下一个节点，另一个特殊指针指向任意一个节点）
	
	
 * @author REN
 * @date 2016年6月28日 上午8:39:29
 */
public class _26RandomListCopy {

	public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null)
        	return null;
        RandomListNode pCur = pHead;
        //1.复制除random外的结点，拼接到原链表之后。原来的A->B->C 变为A->A'->B->B'->C->C'
        while(pCur != null){
        	RandomListNode node = new RandomListNode(pCur.label);
        	node.next = pCur.next;
        	pCur.next = node;
        	pCur = node.next;
        }
        
       //2.复制rondom结点
        pCur = pHead;
        while(pCur != null){
        	if(pCur.random != null)
        		pCur.next.random = pCur.random.next;
        	pCur = pCur.next.next;
        }
        
        //3.对链表进行查分，拆分出复制的链表和原链表
        RandomListNode head = pHead.next;
        RandomListNode cur = head;
        pCur = pHead;
        while(pCur != null){
        	pCur.next = pCur.next.next;
        	if(cur.next != null)
        		cur.next = cur.next.next;
        	cur = cur.next;
        	pCur = pCur.next;
        }
        return head;
    }
	
	public class RandomListNode {
	    int label;
	    RandomListNode next = null;
	    RandomListNode random = null;

	    RandomListNode(int label) {
	        this.label = label;
	    }
	}
}
