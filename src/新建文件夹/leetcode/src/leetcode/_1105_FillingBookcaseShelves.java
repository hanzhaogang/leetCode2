package leetcode;
/*
We have a sequence of books: the i-th book has thickness books[i][0] 
and height books[i][1].

We want to place these books in order onto bookcase shelves 
that have total width shelf_width.

We choose some of the books to place on this shelf 
(such that the sum of their thickness is <= shelf_width), 
then build another level of shelf of the bookcase 
so that the total height of the bookcase has increased by 
the maximum height of the books we just put down.  
We repeat this process until there are no more books to place.

Note again that at each step of the above process, 
the order of the books we place 
is the same order as the given sequence of books.  
For example, if we have an ordered list of 5 books, 
we might place the first and second book onto the first shelf, 
the third book on the second shelf, 
and the fourth and fifth book on the last shelf.

Return the minimum possible height 
that the total bookshelf can be after placing shelves in this manner.

 

Example 1:

Input: books = [[1,1],[2,3],[2,3],[1,1],[1,1],[1,1],[1,2]], shelf_width = 4
Output: 6
Explanation:
The sum of the heights of the 3 shelves are 1 + 3 + 2 = 6.
Notice that book number 2 does not have to be on the first shelf.
 * 
 */

public class _1105_FillingBookcaseShelves {
	int[] memo;
	public int minHeightShelves(int[][] books, int shelf_width) {
		memo=new int[books.length];
		for(int i=0;i<memo.length;i++) {
			memo[i]=-1;
		}
		return helper(books,shelf_width,0);
	}
	
	private int helper(int[][] books,int shelf_width,int lo) {
		if(lo==books.length)
			return 0;
		
		if(memo[lo]!=-1) {
			return memo[lo];
		}
		
		int widthSum=0;
		int max=0;
		int minHeight=Integer.MAX_VALUE;
		for(int hi=lo;hi<books.length;hi++) {
			widthSum+=books[hi][0];
			if(max<books[hi][1]) {
				max=books[hi][1];
			}
			if(shelf_width<widthSum) {
				break;
			}
			
			int curHeight=max+helper(books,shelf_width,hi+1);
			if(curHeight<minHeight) {
				minHeight=curHeight;
			}
		}
		memo[lo]=minHeight;
		return minHeight;
	}
}
