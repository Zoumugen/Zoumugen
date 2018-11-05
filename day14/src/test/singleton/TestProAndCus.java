package test.singleton;/*
 *@author Zoumugen
 *@create 2018/11/5 0005-下午 16:46
 */

class Pro implements Runnable {

    Clerk clerk;

    public Pro(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("生产者开始生产产品");
        while (true) {
            try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.addProduct();
        }
    }
}

class Cus implements Runnable {
    Clerk clerk;

    public Cus(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("消费者消费产品");
        while (true) {
            try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consProduct();
        }
    }
}

class Clerk {
    int productNum;

    public synchronized void addProduct() {
        if (productNum >= 20) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            productNum++;
            System.out.println(Thread.currentThread().getName() + "生产了第" + productNum + "个产品");
            notifyAll();
        }
    }

    public synchronized void consProduct() {
        if (productNum <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + "消费了第" + productNum + "个产品");
            productNum--;
            notifyAll();
        }
    }
}

public class TestProAndCus {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Pro pro=new Pro(clerk);
        Cus cus=new Cus(clerk);
        Thread t1=new Thread(pro);//一个生产者的线程
        Thread t3=new Thread(pro);//一个生产者的线程
        Thread t2=new Thread(cus);//一个消费者的线程
        t1.setName("生产者1");
        t2.setName("消费者");
        t3.setName("生产者2");

        t1.start();
        t2 .start();
        t3 .start();

    }
}
