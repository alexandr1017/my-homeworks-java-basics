import java.util.HashMap;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        HashMap<String, Account> accounts = new HashMap<>();
    //bank is 540_000
        Account account1 = new Account(100_000,"1");
        Account account2 = new Account(80_000,"2");


        Account account3 = new Account(100_000,"3");
        Account account4 = new Account(80_000,"4");


        Account account5 = new Account(100_000,"5");
        Account account6 = new Account(80_000,"6");


        accounts.put("one", account1);
        accounts.put("two", account2);
        accounts.put("three", account3);
        accounts.put("four", account4);
        accounts.put("five", account5);
        accounts.put("six", account6);

        bank.setAccounts(accounts);

        System.out.println(bank.getBalance("one"));
        System.out.println(bank.getBalance("two"));
        System.out.println(bank.getBalance("three"));
        System.out.println(bank.getBalance("four"));
        System.out.println(bank.getBalance("five"));
        System.out.println(bank.getBalance("six"));

        System.out.println("Сумма в банке до сессии транзакций: " + bank.getSumAllAccounts());

        Thread thread1 = new Thread(() -> {
            try {
                System.out.println("\nThread-1: transfer from account2 to account1");
                bank.transfer("two", "one", amountMoneyRandomizer());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                System.out.println("\nThread-2: transfer from account3 to account4");
                bank.transfer("three", "four", amountMoneyRandomizer());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                System.out.println("\nThread-3: transfer from account1 to account3");
                bank.transfer("one", "three", amountMoneyRandomizer());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread4 = new Thread(() -> {
            try {
                System.out.println("\nThread-4: transfer from account4 to account1");
                bank.transfer("four", "one", amountMoneyRandomizer());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread5 = new Thread(() -> {
            try {
                System.out.println("\nThread-5: transfer from account5 to account1");
                bank.transfer("five", "one", amountMoneyRandomizer());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread6 = new Thread(() -> {
            try {
                System.out.println("\nThread-6: transfer from account6 to account5");
                bank.transfer("six", "five", amountMoneyRandomizer());
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



        System.out.println(bank.getBalance("one"));
        System.out.println(bank.getBalance("two"));
        System.out.println(bank.getBalance("three"));
        System.out.println(bank.getBalance("four"));
        System.out.println(bank.getBalance("five"));
        System.out.println(bank.getBalance("six"));

        System.out.println("Сумма в банке после сессии транзакций: " + bank.getSumAllAccounts());


    }

    public static long amountMoneyRandomizer() {
        Random rand = new Random();
        long result = rand.nextInt(50001);
        if (rand.nextDouble() < 0.05) {
            result += 50001 + rand.nextInt(60_000);
        }
        return result;
    }
}
