3.3435 => 3.344 
3.6895 => 3.690


3.9287 => 3.929
3.2732 => 3.273


弹性存储 


3.3125 => 3.312
3.8765 => 3.876 

rounding. 四舍五入 1-4，5,6-9；
五五开
公平一些。

5.88501 => 5.88 001-999 500


//strong.
public double roundMethod(double d,int n){//5.0
    //<=n

    //n<
    String s=Double.valueOf(d);
    String[] parts=s.split(".");
    if(parts.length==1){
        return d;
    }

    int part1=Integer.parseInt(parts[1]);
    double res=0.0;
    res+=part1;

    //
    String part2=parts[1];
    if(part2.length()<=n){
        return d;
    }

    if(n+1<part2.length()){
        return Math.round(d);
    }

    //
    char c=part2.charAt(part2.length()-1);
    if((c-'0')%2==0){
        String p2Str=part2.subString(0,n);
        res+=String.parseDouble("0."+p2Str);
    }else{
        //

    }

    return res;
}


/*
Hire 
*Feedback:I would provide a weak hire for this candidate to continue the loop. In case we miss a good senior candidate.

English: Fair.    Communication: Good.   Logic thinking and mindset: Good.    Coding: Fair

Overall his mindset and logic thinking are not bad. English is fair but overall communication skill is good. During daily work he will put more time on ML related work, but also take care service development.

I asked a rounding method coding question. 
He can figure out rule quickly but his coding is kinda concern to me, 
since he can provide a good description of logic how he plan to implement, 
but took more time than expected to finish the first draft version, 
function is OK, but little bit chatty and missed some cases like negative number. 
*/