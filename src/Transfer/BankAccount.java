package Transfer;

public class BankAccount {

    private String owner; //nazwa konta
    private String account_nr; //numer konta
    private double balance; // stan konta

    public BankAccount(String account_nr) {
        this.account_nr = account_nr;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAccount_nr() {
        return account_nr;
    }

    public void setAccount_nr(String account_nr) {
        this.account_nr = account_nr;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void changeBalance(Double change) {
        Double operation;
        operation = getBalance();
        operation = operation + change;
        setBalance(operation);
    }
}
