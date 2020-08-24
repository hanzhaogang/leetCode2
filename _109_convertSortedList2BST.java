package leetCode;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 *     3
 *  1     6
 *      5
 */
public class _109_convertSortedList2BST {
	public TreeNode sortedListToBST(ListNode head) {
		List<Integer> list=new ArrayList<Integer>();
		while(head!=null) {
			list.add(head.val);
			head=head.next;
		}
		int[] arr=list.stream().mapToInt(i->i).toArray();
		
		return convert(arr,0,arr.length-1);//1,3,5,6
	}
	
	private TreeNode convert(int[] arr,int lo,int hi) {
		if(hi<lo)
			return null;
		
		int mid=lo+(hi-lo)/2;//1
		TreeNode root=new TreeNode(arr[mid]);
		root.left=convert(arr, lo, mid-1);
		root.right=convert(arr, mid+1, hi);
		return root;
	}
}
