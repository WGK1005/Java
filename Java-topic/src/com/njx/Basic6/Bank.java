package com.njx.Basic6;

public class Bank {
    private int money;

    public Bank() {
        this.money = 0;
    }

    public void income(int in, int out) throws BankException {
        if (in <= 0 || out >= 0 || in + out <= 0) {
            throw new BankException(in, out);
        }
        this.money += (in + out);
    }

    public int getMoney() {
        return this.money;
    }
}

