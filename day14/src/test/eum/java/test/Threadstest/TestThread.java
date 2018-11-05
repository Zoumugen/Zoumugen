package test.eum.java.test.Threadstest;/*
 *@author Zoumugen
 *@create 2018/11/4 0004-下午 23:35
 */
//创建一个子线程，完成1-100输出
//第一种方式：继承java.lang.Thread类
//1.继承java.lang.Thread类
class SubThread extends Thread{
    //2.重写run()方法
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":"+i);
        }
    }
}
public class TestThread {
    public static void main(String[] args) {
        //3.创建一个子类的对象
        SubThread subThread=new SubThread();
        SubThread subThread1=new SubThread();
        //4.调用线程的start()方法,启动此线程，调用相应的run()方法
        //一个线程只能够执行一次start()
        //不能通过Thread实现类对象的run()方法去启动一个线程
        subThread.start();
        subThread1.start();
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"" + i);
        }
    }
}
