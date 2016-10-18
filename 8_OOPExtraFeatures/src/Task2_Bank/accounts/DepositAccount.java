package Task2_Bank.accounts;

import Task2_Bank.owners.Owners;

public class DepositAccount extends Accounts {
    public float info;


    @Override
    public float countRate(int months) {
        return info = balance* months* montlyInterestRate / 100.0f;
    }

    public DepositAccount(String IBAN, Owners owner, float balance, float montlyInterestRate) {
        super(IBAN, owner, balance, montlyInterestRate);
    }
}
