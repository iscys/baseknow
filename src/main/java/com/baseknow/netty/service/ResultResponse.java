package com.baseknow.netty.service;

import java.io.Serializable;

public class ResultResponse implements Serializable {

    public Object result;

    public long id;

    public void setResult(Object res){
        this.result=res;
    }

    public Object getResult(){
        return result;
    }

    public void setId(long id){
        this.id=id;
    }

    public long getId() {
        return id;
    }

}
