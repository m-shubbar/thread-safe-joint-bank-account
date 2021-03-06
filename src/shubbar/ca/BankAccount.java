package shubbar.ca;

/**
 * @author Mustafa <codingbox@outlook.com>
 * Created at 2021-03-06
 */
public class BankAccount {
    private double balance;
    private String accountNumber;

    public BankAccount(String accountNumber, double balance) {
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

}
