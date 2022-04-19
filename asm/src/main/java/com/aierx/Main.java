package com.aierx;

import com.sun.tools.attach.*;

import java.io.IOException;
import java.util.List;

/**
 * @author leiwenyong
 * @since 2022/4/12
 */
public class Main {
    public static void main(String[] args) throws InterruptedException, IOException, AgentLoadException, AgentInitializationException, AttachNotSupportedException {
        List<VirtualMachineDescriptor> list = VirtualMachine.list();
        for (VirtualMachineDescriptor vmd : list) {
            System.out.println(vmd.displayName());
            if (vmd.displayName().contains("mybatis")){
                VirtualMachine attach = VirtualMachine.attach(vmd.id());
                attach.loadAgent("C:\\Users\\aleiwe\\Desktop\\qr\\asm\\target\\asm-1.0-SNAPSHOT.jar");
                attach.detach();
            }
        }
    }
}
