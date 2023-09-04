import java.util.Objects;

public class Account {

    private long money;
    private String accNumber;
    private volatile boolean isBlocked = false;




    public Account(long money, String accNumber) {
        this.money = money;
        this.accNumber = accNumber;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }
    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

}
