// Problem Statement - Leetcode 2043 - https://leetcode.com/problems/simple-bank-system/

// My Solution

class Bank {
    private long[] accounts;

    public Bank(long[] balance) {
        accounts = new long[balance.length];
        for(int i=0; i< balance.length; i++){
            accounts[i] = balance[i];
        }
    }
    
    public boolean transfer(int account1, int account2, long money) {
        boolean validAccount1 = verifyAccount(account1);
        boolean validAccount2 = verifyAccount(account2);
        if(!validAccount1 || !validAccount2){
            return false;
        }
        if(accounts[account1-1] < money){
            return false;
        }
        deposit(account2, money);
        withdraw(account1, money);
        return true;
    }
    
    public boolean deposit(int account, long money) {
        boolean validAccount = verifyAccount(account);
        if(!validAccount){
            return false;
        }
        accounts[account-1] += money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        boolean validAccount = verifyAccount(account);
        if(!validAccount){
            return false;
        }
        if(accounts[account-1] >= money){
            accounts[account-1] = accounts[account-1] - money;
            return true;
        }
        return false;
    }

    private boolean verifyAccount(int account){
        if(account < 1 || account > accounts.length){
            return false;
        }
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */
