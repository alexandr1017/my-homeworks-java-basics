package practice;

public class CardAccount extends BankAccount {

    private static final double COMMISSION = 1.01;

    public CardAccount(double amount) {
        super(amount);
    }

    public CardAccount() {
    }

    @Override
    public void take(double amountToTake) {
        super.take(getAmountWithCommission(amountToTake));
    }

    private double getAmountWithCommission(double amountToTake) {
        return COMMISSION * amountToTake;
    }
    // не забывайте, обращаться к методам и конструкторам родителя
    // необходимо используя super, например, super.put(10D);
}
