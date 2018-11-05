package test.singleton;/*
 *@author Zoumugen
 *@create 2018/11/5 0005-下午 16:25
 */

class Print implements Runnable {
    static int i = 1;

    @Override
    public void run() {
        while (true) {
            if (i <=100) {
                try {
                    Thread.currentThread().sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                print();
            } else {
                break;
            }
        }
    }

    public synchronized void print() {
        notify();
        System.out.println(Thread.currentThread().getName() + "i = " + i++);
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class TestCommunication {
    public static void main(String[] args) {
        Print print = new Print();
        Thread thread1 = new Thread(print);
        Thread thread2 = new Thread(print);
        thread1.setName("A :");
        thread2.setName("B:");
        thread1.start();
        thread2.start();

    }
}

