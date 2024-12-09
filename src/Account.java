public class Account {
    private double balance;

    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposited: $" + amount + " | Balance: $" + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " attempted an invalid deposit amount.");
        }
    }

    public synchronized void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew: $" + amount + " | Balance: $" + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " failed to withdraw: $" + amount + " | Balance: $" + balance);
        }
    }

    public double getBalance() {
        return balance;
    }
}
