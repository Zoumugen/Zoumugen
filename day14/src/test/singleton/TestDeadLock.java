package test.singleton;/*
 *@author Zoumugen
 *@create 2018/11/5 0005-下午 16:04
 */

public class TestDeadLock {
    static StringBuffer sb1 = new StringBuffer();
    static StringBuffer sb2 = new StringBuffer();

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                synchronized (sb1) {
                    try {
                        Thread.currentThread().sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    sb1.append("A");
                    synchronized (sb2) {
                        sb2.append("B");
                        System.out.println(" sb1= "+sb1 );
                        System.out.println(" sb2= "+sb2 );
                    }
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.currentThread().sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (sb2) {
                    sb1.append("C");
                    synchronized (sb1) {
                        sb2.append("D");
                        System.out.println(" sb1= "+sb1 );
                        System.out.println(" sb2= "+sb2 );
                    }
                }
            }
        }.start();
    }

}
