package linkList;


import java.util.Scanner;
import java.util.Stack;



/**
 * 
 * @author fish
 *
 */
public class LinkRun {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ListNode head = null ;
		int num =sc.nextInt();
			ListNode temp = null ;
			for(int i=0;i<num;i++){
				if(i==0){
					head = new ListNode(sc.nextInt());
					temp = head;
				}else{
					temp.next= new ListNode(sc.nextInt());
					temp=temp.next;
				}
				
			}
		sc.close();
		System.out.println(head.toString());
//		System.out.println("reverseLink: "+ reverseLink(head).toString());
//		System.out.println("getMiddleLink: "+ getMiddleListNode(head).toString());
//		ListNode middle = getMiddleListNode(head);
//		ListNode left = head;
//		ListNode right = middle.next;
//		middle.next =null;
//		System.out.println("mergeDoubleLinks: "+ mergeDoubleLinks(left,right).toString());
		
//		System.out.println("mergeSortLink: "+ mergeSort(head).toString());
//		System.out.println("insertSortLink: " + insertSort(head).toString());
		System.out.println("complicatedSortLink: " + complicatedSort(head).toString());

//		System.out.println("checkMirroLink1: " + checkMirroLink1(head));
//		System.out.println("checkMirroLink2: " + checkMirroLink2(head));
//		System.out.println("deleteDuplication: " + deleteDuplication(head).toString());
	}
	/**
	 * 删除重复的节点
	 * @param pHead
	 * @return
	 */
	 public static ListNode deleteDuplication(ListNode pHead){
		 
		 ListNode perior = new ListNode(-1);
		 perior.next = pHead;
		 ListNode last = perior;
		 ListNode temp = pHead;
		 while(temp!=null&&temp.next!=null){
			 if(temp.val==temp.next.val){
				 int val = temp.val;
				 while(temp!=null&&temp.val==val){
					 temp = temp.next;
				 }
				 last.next = temp;
			 }else{
				 last = temp;
				 temp = temp.next;
			 }
		 }
	    
	     return perior.next;  
	}
	
	/**
	 * 检查一个链表是否是镜像链表
	 * 利栈来协助对比
	 * @param head
	 * @return
	 */
	private static boolean checkMirroLink2(ListNode head) {
		long start = System.currentTimeMillis();
		Stack<Integer> stack = new Stack<Integer>();
		ListNode temp = head;
		int length =0;
		while(temp!=null){
			stack.add(temp.val);
			temp=temp.next;
			length++;
		}
		
		while(stack.size()>length/2){
			if(head.val==stack.pop()){
				head=head.next;
			}else{
				System.out.println("checkMirroLink2 used: "+ (System.currentTimeMillis()-start));
				return false;
			}
		}
		System.out.println("checkMirroLink2 used: "+ (System.currentTimeMillis()-start));
		return true;
	}


	/**
	 * 检查一个链表是否是镜像链表
	 * 利用找到终点在翻转后半部分 在依次与前半部分对比
	 * @param head
	 * @return
	 */
	private static boolean checkMirroLink1(ListNode head) {
		long start = System.currentTimeMillis();
		ListNode mid = getMiddleListNode(head);
		ListNode lastReversed = reverseLink(mid.next);
		mid.next = null;
		while(head!=null&&lastReversed!=null){
			if(head.val==lastReversed.val){
				head = head.next;
				lastReversed = lastReversed.next;
			}else{
				System.out.println("checkMirroLink1 used: "+ (System.currentTimeMillis()-start));
				return false;
			}
		}
		System.out.println("checkMirroLink1 used: "+ (System.currentTimeMillis()-start));
		return true;
	}


	/**
	 * 判断一个单链表是否存在环
	 * @param head
	 * @return
	 */
	 public boolean hasCycle(ListNode head) {
	        
	        if(head != null){
	        	ListNode fast = head;
	        	ListNode slow = head;
	            while(fast!=null&&fast.next!=null){
	                fast = fast.next.next;
	                slow = slow.next;
	                if(fast == slow){
	                    return true;
	                }
	            }
	        }
	       	
	        
	        return false;
	    }
	
	/**
	 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
	 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
	 * @param head
	 * @return
	 */
	private static ListNode complicatedSort(ListNode head) {
		ListNode mid = getMiddleListNode(head);
		ListNode right = mid.next;
		ListNode left = head;
		mid.next = null; 
		return mergeDoubleLinksByTurns(left, reverseLink(right));
	}

	/**
	 * 将两个链表元素依次互相插入
	 * @param left
	 * @param right
	 * @return
	 */
	private static ListNode mergeDoubleLinksByTurns(ListNode left,
			ListNode right) {
		ListNode result = new ListNode(0);
		ListNode temp = result; 
		while(right!=null||left!=null){
			if(left!=null){
				temp.next = new ListNode(left.val);
				left = left.next;
				temp = temp.next;
			}
			
			if(right!=null){
				temp.next = new ListNode(right.val);
				right = right.next;
				temp = temp.next;
			}	
		}
		
		return result.next;
	}

	/**
	 * 实现链表的插入排序
	 * @param head
	 * @return
	 */
	private static ListNode insertSort(ListNode head) {
		ListNode result = null;
		if(head==null||head.next==null){
			result =head;
		}else{
			result = new ListNode(head.val);
			head =head.next;
			while(head!=null){
				if(head.val<result.val){
					ListNode temp = new ListNode(head.val);
					temp.next =result;
					result =temp;
				}else{
					ListNode temp = result;
					if(temp.next!=null){
						while(temp.next!=null && temp.next.val<head.val){
							temp =temp.next;
						}
						if(temp.next != null){
						ListNode insert = new ListNode(head.val);
						insert.next = temp.next;
						temp.next = insert;
						}else{
							temp.next = new  ListNode(head.val);
						}
					}else{
						temp.next = new  ListNode(head.val);
					}
				}
				
				head =head.next;
			}
		}

		return result;
	}

	/**
	 * 实现俩表的归并排序
	 * @param head
	 * @return
	 */
	private static ListNode mergeSort(ListNode head) {
		if(head==null||head.next==null){
			   return head;
		}
		ListNode mid = getMiddleListNode(head);
		ListNode right = mid.next;
		mid.next = null;
		ListNode left = head;
		return mergeDoubleSortLinks(mergeSort(left),mergeSort(right));
	}

	/**
	 * 对于两个有序链表进行合并排序
	 * @param left
	 * @param right
	 * @return
	 */
	private static ListNode mergeDoubleSortLinks(ListNode left, ListNode right) {
		ListNode result = new ListNode(0);
		ListNode temp = result;
		
		if(left==null){
			result =right;
		}
		if(right==null){
			result =left;
		}
		
		while(left!=null&&right!=null){
			
			if(left.val<right.val){
				temp.next = new ListNode(left.val);
				temp=temp.next;
				left = left.next;
			}else{
				temp.next = new ListNode(right.val);
				temp=temp.next;
				right = right.next;
			}
			
			if(left==null){
				temp.next=right;
			}
			
			if(right==null){
				temp.next=left;
			}
			
		}
		return result.next;
	}

	/**
	 * 获取链表的中间节点
	 * @param head
	 * @return
	 */
	private static ListNode getMiddleListNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next!=null&&fast!=null){
			if(fast.next.next!=null){
				fast=fast.next.next;
				slow=slow.next;
			}else{
				fast=fast.next;
			}
		}
		return slow;
	}

	/**
	 * 倒置一个链表
	 * @param head
	 * @return
	 */
	
	private static ListNode reverseLink(ListNode head) {
		ListNode result = null ;
		if(head==null){
			return result;
		}
		
		if(head.next==null){
			result = head;
		}else{
			ListNode temp = result ;
			while(head!=null){
				temp = result;
				result = new ListNode(head.val);
				result.next = temp;
				head = head.next;
			}
		}
		return result;
	}

	

	
}
