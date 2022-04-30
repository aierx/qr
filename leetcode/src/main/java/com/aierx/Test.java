package com.aierx;

import java.io.*;

public class Test {
    public static void main(String[] args){
        String realName="王小美", nickName="王美美";
        XiaoMei x = new XiaoMei(nickName, realName);
        System.out.println("序列化："+x);
        ObjectOutputStream outStream;
        ObjectInputStream inStream;
        //文件保存在本地，把这个路径换成自己的文件路径
        //mac的同学把jiangyoujun换成自己的用户名
        //windows的同学前面要加D:/这样的磁盘符号
        String filePath = "C:\\Users\\aleiwe\\Desktop\\qr\\leetcode\\src\\main/test.log";
        try {
            outStream = new ObjectOutputStream(new FileOutputStream(filePath));
            outStream.writeObject(x);

            inStream = new ObjectInputStream(new FileInputStream(filePath));
            XiaoMei readObject = (XiaoMei)inStream.readObject();
            System.out.println("反列化："+readObject.toString());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}