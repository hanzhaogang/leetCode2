class Solution {
    public int[] memLeak(int memory1, int memory2) {
        for(int i=1;i<=Integer.MAX_VALUE;i++){
            if(memory1<memory2){
                if(memory2<i){
                    return new int[] {i,memory1,memory2};
                }else{
                    memory2-=i;
                    continue;
                }
            }else{
                if(memory1<i){
                    return new int[]{i,memory1,memory2};
                }else{
                    memory1-=i;
                    continue;
                }
            }
        }

        return null;
    }
}