package com.aierx;

import java.io.*;

public class XiaoMei implements Externalizable {
    private static final long serialVersionUID = -4575083234166325540L;

    private transient String nickName;
    private transient String realName;
    public XiaoMei(){
    }

    public XiaoMei(String nickName,String realName){
        this.nickName = nickName;
        this.realName = realName;
    }

    public String toString(){
        return String.format("nickName=%s,realName=%s", nickName,realName);
    }


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
//        out.writeUTF(realName);
//        out.writeUTF(nickName);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException {
        realName = in.readUTF();
//        nickName = in.readUTF();
    }
}