package test.eum.java.test.Threadstest;/*
 *@author Zoumugen
 *@create 2018/11/4 0004-下午 23:35
 */

//Thread常用方法，
//1.start(),启动线程并执行相应的run()方法
//2.run():子线程要执行的代码放入run()方法
//3.currentThread():静态的，调取当前线程
//4.getName():获取线程的名字
//5.setName():设置线程名字
//6.yield()；释放当前CPU的执行权
//7.join():在A线程中调用B线程中的join()方法，
//          表示当执行到此方法时，A停止，直至B线程执行完毕,A 在执行join()之后的代码
//8.isAlive():判断当前线程是否存活
//9.sleep(long 1):显式的让当前线程睡眠1毫秒

//10.线程通信：wait().notify(),notifyAll();
//11.设置线程优先级：
//          getPriority():返回线程优先值
//          setPriority(int newPriority)：改变线程优先值***只是抢到CPU执行权的概率变大了
class SubThread1 extends Thread {
    //2.重写run()方法
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
//            try {
//                sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//        }
            System.out.println(Thread.currentThread().getName() + ":"
                    + Thread.currentThread().getPriority() + ":" + i);
        }
    }
}

public class TestThread1 {
    public static void main(String[] args) {
        //3.创建一个子类的对象
        SubThread1 subThread = new SubThread1();
        subThread.setName("子线程1");
        subThread.setPriority(Thread.MAX_PRIORITY);
        subThread.start();
        Thread.currentThread().setName("************主线程");
        for (int i = 0; i < 100; i++) {

            System.out.println(Thread.currentThread().getName() + ":"
                    +Thread.currentThread().getPriority()+":" + i);
//            if (i % 10 == 0) {
//                Thread.currentThread().yield();
//            }
//            if (i == 20) {
//                try {
//                    subThread.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
        System.out.println(subThread.isAlive());
    }
}
