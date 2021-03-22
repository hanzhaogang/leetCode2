/*
Given a stream of integers and a window size, 
calculate the moving average of all integers in the sliding window.


Example 1:

MovingAverage m = new MovingAverage(3);
m.next(1) = 1 // return 1.00000
m.next(10) = (1 + 10) / 2 // return 5.50000
m.next(3) = (1 + 10 + 3) / 3 // return 4.66667
m.next(5) = (10 + 3 + 5) / 3 // return 6.00000


思路：
直觉上是使用queue，构造函数初始化这个queue，next函数中，判断queue的长度，如果小于size，则将数字入队，
并遍历一遍queue得到average；如果等于size，则将数字入队，并把队列当前的第一个元素出队，
并根据之前的（average*size-出队元素+入队元素）/size得到当前average。

注意：
Deque是有size属性的，当Deque中元素个数等于size时，不能再继续入队。

第一次提交只通过了83%的test case，有个极大的case没有通过。猜测是做乘法的时候超出范围了？
结果把乘法改为除法，还是没有通过。

猜测是double的多次运算会带来较大误差。所以应该用一个long的sum，只有在求均值的时候才使用double.
*/


public class MovingAverage {
    Deque<Integer> q;
    int cap;
    int count=0;
    // double preAverage=0.0;
    long sum;
    /*
    * @param size: An integer
    */public MovingAverage(int size) {
        // do intialization if necessary
        q=new ArrayDeque<Integer>(size);
        cap=size;
        sum=0L;
    }

    /*
     * @param val: An integer
     * @return:  
     */
    public double next(int val) {
        // write your code here
        int size=q.size();
        if(size<cap){
            q.offer(val);
            // double curAverage=preAverage*((double)size/(double)(size+1))+
            //         (double)val/(double)(size+1);
            // preAverage=curAverage;
            sum+=val;
            return (double)sum/(double)(size+1);
        }else{
            int polled=q.poll();
            q.offer(val);
            // double curAverage=preAverage+(double)(-polled+val)/(double)(cap);
            // preAverage=curAverage;
            sum+=val;
            sum-=polled;
            return (double)sum/(double)cap;
        }
    }
}