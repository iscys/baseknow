package com.baseknow.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * goole json 使用转换
 * gson json转换器
 * author cys
 */
public class GsonBuilderUtils {

    private static final GsonBuilder INSTANCE = new GsonBuilder();

    /**
     * 得到GSON 对象
     * @return
     */
    private static Gson creat(){
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
     * 将json 字符串转换为jsonobject 对象操作
     * @param jsonStr
     * 我们一般这么使用
     *  JsonObject parse=GsonBuilderUtils.parse(str); //字符创转换为可操作的json 对象
     * 	System.out.println(parse.get("top_bottom").getAsString());//get进行对象的操作
     *
     */
    public static JsonObject parse(String jsonStr){

       return new JsonParser().parse(jsonStr).getAsJsonObject();
    }

    /**
     * demo 测试用例
     * @param args
     */
    public static void main(String[] args) {

        ArrayList<String> list =new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        String s = GsonBuilderUtils.toJson(list);
        System.out.println(s);
    }

}
