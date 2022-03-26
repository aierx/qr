package icu.aierx.netty.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * ByteBufferBench和MappedByteBuffer性能对比
 * @author aleiw
 */
public class Bench {

    public static void main(String[] args) {
        method4();
        method3();
    }

    public static void  method4(){
        RandomAccessFile aFile = null;
        FileChannel fc = null;
        try{
            aFile = new RandomAccessFile("C:\\Users\\aleiw\\IdeaProjects\\qr\\jsr107\\b.txt","rw");
            fc = aFile.getChannel();
            long begin = System.currentTimeMillis();
            ByteBuffer buffer = ByteBuffer.allocate((int) aFile.length());
            buffer.clear();
            fc.read(buffer);
            long end = System.currentTimeMillis();
            System.out.println("Read time:"+(end-begin)+"ms");
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (aFile!=null){
                    aFile.close();
                }
                if (fc!=null){
                    fc.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void method3(){
        RandomAccessFile aFile = null;
        FileChannel fc = null;
        try{
            aFile = new RandomAccessFile("C:\\Users\\aleiw\\IdeaProjects\\qr\\jsr107\\b.txt","rw");
            fc = aFile.getChannel();
            long timeBegin = System.currentTimeMillis();
            MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_ONLY, 0, aFile.length());
             System.out.println((char)mbb.get((int)(aFile.length()/2-1)));
            // System.out.println((char)mbb.get((int)(aFile.length()/2)));
            //System.out.println((char)mbb.get((int)(aFile.length()/2)+1));
            long timeEnd = System.currentTimeMillis();
            System.out.println("Read time: "+(timeEnd-timeBegin)+"ms");
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(aFile!=null){
                    aFile.close();
                }
                if(fc!=null){
                    fc.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

}
