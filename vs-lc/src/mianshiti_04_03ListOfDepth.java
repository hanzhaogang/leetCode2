import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class mianshiti_04_03ListOfDepth {
    
}

class Solution {
    public ListNode[] listOfDepth(TreeNode tree) {
        if(tree==null)
            return null;

        Queue<TreeNode> q=new LinkedList<>();
        q.offer(tree);
        List<ListNode> list=new ArrayList<>();
        
        while(!q.isEmpty()){
            int size=q.size();
            ListNode dummyHead=new ListNode(0);
            ListNode p=dummyHead;

            for(int i=0;i<size;i++){
                TreeNode treeNode=q.poll();
                ListNode listNode=new ListNode(treeNode.val);
                
                p.next=listNode;
                p=p.next;
                
                if(treeNode.left!=null)
                    q.offer(treeNode.left);
                if(treeNode.right!=null)
                    q.offer(treeNode.right);
            }

            list.add(dummyHead.next);
        }

        ListNode[] res=new ListNode[list.size()];
        for(int i=0;i<list.size();i++){
            res[i]=list.get(i);
        }
        return res;
    }
}
/*Given a binary tree, design an algorithm which 
creates a linked list of all the nodes at each depth 
(e.g., if you have a tree with depth D, 
you'll have D linked lists). 
Return a array containing all the linked lists.

 

Example:

Input: [1,2,3,4,5,null,7,8]

        1
       /  \ 
      2    3
     / \    \ 
    4   5    7
   /
  8

Output: [[1],[2,3],[4,5,7],[8]]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/list-of-depth-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */*/