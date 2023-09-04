package practice;

public class BankAccount {
    private double amount;

    public BankAccount(double amount) {
        this.amount = amount;
    }
    public BankAccount() {
    }

    public double getAmount() {
        // верните значение количества денег не счету
        return amount;
    }

    public void put(double amountToPut) {
        amount = amountToPut <= 0 ? amount : amount + amountToPut;
        // метод зачисляет деньги на счет
    }

    public void take(double amountToTake) {
        amount = (amountToTake > amount || amountToTake <= 0) ? amount : amount - amountToTake;
        // метод списывает деньги со счета
    }
}
