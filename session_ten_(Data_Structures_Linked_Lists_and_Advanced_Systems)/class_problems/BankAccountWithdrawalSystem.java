// PRACTICE PROBLEM 1: Bank Account Withdrawal System
import java.util.*;

abstract class BankAccount {
    protected String accountId;
    protected double balance;

    public BankAccount(String accountId, double initialBalance) {
        this.accountId = accountId;
        this.balance = initialBalance;
    }

    public String getAccountId() { return accountId; }
    public double getBalance() { return balance; }

    public abstract String withdraw(double amount);
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountId, double initialBalance) {
        super(accountId, initialBalance);
    }

    @Override
    public String withdraw(double amount) {
        if (balance - amount < 1000) {
            return accountId + " rejected: minimum balance 1000";
        }
        balance -= amount;
        return accountId + " balance " + (int)balance;
    }
}

class CurrentAccount extends BankAccount {
    public CurrentAccount(String accountId, double initialBalance) {
        super(accountId, initialBalance);
    }

    @Override
    public String withdraw(double amount) {
        if (balance - amount < -5000) {
            return accountId + " rejected: overdraft limit 5000";
        }
        balance -= amount;
        return accountId + " balance " + (int)balance;
    }
}

public class BankAccountWithdrawalSystem {
    public static void main(String[] args) {
        Map<String, BankAccount> accounts = new HashMap<>();
        accounts.put("S1", new SavingsAccount("S1", 5000));
        System.out.println(accounts.get("S1").withdraw(4500)); // S1 rejected: minimum balance 1000

        accounts.put("C1", new CurrentAccount("C1", 2000));
        System.out.println(accounts.get("C1").withdraw(6000)); // C1 balance -4000
        System.out.println(accounts.get("S1").withdraw(3000)); // S1 balance 2000
        System.out.println(accounts.get("C1").withdraw(2000)); // C1 rejected: overdraft limit 5000
    }
}
