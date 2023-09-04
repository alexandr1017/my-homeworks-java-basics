package practice;

import java.time.LocalDate;

public class DepositAccount extends BankAccount {
   private LocalDate lastIncome;

    public DepositAccount(double amount) {
        super(amount);
    }

   public DepositAccount() {
    }

    @Override
   public void put(double amountToPut) {
        super.put(amountToPut);
        lastIncome = LocalDate.now();
    }

    @Override
    public void take(double amountToTake) {
        LocalDate dateCanTake = lastIncome.plusMonths(1);
        if (!LocalDate.now().isAfter(dateCanTake)) {
            System.out.println("Попытка снять со счета деньги менее, чем через месяц после зачисления." +
                    "\nСможете снять: " + dateCanTake);
            return;
        }
        super.take(amountToTake);
    }
}
