package bd;
/*
 * sqrt和交叉链接链表问题
 * 
第一轮 design hashMap 的get() put()函数。
我给出的答案跟利口官方答案很类似，面试官问了我两个follow up. 
一是如何优化hash conflict, 
后来查资料发现bucket 使用红黑树可以优化hash conflict的查询时间。
二是rehash每次扩容2倍是固定的还是有意义的，
这个我也没答上来，后来查了资料这个扩容参数不是固定的， 是oracle根据实验设定的一个动态的值。  

第二轮 实现minHeap。这个就简单了，不详细说了。

第三轮 word ladder1.5 在图上返回任意一条最短路径。
没时间写最优解，聊天40分钟，剩下20分钟给我出这个题。
只能采用bfs，在遍历图中记录路径。最终也让我过了。


链表归并排序，写的磕磕绊。这个网站可以运行代码，所以写了几个test case跑了一下


一面： 力扣 1259 329（一轮2个hard我也是服气的）
二面： 半小时简历，半小时设计一个类似google map里的换乘导航系统
三面： 半小时简历，半小时设计一个关注系统，类似于news feed的简化版

三面可能挂在有几个奇怪点答得不好：
1. 关注列表按时间排序，问我分页情况下用户取关，如何快速cache。比如1000个follower里删除第一个， 导致每一页的数据都发生变化，需要重新query，如何优化。
我基本按照这里的思路答得https://www.freecodecamp.org/new ... ntent-c8ddc8269e81/ 每页只存id，id再单独query获取全部data，但面试官还是不满意，我也没想出什么好办法。
2. 一个batch job每天要扫描全部用户的follow 关系，导致cache 过载，如何优化
我答可以用lfu cache，面试官说假设用这个batch job的team不清楚我们技术细节；
我答可以提供一个不写入 cache的方法给他们用，面试官好像还是不太满意；
我也没明白这个到底想考什么。
3. 还问了些apigateway有什么作用之类的，答了一部分，没答全，面试官说了句这个问题就先问到这里就move on了

总体感觉确实国内技术文化和弯曲有些差别。问题问的天马行空不按套路出牌，并且总是希望你一个踩分点也不能少，都要最优解，和考试差不多。我一个做full stack的怎么就搞起cache 优化了呢。
而湾区可能更倾向于你在自己的domain里有见，有“一技之长”就给过。
当然面试官三轮都比较nice，没有出现其他面经里很rude的情况。

最后请教下1.2题到底有什么好方法。


ansible和salt，puppet这种运维工具 scp rsync docker image的p2p下载
真要裸传的话，baremetal数据中心有serial port啥的。。。岂不是更快？
真要扩展开我还能问怎么给一万台服务器安装ubuntu呢。。
搞scp不如rsync，rsync不如puppet/ansible/salt，用过的人都懂。。。


编程题
given a circle with 10 nodes, 0->1->2....->9->0, start from 0 node, if allow to move n steps, what is the total number of different paths that the move ends at 0 (start point and end point are same).
For example,

n = 2, total number of different paths = 2: 0->1->0, 0->9->0
n = 4, total number of different paths = 4: 0->1->2->1->0, 0->9->8->9->0, 0->1->0->9->0, 0->9->0->1->0


p? dp[i, k]存的是走了k步走到i的路线数
dp初始化全为0，起点在0，dp[0,0] = 1
每次可以往左或者往右走一步，且是环
所以dp[i, k] = dp[(i+1)%10, k-1] + dp[(i-1)%10, k-1]
最后返回dp[0, n]
然后每次更新第k列的时候，都只会用到k-1列，所以可以用rolling dp[i, k&1] 把空间降到O(20)*/
public class bd {

}


/*
 * 枪打出头鸟
限定语言：Python、C++、Javascript、Python 3、Java、Go
题意

现在有n个人站成一列，第i个人的身高为。
他们人手一把玩具枪，并且他们喜欢把枪举在头顶上。
每一次练习射击，他们都会朝正前方发射一发水弹。
这个时候，第i个人射击的水弹，就会击中在他前面第一个比他高的人。
牛牛认为这样的练习十分的荒唐，完全就是对长得高的人的伤害。
于是它定义了一个荒唐度，初始为0。
对于第i个人，如中他击中了第j个人，则荒唐度加j，如果没有击中任何人，则荒唐度加0.
牛牛想问你，你能计算出荒唐度是多少吗？
输入

一个整数n()
一个数组a()
a下标从0开始，
输出
一个整数X(代表荒唐度的大小)
示例1
输入

5,[1,2,3,4,5]

输出

0

说明

没有一个人击中任何一个人

示例2
输入

5,[5,4,3,2,1]

输出

10

说明

第二个人击中第一个人，第三个人击中第二个人，第四个人击中第三个人，第五个人击中第四个人； 1+2+3+4=10
 */

import java.util.*;


public class Solution {
    public static void main(String[] args){
        //Solution s=new Solution();
        int[] array=new int[]{5,4,3,2,1};
        System.out.println(solve(5,array));
    }
    /**
     * 
     * @param n int整型 n个人
     * @param a int整型一维数组 ai代表第i个人的高度
     * @return long长整型
     */
   public static long solve (int n, int[] a) {//sovle, typo.
        // write code here
        
//        Deque<Integer> stack=new ArrayDeque<>();
        Deque<Integer> stack=new LinkedList<>();
        
        long res=0;
        
        for(int i=a.length-1;0<=i;i--){//4,3
            if(stack.isEmpty()||a[i]<=a[stack.peek()]){//比较必须一致
                stack.push(i);//4
            }else{
                while(!stack.isEmpty()&&a[stack.peek()]<a[i]){
//                    int curIndex=stack.pop();//4
                    res+=i+1;//index,不应该+curIndex。
                }
                stack.push(i);//add the current element.
            }
        }
        
        return res;
    }
}


模型压缩

监控？ nagios？

AB tesing? 置信区间。

		使用deep模型做算法，ab test衡量算法end-to-end的效果；
		然后用统计分析方法或者ml的方法做模型解释，或者是建模前的特征分析。
		
		
日志 ELK
配置： scp rsync ansiable salt puppet





