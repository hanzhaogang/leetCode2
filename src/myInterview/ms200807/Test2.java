package ms200807;

import java.util.Deque;



public class Test2 {
/*
 * postorder
 * 
 * 
 *      1
 *   3     5
 * 6  7   8  9 
 *  4 
 *  
 *     
 *     
 *   4 6 7 3   8 9 5   1
 *  
 *  
 *  
 *  8
 *  5
 *  1
 * Hire Recommendation:No Hire 
*Feedback:
*Project Experience: 
*Focused on one micro service to dispatch the picture recogonization model request to Redis middle ware. 
*And used redis cache to cache the picture for dupicate.

System Design: Not good enough.
 When introducing the system, 
 the candidate seems has some miss understanding of the pub/sub of message middle ware. 
 And there are lots of design pit falls in the system, 
 like no common service for dispatch message between web and api service, 
 no cetral place to do auth, Instead just directly access DB for user credential. 
 But the candidate only aware of these issues after I ask more questions.

Algorithm: Below average. 
Cannot work out the non-recurisive version of post-order traverse of binary tree.

Communication: average.

Based on the above, not recommended. 
 */
	
	public Deque<TreeNode> postorder(Node root) {
		Deque<Node> s=new ArrayDeque<>();
		
		Node p=root;
		while(p.left!=null) {//6
			p=root.left;
			s.push(p);
		}//1,3 
		
		while(p.right!=null) {
			p=root.right;
			s.push(p);
		}
		//1
		
		

		
		
		while(!s.isEmpty()) {
			Node top=s.pop();
			System.out.println(top.right.val);
			top.right=null;
		}
	}
	
	
	public void postOrder_recursion(Node root) {
		if(root==null) {
			return;
		}
		
		postOrder_recursion(root.left);
		System.out.println(root.val);
		postOrder_recursiont(root.right);
	}
}
