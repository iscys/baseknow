package com.baseknow.netty.service;

import java.io.Serializable;

public class Invocations implements Serializable {

    public String method;
    public Object[] arguments;
    public long id;

    public Invocations(String method, Object[] arguments) {
        this.method = method;
        this.arguments=arguments;
    }

    public void setId(long id){
        this.id=id;
    }

    public long getId() {
        return id;
    }
}