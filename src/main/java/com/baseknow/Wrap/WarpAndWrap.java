package com.baseknow.Wrap;

public class WarpAndWrap implements WrapInterface {

    WrapInterface wrap;
    WarpAndWrap(WrapInterface wrap){
       this.wrap=wrap;
    }
    @Override
    public void sayHello() {
        wrap.sayHello();
    }
}
