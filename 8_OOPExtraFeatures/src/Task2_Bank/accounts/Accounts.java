package Task2_Bank.accounts;

import Task2_Bank.owners.Owners;

public abstract class Accounts {
    public String getIBAN() {
        return IBAN;
    }
    public abstract float countRate(int month);

    public Owners getOwner() {
        return owner;
    }

    public void setOwner(Owners owner) {
        this.owner = owner;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public float getMontlyInterestRate() {
        return montlyInterestRate;
    }

    public void setMontlyInterestRate(float montlyInterestRate) {
        this.montlyInterestRate = montlyInterestRate;
    }
    public String getOwnername() {
        return owner.getName();
    }

    public String IBAN;
    public Owners owner;
    public float balance;
    public float montlyInterestRate;


    public Accounts(String IBAN, Owners owner, float balance, float montlyInterestRate) {
        this.IBAN = IBAN;
        this.owner = owner;
        this.balance = balance;
        this.montlyInterestRate = montlyInterestRate;

    }


}
