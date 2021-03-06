package shubbar.ca;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Mustafa <codingbox@outlook.com>
 * Created at 2021-03-06
 */
public class BankAccount {
    private double balance;
    private String accountNumber;

    private Lock lock;

    public BankAccount(String accountNumber, double balance) {
        this.balance = balance;
        this.accountNumber = accountNumber;

        this.lock = new ReentrantLock();
    }


//    public synchronized void deposit(double amount) {
//        balance += amount;
//    }
//
//    public synchronized void withdraw(double amount) {
//        balance -= amount;
//    }

    public void deposit(double amount) {

        try {
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try{
                    balance += amount;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get the lock");
            }
        } catch(InterruptedException e) {
            // do something
        }




/* Method 2 */
//        lock.lock();
//        try {
//            balance += amount;
//        } finally {
//            lock.unlock();
//        }


/* Method 1 */
//        synchronized (this) {
//            balance += amount;
//        }
//        balance += amount;
    }


    public void withdraw(double amount) {
        try {
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance -= amount;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get the lock.");
            }
        } catch (InterruptedException e) {
            // do something
        }
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public void printAccountNumber(){
        System.out.println("Account number = " + accountNumber);
    }

}
