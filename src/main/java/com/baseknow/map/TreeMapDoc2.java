package com.baseknow.map;

import java.util.TreeMap;

/**
 * 实现二叉树，树形结构，添加的key必须实现compartable 接口
 * @author iscys
 */
public class TreeMapDoc2 {

    public static void main(String[] args) {
        TreeMap<Isneedcompare, String> tree = new TreeMap<>();
        tree.put(new Isneedcompare(),"qwe");
        tree.put(new Isneedcompare(),"qwe");



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