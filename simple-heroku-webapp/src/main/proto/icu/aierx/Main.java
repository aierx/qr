package icu.aierx;

import java.io.*;

/**
 * @author leiwenyong
 * @since 2022-05-15
 */
public class Main {

    public static void main(String[] args) throws IOException {
        User.Test.Builder builder = User.Test.newBuilder();
        builder.setQuery("10086");
        builder.setPageNum(1);
        builder.setPageSize(2);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        builder.build().writeTo(outputStream);
        User.Test test = User.Test.parseFrom(outputStream.toByteArray());

        ByteArrayOutputStream delimitedOutStream = new ByteArrayOutputStream();
        builder.build().writeDelimitedTo(delimitedOutStream);
        User.Test test1 = User.Test.parseDelimitedFrom(new ByteArrayInputStream(delimitedOutStream.toByteArray()));


        System.out.print(test);
        System.out.print(test1);

        try {
            Account account = new Account("leiwen", "yong");
            account.setFather("father");
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(new FileOutputStream(Account.class.getName()+".txt"));
            objectOutputStream.writeObject(account);

            objectOutputStream.flush();
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(Account.class.getName()+".txt"));
            Account o = (Account)inputStream.readObject();
            System.out.println(o);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
