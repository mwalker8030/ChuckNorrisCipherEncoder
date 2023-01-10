class BankAccount {

    protected String number;
    protected Long balance;

    public BankAccount(String number, Long balance) {
        this.number = number;
        this.balance = balance;
    }
}

class CheckingAccount extends BankAccount{
    protected double fee;

    public CheckingAccount(String n, Long b, double f){
        super(n, b);
        fee = f;
    }
}

class SavingsAccount extends BankAccount{
    protected  double interestRate;

    public SavingsAccount(String n, Long b, double i){
        super(n, b);
        interestRate = i;
    }
}