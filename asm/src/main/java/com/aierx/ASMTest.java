package com.aierx;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

;

public class ASMTest implements Opcodes {

    public static void main(String[] args) throws IOException {
        ClassReader classReader = new ClassReader("com.aierx.ASMTest$HelloWorld");
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        ClassVisitor editVisitor = new ClassVisitor(ASM5,classWriter) {
            @Override
            public void visit(int i, int i1, String s, String s1, String s2, String[] strings) {
                super.visit(i, i1, s+"$1", s1, s2, strings);
            }
        };
        classReader.accept(editVisitor,0);
        byte[] bytes = classWriter.toByteArray();
        String s = "C:\\Users\\aleiw\\IdeaProjects\\qr\\out\\production\\qr\\Hello.class";
        Files.write(new File(s).toPath(),bytes);
    }

    class HelloWorld{
        public void sayHello(){
            System.out.println("aaaaaa");
        }
    }
}



