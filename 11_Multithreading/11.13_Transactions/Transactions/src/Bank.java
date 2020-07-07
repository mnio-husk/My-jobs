import java.util.HashMap;
import java.util.Random;

public class Bank {
    private HashMap<String, Account> accounts = new HashMap<String, Account>();
    private final Random random = new Random();
    private final int maximum = 50000;
    private boolean check = false;
    private HashMap<String, Account> blockAccounts = new HashMap<String, Account>();
    private Object lock = new Object();


    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами.
     * Если сумма транзакции > 50000, то после совершения транзакции,
     * она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка
     * счетов (как – на ваше усмотрение)
     */
    public void transfer(String fromAccountNum, String toAccountNum, long amount) {
        synchronized (lock) {
             if (amount > maximum) {
                if (accounts.containsKey(fromAccountNum) && accounts.containsKey(toAccountNum)) {
                    try {
                        check = isFraud(fromAccountNum, toAccountNum, amount);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (check == true) {
                        blockAccounts.put(fromAccountNum, new Account(accounts.get(fromAccountNum).getMoney(), fromAccountNum));
                        blockAccounts.put(toAccountNum, new Account(accounts.get(toAccountNum).getMoney(), toAccountNum));
                        accounts.remove(fromAccountNum);
                        accounts.remove(toAccountNum);
                        System.out.println("Score: " + fromAccountNum + " and " + toAccountNum + " were blocked");
                    }
                    else {
                        long fromAccount = accounts.get(fromAccountNum).getMoney() - amount;
                        long onAccount = accounts.get(toAccountNum).getMoney() + amount;
                        accounts.put(fromAccountNum, new Account(fromAccount, fromAccountNum));
                        accounts.put(toAccountNum, new Account(onAccount, toAccountNum));
                        System.out.println("The operation was completed successfully: " + fromAccountNum + " and " + toAccountNum);
                    }
                }
            } else if (accounts.containsKey(fromAccountNum) && accounts.containsKey(toAccountNum)) {
                long fromAccount = accounts.get(fromAccountNum).getMoney() - amount;
                long onAccount = accounts.get(toAccountNum).getMoney() + amount;
                accounts.put(fromAccountNum, new Account(fromAccount, fromAccountNum));
                accounts.put(toAccountNum, new Account(onAccount, toAccountNum));
                 System.out.println("The operation was completed successfully: " + fromAccountNum + " and " + toAccountNum);
            }

        }
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public void registration(String numberId, long money) {
        accounts.put(numberId, new Account(money, numberId));
    }
}
