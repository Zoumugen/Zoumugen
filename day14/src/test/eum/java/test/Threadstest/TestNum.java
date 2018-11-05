package test.eum.java.test.Threadstest;/*
 *@author Zoumugen
 *@create 2018/11/5 0005-上午 0:38
 */

public class TestNum {
    public static void main(String[] args) {
        oushu oushu=new oushu();
        jishu jishu=new jishu();
        jishu.setName("奇数线程");
        oushu.setName("偶数线程");
        jishu.start();
        oushu.start();
        new Thread(){
            @Override
            public void run() {
                System.out.println("匿名类对象线程");
            }
        }.start();
    }
}

class oushu extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+"偶数i = " + i);
            }
        }
    }
}

class jishu extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName()+"奇数i = " + i);
            }
        }
    }

}
