package com.cnicg.lemon.demo.abknowledge.tail;

import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Tail_f_Impl {
    public static void main(String[] args)throws Exception {
        File file = new File("/Users/chenmeng/Documents/lemonTest.log");
        File file1 = new File("/Users/chenmeng/Documents/lemonTestRecord.log");
        RandomAccessFile record = new RandomAccessFile(file1, "rw");
//        fileLength(file);
        randomAccess(file, record);
    }


    //pos持久化-支持重启
    private static void randomAccess(File file, RandomAccessFile record) throws  Exception{
        RandomAccessFile accessFile = new RandomAccessFile(file, "r");
        String posStr = record.readLine();
        Long pos = 0L;
        if (posStr != null) {
            pos = Long.parseLong(posStr) + 2;
        }
        accessFile.seek(pos);
        while (true) {
            String line = accessFile.readLine();

            TimeUnit.SECONDS.sleep(1);
            if (null == line) {
                TimeUnit.SECONDS.sleep(3);
            } else {
                byte[] bytes = line.getBytes(Charset.forName("iso-8859-1"));
                System.out.println(new String(bytes, Charset.defaultCharset()));
                pos = pos + bytes.length;
                //几分钟持久化一次
                record.seek(0);
                record.writeBytes(pos.toString());
            }
        }



    }

    private static void fileLength(File file) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(file);

        Scanner scanner = new Scanner(fileInputStream);
        Long pos = 0L;
        while (true) {
            String line = null;
            try {
                line = scanner.nextLine();
                pos = file.length();
            } catch (NoSuchElementException ex) {
                TimeUnit.SECONDS.sleep(3);
                if (file.length() > pos) {
                    fileInputStream = new FileInputStream(file);
                    fileInputStream.skip(pos);
                    scanner = new Scanner(fileInputStream);
                }
            }

            if (null != line){
                System.out.println(line);
            }
        }
    }

}
