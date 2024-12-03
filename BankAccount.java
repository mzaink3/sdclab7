class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + ". Current Balance: " + balance);
            notify();
        }
    }

    public synchronized void withdraw(double amount) {
        while (amount > balance) {
            try {
                System.out.println("Insufficient funds. Waiting for deposit...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (amount > 0) {
            balance -= amount;
            System.out.println("Withdrew " + amount + ". Current Balance: " + balance);
        }
    }

    public synchronized double getBalance() {
        return balance;
    }
}
