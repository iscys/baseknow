package com.baseknow.map;

import java.util.TreeMap;

/**
 * 实现二叉树，树形结构，添加的key必须实现compartable 接口
 * @author iscys
 */
public class TreeMapDoc2 {

    public static void main(String[] args) {
        TreeMapDoc doc =new TreeMapDoc();
        doc.put("qwe","qwe");
        doc.put("qweq","qwew");
        doc.put("qwet","qwe");
        AclNode qwe = doc.getEntity("qweq");
        System.out.println(qwe.v);


    }
}

/**
 * 必须实现comparable 接口
 *
 */
class Isneedcompare implements Comparable{


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}