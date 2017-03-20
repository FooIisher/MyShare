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
		LinkNode head = null ;
		int num =sc.nextInt();
			LinkNode temp = null ;
			for(int i=0;i<num;i++){
				if(i==0){
					head = new LinkNode(sc.nextInt());
					temp = head;
				}else{
					temp.next= new LinkNode(sc.nextInt());
					temp=temp.next;
				}
				
			}
		sc.close();
		System.out.println(head.toString());
//		System.out.println("reverseLink: "+ reverseLink(head).toString());
//		System.out.println("getMiddleLink: "+ getMiddleLinkNode(head).toString());
//		LinkNode middle = getMiddleLinkNode(head);
//		LinkNode left = head;
//		LinkNode right = middle.next;
//		middle.next =null;
//		System.out.println("mergeDoubleLinks: "+ mergeDoubleLinks(left,right).toString());
		
//		System.out.println("mergeSortLink: "+ mergeSort(head).toString());
//		System.out.println("insertSortLink: " + insertSort(head).toString());
//		System.out.println("complicatedSortLink: " + complicatedSort(head).toString());

//		System.out.println("checkMirroLink1: " + checkMirroLink1(head));
		System.out.println("checkMirroLink2: " + checkMirroLink2(head));
	}
	
	/**
	 * 检查一个链表是否是镜像链表
	 * 利栈来协助对比
	 * @param head
	 * @return
	 */
	private static boolean checkMirroLink2(LinkNode head) {
		long start = System.currentTimeMillis();
		Stack<Integer> stack = new Stack<Integer>();
		LinkNode temp = head;
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
	private static boolean checkMirroLink1(LinkNode head) {
		long start = System.currentTimeMillis();
		LinkNode mid = getMiddleLinkNode(head);
		LinkNode lastReversed = reverseLink(mid.next);
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
	 public boolean hasCycle(LinkNode head) {
	        
	        if(head != null){
	        	LinkNode fast = head;
	        	LinkNode slow = head;
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
	private static LinkNode complicatedSort(LinkNode head) {
		LinkNode mid = getMiddleLinkNode(head);
		LinkNode right = mid.next;
		LinkNode left = head;
		mid.next = null; 
		return mergeDoubleLinksByTurns(left, reverseLink(right));
	}

	/**
	 * 将两个链表元素依次互相插入
	 * @param left
	 * @param right
	 * @return
	 */
	private static LinkNode mergeDoubleLinksByTurns(LinkNode left,
			LinkNode right) {
		LinkNode result = new LinkNode(0);
		LinkNode temp = result; 
		while(right!=null||left!=null){
			if(left!=null){
				temp.next = new LinkNode(left.val);
				left = left.next;
				temp = temp.next;
			}
			
			if(right!=null){
				temp.next = new LinkNode(right.val);
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
	private static LinkNode insertSort(LinkNode head) {
		LinkNode result = null;
		if(head==null||head.next==null){
			result =head;
		}else{
			result = new LinkNode(head.val);
			head =head.next;
			while(head!=null){
				if(head.val<result.val){
					LinkNode temp = new LinkNode(head.val);
					temp.next =result;
					result =temp;
				}else{
					LinkNode temp = result;
					if(temp.next!=null){
						while(temp.next!=null && temp.next.val<head.val){
							temp =temp.next;
						}
						if(temp.next != null){
						LinkNode insert = new LinkNode(head.val);
						insert.next = temp.next;
						temp.next = insert;
						}else{
							temp.next = new  LinkNode(head.val);
						}
					}else{
						temp.next = new  LinkNode(head.val);
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
	private static LinkNode mergeSort(LinkNode head) {
		if(head==null||head.next==null){
			   return head;
		}
		LinkNode mid = getMiddleLinkNode(head);
		LinkNode right = mid.next;
		mid.next = null;
		LinkNode left = head;
		return mergeDoubleSortLinks(mergeSort(left),mergeSort(right));
	}

	/**
	 * 对于两个有序链表进行合并排序
	 * @param left
	 * @param right
	 * @return
	 */
	private static LinkNode mergeDoubleSortLinks(LinkNode left, LinkNode right) {
		LinkNode result = new LinkNode(0);
		LinkNode temp = result;
		
		if(left==null){
			result =right;
		}
		if(right==null){
			result =left;
		}
		
		while(left!=null&&right!=null){
			
			if(left.val<right.val){
				temp.next = new LinkNode(left.val);
				temp=temp.next;
				left = left.next;
			}else{
				temp.next = new LinkNode(right.val);
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
	private static LinkNode getMiddleLinkNode(LinkNode head) {
		LinkNode slow = head;
		LinkNode fast = head;
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
	
	private static LinkNode reverseLink(LinkNode head) {
		LinkNode result = null ;
		if(head==null){
			return result;
		}
		
		if(head.next==null){
			result = head;
		}else{
			LinkNode temp = result ;
			while(head!=null){
				temp = result;
				result = new LinkNode(head.val);
				result.next = temp;
				head = head.next;
			}
		}
		return result;
	}

	

	
}
