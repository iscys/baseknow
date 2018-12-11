package com.baseknow.utils;

public class ToolsUtils {


    /**
     * 获取classLoader
     * @return
     */
    public static ClassLoader getClassLoader(){

        ClassLoader loader = null;
        try {
            loader = Thread.currentThread().getContextClassLoader();
        }catch(Exception e) {}
        if(loader==null) {
            loader = ToolsUtils.class.getClassLoader();
        }
        return loader;

    }
}
