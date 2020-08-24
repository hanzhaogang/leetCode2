package leetCode;

class Solution {
    public int primePalindrome(int N) {
        int[] check = new int[]{2, 2, 2, 3, 5, 5, 7, 7, 11, 11, 11, 11};//len=12
        if(N < check.length && check[N] > 0) return check[N];
        for(;;) {
            
            String cs = String.valueOf(N);
            // 新增了一个判断，用于跳过数字长度为偶数的区间
            if ((cs.length() & 1) == 0) {
                N = (int) Math.pow(10, cs.length()) + 1;
                continue;
            }
            // 原代码
            int mod = N % 6;
            if((mod == 1 || mod == 5)) {
                boolean isPrime = true, isPalindrome = true;
                for(int i=5, j = 0,
                    L1 = (int) Math.sqrt(N),
                    strLen = cs.length(),
                    L2 = strLen >> 1;
                    i <= L1 || j < L2;
                    i+=6, ++j) {
                    if(i <= L1 && (N % i == 0 || N % (i + 2) == 0)) {
                        isPrime = false;
                        break;
                    }
                    if (j < L2 && cs.charAt(j) != cs.charAt(strLen - j - 1)) {
                        isPalindrome = false;
                        break;
                    }
                }
                if(isPrime && isPalindrome) {
                    return N;
                }
                N = mod == 1? N + 4: N + 2;
            } else {
                N = mod == 0? N + 1: N + (5 - mod);
            }
        }
    }
}