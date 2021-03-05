package leetcode;
/*
 * Convert a BST to a sorted circular doubly-linked list in-place. 
 * Think of the left and right pointers as synonymous to 
 * the previous and next pointers in a doubly-linked list.

Let's take the following BST as an example, 
it may help you understand the problem better:


We want to transform this BST into a circular doubly linked list. 
Each node in a doubly linked list has a predecessor and successor. 
For a circular doubly linked list, 
the predecessor of the first element is the last element, 
and the successor of the last element is the first element.


The figure below shows the circular doubly linked list for the BST above. 
The "head" symbol means 
the node it points to is the smallest element of the linked list.


Specifically, we want to do the transformation in place. 
After the transformation, 
the left pointer of the tree node should point to its predecessor, 
and the right pointer should point to its successor. 
We should return the pointer to the first element of the linked list.

The figure below shows the transformed BST. 
The solid line indicates the successor relationship, 
while the dashed line means the predecessor relationship.


Example 1:

Input: {4,2,5,1,3}
        4
       /  \
      2   5
     / \
    1   3
Output: "left:1->5->4->3->2  right:1->2->3->4->5"
Explanation:
Left: reverse output
Right: positive sequence output

Example 2:

Input: {2,1,3}
        2
       /  \
      1   3
Output: "left:1->3->2  right:1->2->3"


 */
public class _426_ConvertBinarySearchTreetoSortedDoublyLinkedList_1534 {
    public TreeNode treeToDoublyList(TreeNode root) {
    	TreeNode[] headTail=helper(root);
    	TreeNode head=headTail[0];
    	TreeNode tail=headTail[1];
    	if(head==null)
    		return null;
    	head.left=tail;
    	tail.right=head;
    	return head;
    }
    
    private TreeNode[] helper(TreeNode root) {
    	if(root==null) {
    		return new TreeNode[] {null,null};
    	}
    	
    	TreeNode[] headTail_l=helper(root.left);
    	TreeNode[] headTail_r=helper(root.right);
    	
    	if(headTail_l[1]!=null) {
    		headTail_l[1].right=root;
    	}
    	root.left=headTail_l[1];
    	root.right=headTail_r[0];
    	if(headTail_r[0]!=null) {
    		headTail_r[0].left=root;
    	}
    	
    	return new TreeNode[] {headTail_l[0]==null?root:headTail_l[0],
    			headTail_r[1]==null?root:headTail_r[1]};
    }
}
