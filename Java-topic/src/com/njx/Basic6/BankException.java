package com.njx.Basic6;

public class BankException extends Exception {
    private final String message;

    public BankException(int m, int n) {
        if (m <= 0) {
            this.message = "入账资金是负数或零，不符合系统要求。入账金额：" + m;
        } else if (n >= 0) {
            this.message = "支出是正数，不符合系统要求（支出应为负数）。支出金额：" + n;
        } else if (m + n <= 0) {
            this.message = "纯收入小于等于 0，不符合系统要求。in + out = " + (m + n);
        } else {
            this.message = "收支数据异常";
        }
    }

    public String WarnMess() {
        return this.message;
    }
}

