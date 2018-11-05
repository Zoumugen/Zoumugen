package TestFile;/*
 *@author Zoumugen
 *@create 2018/11/5 0005-下午 21:21
 */

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileInpOupStream {
    @Test
    public void test5() {
        File file1 = new File("123.txt");
        File file2 = new File("321.txt");

        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            inputStream = new FileInputStream(file1);
            outputStream = new FileOutputStream(file2);
            byte[] b = new byte[10];
            int len;
            while ((len = inputStream.read(b)) != -1) {
                outputStream.write(b, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void test4() {
        //1.创建一个File对象，表明要写入的文件位置
        //输出的物理文件可以不存在，当执行过程中若不存在会自动的创建
        //若存在，直接覆盖
        File file = new File("123.txt");
        //2.创建一个FIleOutputStream的对象，将file作为形参
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            //3.写入操作
            fileOutputStream.write(new String("I Love China,I Love The World!").getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {//4.关闭输出流
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    @Test
    public void test3() {
        FileInputStream fileInputStream = null;
        try {
            File file = new File("456.txt");
            fileInputStream = new FileInputStream(file);
            byte[] b = new byte[5];
            int len;
            while ((len = fileInputStream.read(b)) != -1) {
//
                String str = new String(b, 0, len);
                System.out.print(str);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    @Test
    public void test2() {
        FileInputStream fileInputStream = null;
        try {
            File file = new File("456.txt");
            //创建一个FileInputStream类的对象
            fileInputStream = new FileInputStream(file);
            int b;
            while ((b = fileInputStream.read()) != -1) {
                System.out.println("b = " + (char) b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //保证关闭相应的流的操作一定执行
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test1() throws IOException {
        //创建一个File类的对象
        File file = new File("456.txt");
        //创建一个FileInputStream类的对象
        FileInputStream fileInputStream = new FileInputStream(file);
//        调用FileInputStream的方法，实现File文件的读取
//        read() 读取文件的一个字节，
//        int b = fileInputStream.read();
//        while (b != -1) {
//            System.out.println("b = " + (char) b);
//            b = fileInputStream.read();
//        }
        int b;
        while ((b = fileInputStream.read()) != -1) {
            System.out.println("b = " + (char) b);
        }
        //关闭相应的流
        fileInputStream.close();
    }
}
