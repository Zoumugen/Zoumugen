package TestFile;/*
 *@author Zoumugen
 *@create 2018/11/5 0005-下午 20:08
 */

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestFile {
   @Test
   public void test3() throws IOException {
       File file1=new File("E:/IO/123.txt");//文件
       System.out.println(file1.delete());
       if (!file1.exists()) {
           boolean b=file1.createNewFile();
           System.out.println("b = " + b);
           
       }
       File file2=new File("E:\\IO\\io2");//文件目录
       if (!file2.exists()) {
           boolean b=file2.mkdir();
           System.out.println("b = " + b);

       }
   }
    
    @Test
    public void test2(){
        File file1=new File("E:/IO/123.txt");//文件
        File file3=new File("E:\\IO\\iio1");//文件目录
        System.out.println(file1.exists());
        System.out.println(file1.canWrite());
        System.out.println(file1.canRead());
        System.out.println(file1.isFile());
        System.out.println(file1.isHidden());
        System.out.println(file1.isDirectory());
        System.out.println(new Date(file1.lastModified()));
        System.out.println(file1.length());

    }
    @Test
    public void test1(){
        //路径：
        // 绝对路径:包括盘符在内的完整的文件路径
        //相对路径：在当前文件目录下的文件路径
        //File类对象是与平台无关的
        //File中的方法仅仅涉及到创建、删除、重命名，由IO流完成文件内容的操作
        //File类作为IO流构造器形参
        File file1=new File("E:/IO/123.txt");//文件
        File file3=new File("E:\\IO\\iio1");//文件目录
        System.out.println(file1.getName());
        System.out.println(file1.getPath());
        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getParent());
        System.out.println();
        System.out.println(file3.getName());
        System.out.println(file3.getPath());
        System.out.println(file3.getAbsoluteFile());
        System.out.println(file3.getAbsolutePath());
        System.out.println(file3.getParent());
    }

}
