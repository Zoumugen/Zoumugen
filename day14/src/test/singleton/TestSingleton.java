package test.singleton;/*
 *@author Zoumugen
 *@create 2018/11/5 0005-上午 3:00
 */

class Singleton {
    private Singleton() {
    }

    private static Singleton instance = null;

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {//使用当前类本身充当锁
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

public class TestSingleton {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();
        System.out.println(singleton == singleton1);
        Class c = Singleton.class;
        System.out.println("c = " + c);
    }
}
