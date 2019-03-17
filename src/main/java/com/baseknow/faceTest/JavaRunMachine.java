package com.baseknow.faceTest;

/**
 * java  运行机制
 * 1.连接过程
 * 为静态变量赋予初始值，null 与0；这里的赋初始值并不是我们赋予的值；
 * nn = null;
 * a=0;
 * b=0;
 *
 * 2.初始化过程
 * nn =new JavaRunMachine() -> a=1 ;b=1;
 * a=1; b= 9;
 *
 *
 */
public class JavaRunMachine extends JavaMachineSuper {


    public static JavaRunMachine nn =new JavaRunMachine();
    public  static int a ;

    public static  int b=9;

    static {

        System.out.println("静态代码块");
        a++;
        b++;
    }


    JavaRunMachine(){
        System.out.println("构造函数");
        System.err.println(a++);
        System.err.println(b++);
    }
    public static JavaRunMachine getInstance(){

        return nn;
    }



}
