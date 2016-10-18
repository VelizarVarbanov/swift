package Task2_Bank.accounts;

import Task2_Bank.owners.Owners;

public class MortgageAccount extends Accounts {
    public float info;
    public MortgageAccount(String IBAN, Owners owner, float balance, float montlyInterestRate) {
        super(IBAN, owner, balance, montlyInterestRate);
    }
    // Ипотечните сметки не генерират
    // лихва за първите 6 месеца за физически лица, а за първите 12 месеца генерират 50% лихва за юридически лица.
    public float countRate(int months) {
        if (owner.code == 1) {
            if (months > 6) info = balance * montlyInterestRate * (months - 6) / 100.0f;
            else if (months <= 6) info = 0;
        } else if (owner.code == 2) {
            if (months <= 12) info = balance * 0.5f / 100.0f;
            else if (months > 12) info = balance * 0.5f * 12 / 100 + ((balance * montlyInterestRate * (months-12)) / 100.0f);
        }
        return info;
    }
}
