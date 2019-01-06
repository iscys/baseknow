package com.baseknow.netty.service;

import java.io.Serializable;

public class Invocations implements Serializable {

    public String method;
    public String name;
    public long id;

    public Invocations(String method, String name) {
        this.method = method;
        this.name = name;
    }

    public void setId(long id){
        this.id=id;
    }

    public long getId() {
        return id;
    }
}