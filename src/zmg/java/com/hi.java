package zmg.java.com;/*
 *@author Zoumugen
 *@create 2018/11/3 0003-上午 1:05
 */

import java.util.HashMap;

public class hi {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
        HashMap<String,String> map=new HashMap<>();

        map.put("name","zmg");
        map.put("age","25");
        map.put("school","Jmu");
        map.put("major","computer");

        String age=map.get("age");
        System.out.println("age = " + age);

        map.remove("major");
        System.out.println(map);
    }
}
