package Task2_Bank.accounts;

import Task2_Bank.owners.Owners;

public class LoanAccount extends Accounts {
    public float info;
    public LoanAccount(String IBAN, Owners owner, float balance, float montlyInterestRate) {
        super(IBAN, owner, balance, montlyInterestRate);
    }
    // Ипотечните сметки не генерират
    // лихва за първите 6 месеца за физически лица, а за първите 12 месеца генерират 50% лихва за юридически лица.
    public float countRate(int months) {
        if (owner.code == 1) {
            if (months > 3) info = balance * montlyInterestRate * (months - 3) / 100.0f;
            else if (months <= 3) info = 0;
        } else if (owner.code == 2) {
            if (months > 2) info = balance * montlyInterestRate * (months - 2)/ 100.0f;
            else if (months <= 3) info = 0;
        }
        return info;
    }
}
