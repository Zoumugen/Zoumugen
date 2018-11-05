package test.eum.java.test.Threadstest.testwindow;/*
 *@author Zoumugen
 *@create 2018/11/5 0005-上午 1:27
 */

//此程序存在线程安全问题：打印时出现重票，错票
//解决线程安全问题：
// 1.同步代码块
//   synchronized(同步监视器){
//   需要被同步的代码块 操作共享数据的代码块：多个线程操作同一个变量};
//   同步监视器：由一个类的对象来充当，哪个线程获取此监视器，就执行大括号里
//   被同步的代码块，俗称：锁,要求所有的线程共用同一把锁
//2.同步方法
//   将操作共享数据的方法声明为synchronized,锁默认当前对象
class sale implements Runnable {
    int ticket = 100;

    public synchronized void show() {

        if (ticket > 0) {
            try {
                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "售票，票号为： " + ticket--);
        }
    }


    @Override
    public void run() {

        while (true) {
            show();//同步方法
            //同步代码块
//            synchronized (this) {//表示当前对象
//                if (ticket > 0) {
//                    try {
//                        Thread.currentThread().sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getName() + "售票，票号为： " + ticket--);
//                } else {
//                    break;
//                }

        }
    }
}

public class Testwindows2 {
    public static void main(String[] args) {
        sale sale = new sale();
        Thread thread1 = new Thread(sale);
        Thread thread2 = new Thread(sale);
        Thread thread3 = new Thread(sale);
        thread1.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");
        thread1.start();
        thread2.start();
        thread3.start();

    }
}
