package com.njx.Basic6;

public class Application {
    public static void main(String[] args) {
        Bank bank = new Bank();

        try {
            System.out.println("【操作1】入账 1000，支出 -200");
            bank.income(1000, -200);
            System.out.println("当前总资金：" + bank.getMoney());

            System.out.println("【操作2】入账 500，支出 -100");
            bank.income(500, -100);
            System.out.println("当前总资金：" + bank.getMoney());

            System.out.println("【操作3】入账 300，支出 50（非法）");
            bank.income(300, 50);
            System.out.println("当前总资金：" + bank.getMoney());
        } catch (BankException e) {
            System.out.println("捕获异常：" + e.WarnMess());
        } finally {
            System.out.println("最终银行总资金：" + bank.getMoney());
        }
    }
}

