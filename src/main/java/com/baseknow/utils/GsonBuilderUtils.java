package com.baseknow.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * gson json转换器
 * author cys
 */
public class GsonBuilderUtils {

    public static final GsonBuilder INSTANCE = new GsonBuilder();

    /**
     * 得到GSON 对象
     * @return
     */
    public static Gson creat(){
        return INSTANCE.create();
    }

    /**
     * 将对象转换为json 字符串
     * @param src
     *
     */
    public static String toJson(Object src){
        Gson gson= creat();
        return gson.toJson(src);
    }
    /**
     * 将json 字符串转换为指定对象po
     * @param jsonStr，classOfT
     *
     */
    public static <T> T  fromJson(String jsonStr,Class<T> classOfT){
        Gson gson= creat();
        return gson.fromJson(jsonStr,classOfT);
    }

    /**
     * 将json 字符串转换为jsonobject 对象
     * @param jsonStr
     *
     */
    public static JsonObject parse(String jsonStr){

       return new JsonParser().parse(jsonStr).getAsJsonObject();
    }

}
