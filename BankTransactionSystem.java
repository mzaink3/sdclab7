//M. Zain
//2022F-BSE-003
//Section A

public class BankTransactionSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        TransactionThread t1 = new TransactionThread(account, 200, "deposit");
        TransactionThread t2 = new TransactionThread(account, 1500, "withdraw");
        TransactionThread t3 = new TransactionThread(account, 50, "deposit");
        TransactionThread t4 = new TransactionThread(account, 100, "withdraw");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Balance: " + account.getBalance());
    }
}


// Changes Committed.
