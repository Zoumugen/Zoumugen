package test.eum.java.test.Threadstest.testwindow;/*
 *@author Zoumugen
 *@create 2018/11/5 0005-上午 1:04
 */
//通过实现的方式创建线程
//创建了一个实现了runnable接口的实现类的对象
//将此对象作为形参传递给Thread类的构造其中，创建Thread类的对象，此对象极为一个线程
class Printnum implements  Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+"偶数i = " + i);
            }
        }
    }
}
public class Testru {
    public static void main(String[] args) {
        Printnum printnum=new Printnum();
        Thread thread=new Thread(printnum);
        thread.start();//执行Thread对象生成时构造器形参的对象run()方法

        Thread thread1=new Thread(printnum);
        thread1.start();
    }
}
