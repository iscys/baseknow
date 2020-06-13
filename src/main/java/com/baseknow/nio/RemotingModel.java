package com.baseknow.nio;

import com.alibaba.fastjson.JSON;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class RemotingModel {

    private transient byte[] body;

    private String version;

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }





    public ByteBuffer encode(){
         int length =4;
         String json = JSON.toJSONString(this);
         byte[] content = json.getBytes(Charset.forName("UTF-8"));
         length+=content.length;
         ByteBuffer buffer = ByteBuffer.allocate(length);
         buffer.putInt(length-4);
         buffer.put(content);
         buffer.flip();
         return buffer;

    }

    public static RemotingModel decode(ByteBuffer buffer){

        int allLength = buffer.getInt();
        byte [] data =new byte[allLength];

        buffer.get(data);

        String json = new String(data, Charset.forName("UTF-8"));
         RemotingModel model = JSON.parseObject(json, RemotingModel.class);

        return model;

    }
}
