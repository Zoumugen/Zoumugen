package test.eum.java.test.Threadstest.testwindow;/*
 *@author Zoumugen
 *@create 2018/11/5 0005-上午 0:51
 */

//模拟火车站售票窗口
//开启三个窗口售票，总票数为100张
class Window extends Thread {
   static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "售票，票号为： " + ticket--);
            } else {
                break;
            }
        }
    }
}

public class TestWindow {
    public static void main(String[] args) {
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();
        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");
        w1.start();
        w2.start();
        w3.start();

    }
}
