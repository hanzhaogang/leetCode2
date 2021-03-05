package fb2020;
import java.util.List;
import java.util.Map;

/*
 * Suppose we have very large sparse vectors (most of the elements in vector are zeros)

    Find a data structure to store them
    Compute the Dot Product.

Follow-up:
What if one of the vectors is very small?
 */
public class _1570_DotProductofTwoSparseVectors_ {
	//HashMap. 
	public int dotProduct(Map<Integer, Integer> vec1, Map<Integer, Integer> vec2) {
		Map<Integer,Integer> index2val_short=vec1;
		Map<Integer,Integer> index2val_long=vec2;
		if(index2val_long.size()<index2val_short.size()) {
			Map<Integer,Integer> temp=index2val_short;
			index2val_short=index2val_long;
			index2val_long=temp;
		}
		
		int res=0;
		for(Map.Entry<Integer, Integer> e:index2val_short.entrySet()) {
			res+=e.getValue()*(index2val_long.getOrDefault(e.getKey(), 0));
		}
		return res;
	}
	
	//Two Pointers. O(m+n)
	public int dotProduct(List<Pair> vec1,List<Pair> vec2) {
		int p1=0;
		int p2=0;
		
		int res=0;
		while(p1<vec1.size()&&p2<vec2.size()) {
			Pair pair1=vec1.get(p1);
			Pair pair2=vec2.get(p2);
			if(pair1.getIndex()==pair2.getIndex()) {
				res+=pair1.getVal()*pair2.getVal();
			}else if(pair1.getIndex()<pair2.getIndex()) {
				p1++;
			}else {
				p2++;
			}
		}
		
		return res;
	}
	
	// If one is big, one is small, iterate over small, and do a binary search in the big one. O(m*logn)
}

class Pair{
	int index;
	int val;
	
	public int getIndex() {
		return index;
	}
	public int getVal() {
		return val;
	}
}
//import java.util.HashMap;
//import java.util.Map;

//public class SparseVectorMultiplication {
//
//    public static void main(String[] args) {
//        int[] vector1 = {1, 0, 0, 0, 0, 0, 5, 0, 0, 6, 0, 90, 0, 100};
//        int[] vector2 = {9, 0, 0, 5, 0, 18, 0, 0, 6, 0, 0, 2, 100};
//
//        SparseVectorMultiplication sp = new SparseVectorMultiplication(vector1, vector2);
//        System.out.println(sp.dotProduct());
//    }
//
//    // Stores index as key and value as value.
//    private Map<Integer, Integer> vector1;
//
//    private Map<Integer, Integer> vector2;
//
//    // Time: O(N) + O(M)
//    // Space: O(N) + O(M)
//    public SparseVectorMultiplication(int[] vector1, int[] vector2) {
//        this.vector1 = new HashMap<>();
//        this.vector2 = new HashMap<>();
//        // Make vector 1 always bigger than vector 2
//        // Follo-up
//        if (vector1.length < vector2.length) {
//            int[] temp = vector2;
//            vector1 = vector2;
//            vector2 = temp;
//        }
//
//        for (int i = 0; i < vector1.length; i++) {
//            if (vector1[i] != 0) {
//                this.vector1.put(i, vector1[i]);
//            }
//        }
//
//        for (int i = 0; i < vector2.length; i++) {
//            if (vector2[i] != 0) {
//                this.vector2.put(i, vector2[i]);
//            }
//        }
//    }
//
//    // Time: O(Min(M,N))
//    public long dotProduct() {
//        int product = 0;
//        for (Map.Entry<Integer, Integer> entry : this.vector2.entrySet()) {
//            product += entry.getValue() * this.vector1.getOrDefault(entry.getKey(), 0);
//        }
//        return product;
//    }
//}
