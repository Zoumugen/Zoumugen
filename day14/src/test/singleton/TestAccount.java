package test.singleton;/*
 *@author Zoumugen
 *@create 2018/11/5 0005-上午 3:25
 */

class Account implements Runnable {
    private static int balance = 0;

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            reposit(1000);
        }
    }

    public synchronized void reposit(int amt) {
        notify();
        balance += amt;
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "存 " + amt + "元" + "账户总余额：" + balance);
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class TestAccount {
    public static void main(String[] args) {
        Account account = new Account();
        Thread customer1 = new Thread(account);
        Thread customer2 = new Thread(account);
        Thread customer3 = new Thread(account);
        customer1.setName("客户1：");
        customer2.setName("客户2：");
        customer3.setName("客户3：");
        customer1.start();
        customer2.start();
        customer3.start();
    }
}
