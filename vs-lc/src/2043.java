public class 2043 {
	
}

/* 应该增加一个check函数，判断account account1 account2的范围。这样不容易出错。因为没有dry。多次repeat的话，容易写错。 */
class Bank {
	long[] balance;
    public Bank(long[] balance) {
	this.balance=balance;
    }
    
    public boolean transfer(int account1, int account2, long money) {
	    if(account1-1<0 || balance.length<=account1-1 || account2-1<0 || balance.length<=account2-1)
	    	return false;

	if(balance[account1-1]<money)
		return false;

	balance[account1-1]-=money;
	balance[account2-1]+=money;
	return true;
    }
    
    public boolean deposit(int account, long money) {
	    if(account-1<0 || balance.length<=account-1)
	    	return false;

	balance[account-1]+=money;
	return true;
    }
    
    public boolean withdraw(int account, long money) {
	if(account-1<0 || balance.length<=account-1)
		return false;
	if(balance[account-1]<money)
		return false;
	balance[account-1]-=money;
	return true;
    }
}
/* 10^4，1 <= n, account, account1, account2 <= 105 */