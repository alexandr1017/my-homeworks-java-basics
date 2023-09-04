import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Bank {


    private Map<String, Account> accounts;
    private final Random random = new Random();
    private static final long MONEY_CAP = 50_000L;


    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        System.out.println("Выполняется проверка Службы Безопасности");
        Thread.sleep(1000);
        return random.nextBoolean();
    }


    public void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        Account accOne = accounts.get(fromAccountNum);
        Account accTwo = accounts.get(toAccountNum);


        boolean isBlokeAccounts = accOne.isBlocked() || accTwo.isBlocked();
        boolean isValid = accounts.containsKey(fromAccountNum) && accounts.containsKey(toAccountNum) && !isBlokeAccounts;

        if (isValid && amount < MONEY_CAP) {
            if (calculate(fromAccountNum, toAccountNum, amount)) {
                System.out.println("Транзакция на сумму " + amount + " проведена");
            }
        }
        if (isValid && amount > MONEY_CAP) {
            if (calculate(fromAccountNum, toAccountNum, amount)) {
                System.out.println("Транзакция на сумму " + amount + " проведена с подозрением");
            }
            boolean flag = isFraud(fromAccountNum, toAccountNum, amount);
            if (flag) {
                accOne.setBlocked(true);
                accTwo.setBlocked(true);
                System.out.println("Транзакция на сумму " + amount + " признана мошеннической, счета заблокированы!");
            }
        }
    }


    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {
        return accounts.values().stream().map(Account::getMoney).reduce(0L, Long::sum);
    }

    private boolean calculate(String fromAccountNum, String toAccountNum, long amount) {
        Account accOne = accounts.get(fromAccountNum);
        Account accTwo = accounts.get(toAccountNum);

        // Получаем последовательный порядок блокировок при доступе к общим ресурсам
        Account first = accOne.getAccNumber().compareTo(accTwo.getAccNumber()) < 0 ? accOne : accTwo;
        Account second = first == accOne ? accTwo : accOne;

        synchronized (first) {
            synchronized (second) {
                long accOneMoney = first.getMoney();
                long accTwoMoney = second.getMoney();

                if (accOneMoney >= amount) {
                    accOne.setMoney(accOneMoney - amount);
                    accTwo.setMoney(accTwoMoney + amount);
                    return true;
                } else {
                    System.out.println("Ошибка транзакции");
                    return false;
                }
            }
        }
    }

    public void setAccounts(Map<String, Account> accounts) {
        this.accounts = accounts;
    }


}
