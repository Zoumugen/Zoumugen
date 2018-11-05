package test.eum.java.test.Threadstest;/*
 *@author Zoumugen
 *@create 2018/11/4 0004-下午 23:27
 */

public class TestMain {
    public static void main(String[] args) {

        main2("zmg");
    }

    public static void main1(String args) {
        System.out.println("method1...");
        System.out.println(args);

    }
    public static void main2(String args) {
        System.out.println("method2..");
        main1(args);
    }
}
