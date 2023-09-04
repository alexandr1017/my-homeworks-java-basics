import junit.framework.TestCase;

import java.util.HashMap;

public class BankTest extends TestCase {
    Bank bank;
    HashMap<String, Account> accounts;
    Account account1;
    Account account2;
    Account account3;
    Account account4;
    Account account5;
    Account account6;

    @Override
    protected void setUp() {
        bank = new Bank();
        accounts = new HashMap<>();

        account1 = new Account(300_000, "1");
        account2 = new Account(300_000, "2");
        account3 = new Account(300_000, "3");
        account4 = new Account(300_000, "4");
        account5 = new Account(300_000, "5");
        account6 = new Account(300_000, "6");

        accounts.put("one", account1);
        accounts.put("two", account2);
        accounts.put("three", account3);
        accounts.put("four", account4);
        accounts.put("five", account5);
        accounts.put("six", account6);
        bank.setAccounts(accounts);

    }

    public void testTransfer() throws Exception {
        long expected = bank.getSumAllAccounts();


        Thread thread1 = new Thread(() -> {
            try {
                System.out.println("\nThread-1: transfer from account2 to account1");
                bank.transfer("two", "one", Main.amountMoneyRandomizer());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                System.out.println("\nThread-2: transfer from account3 to account4");
                bank.transfer("three", "four", Main.amountMoneyRandomizer());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                System.out.println("\nThread-3: transfer from account1 to account3");
                bank.transfer("one", "three", Main.amountMoneyRandomizer());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread4 = new Thread(() -> {
            try {
                System.out.println("\nThread-4: transfer from account4 to account1");
                bank.transfer("four", "one", Main.amountMoneyRandomizer());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread5 = new Thread(() -> {
            try {
                System.out.println("\nThread-5: transfer from account5 to account1");
                bank.transfer("five", "one", Main.amountMoneyRandomizer());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread6 = new Thread(() -> {
            try {
                System.out.println("\nThread-6: transfer from account6 to account5");
                bank.transfer("six", "five", Main.amountMoneyRandomizer());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();




        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();
        thread6.join();



        long actual = bank.getSumAllAccounts();
        assertEquals(expected,actual);
    }
}
