import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(1000); // Initial balance: $1000

        // Create a list of transactions
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(account, true, 500));   // Deposit $500
        transactions.add(new Transaction(account, false, 300));  // Withdraw $300
        transactions.add(new Transaction(account, true, 200));   // Deposit $200
        transactions.add(new Transaction(account, false, 1000)); // Attempt to withdraw $1000
        transactions.add(new Transaction(account, false, 200));  // Withdraw $200

        // Create an ExecutorService to handle the threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Execute transactions
        for (Transaction transaction : transactions) {
            executor.execute(transaction);
        }

        // Shut down the executor
        executor.shutdown();
        while (!executor.isTerminated()) {
            // Wait for all threads to finish
        }

        // Display final balance
        System.out.println("Final balance: $" + account.getBalance());
    }
}
