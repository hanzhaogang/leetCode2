/*Implement a SnapshotArray that supports the following interface:

SnapshotArray(int length) initializes an array-like data structure with the given length.  Initially, each element equals 0.
void set(index, val) sets the element at the given index to be equal to val.
int snap() takes a snapshot of the array and returns the snap_id: the total number of times we called snap() minus 1.
int get(index, snap_id) returns the value at the given index, at the time we took the snapshot with the given snap_id
 

Example 1:

Input: ["SnapshotArray","set","snap","set","get"]
[[3],[0,5],[],[0,6],[0,0]]
Output: [null,null,0,null,5]
Explanation: 
SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
snapshotArr.set(0,5);  // Set array[0] = 5
snapshotArr.snap();  // Take a snapshot, return snap_id = 0
snapshotArr.set(0,6);
snapshotArr.get(0,0);  // Get the value of array[0] with snap_id = 0, return 5
 

Constraints:

1 <= length <= 50000
At most 50000 calls will be made to set, snap, and get.
0 <= index < length
0 <= snap_id < (the total number of times we call snap())
0 <= val <= 10^9

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/snapshot-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


Use a list of lists, adding both the element and the snap_id to each index.
*/


class SnapshotArray {
    int[] a;
    int snap_id;
    Map<Integer,int[]> snapMap;
    public SnapshotArray(int length) {
        a=new int[length]; 
        snapMap=new HashMap<Integer,int[]>();
        snap_id=-1;
    }
    
    /* O(1)
    */
    public void set(int index, int val) {
        a[index]=val;
    }
    
    /*O(n)
     */
    public int snap() {
        snap_id++;
        int[] snap_array=new int[a.length];
        for(int i=0;i<a.length;i++){
            snap_array[i]=a[i];
        } 
        snapMap.put(snap_id,snap_array);
        return snap_id;
    }
    
    /*
     * O(1)
     */
    public int get(int index, int snap_id) {
        //0<=snpa_id
        //if(this.snap_id<snap_id) return 
        return snapMap.get(snap_id)[index]; 
    }
}


/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */


class SnapshotArray {
    int[] a;
    int snap_id;
    Map<Integer,int[]> snapMap;
    public SnapshotArray(int length) {
        a=new int[length]; 
        snapMap=new HashMap<Integer,int[]>();
        snap_id=-1;
    }
    
    /* O(1)
    */
    public void set(int index, int val) {
        a[index]=val;
    }
    
    /*O(n)
    空间复杂度： snap个数*a.length
     */
    public int snap() {
        snap_id++;
        int[] snap_array=new int[a.length];
        for(int i=0;i<a.length;i++){
            snap_array[i]=a[i];
        } 
        snapMap.put(snap_id,snap_array);
        return snap_id;
    }
    
    /*
     * O(1)
     */
    public int get(int index, int snap_id) {
        //0<=snpa_id
        //if(this.snap_id<snap_id) return 
        return snapMap.get(snap_id)[index]; 
    }
}


class SnapshotArray {
    int[] a;
    int snap_id;
    Map<Integer,Map<Integer,Integer>> snapMap;//1st key is index, 2nd key is snap_id, value is value.

    public SnapshotArray(int length) {
        a=new int[length]; 
        snapMap=new HashMap<Integer,Map<Integer,Integer>>();
        snap_id=0;
    }
    
    /* O(set操作的个数)
    */
    public void set(int index, int val) {
        Map<Integer,Integer> id2valMap=snapMap.get(index)==null?new LinkedHashMap<Integer,Integer>():snapMap.get(index);
        id2valMap.put(snap_id,val);
        snapMap.put(index,id2valMap);
    }
    
    /*O()
    空间复杂度： snap个数*a.length
     */
    public int snap() {
        return snap_id++;
    }
    
    /*
     * O(1)
     */
    public int get(int index, int snap_id) {
        //0<=snpa_id
        //if(this.snap_id<snap_id) return 
        Map<Integer,Integer> id2valMap=snapMap.get(index);
        int val=0;
        if(id2valMap==null){
            return val;
        }
        for(int i=snap_id;0<=i;i--){
            if(id2valMap.containsKey(i)){
                return id2valMap.get(i);
            }
        }
        return val; 
    }
}


class SnapshotArray {
    
    //list.get(index)应为数组下标为index处的值
    //每一个Map记录的是当前下标位置的值的变动，<版本号，新值>
    private List<Map<Integer,Integer>> list;
    private int snapId;

    public SnapshotArray(int length) {
        list = new ArrayList<>();
        for(int i = 0; i < length; i++){
            list.add(new HashMap<Integer,Integer>());
        }
        snapId = 0;
    }
    
    public void set(int index, int val) {
        //在index处放入此次版本更新的值
        list.get(index).put(this.snapId,val);
    }
    
    public int snap() {
        return snapId++;
    }
    
    public int get(int index, int snap_id) {
        //寻找snap_id版本前，最后一次更新的值
        for(int i = snap_id; i >= 0; i--) {
            if (list.get(index).containsKey(snap_id)) {
                return list.get(index).get(snap_id);
            }
            --snap_id;
        }
        return 0;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */

作者：aluji
链接：https://leetcode-cn.com/problems/snapshot-array/solution/java-listmapintegerinteger-shuang-97-by-aluji/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


class SnapshotArray {
    List<TreeMap<Integer, Integer>> arr = new ArrayList<>();
    int snap = 0;
    public SnapshotArray(int length) {
        for (int i=0; i<length; i++)
            arr.add(new TreeMap<>());
    }
    
    public void set(int index, int val) {
        TreeMap<Integer, Integer> tm = arr.get(index);
        tm.put(snap, val);
    }
    
    public int snap() {
        return snap++;
    }
    
    public int get(int index, int snap_id) {
        TreeMap<Integer, Integer> tm = arr.get(index);
        Integer key = tm.floorKey(snap_id);
        return key == null ? 0 : tm.get(key);
    }
}

作者：forzart
链接：https://leetcode-cn.com/problems/snapshot-array/solution/java-shi-yong-treemapzhi-xu-ji-xing-dai-ma-by-forz/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。