package com.baseknow.faceTest;

/**
 * 单例模式
 */
public class SingalModel {

 private static SingalModel singalModel ;

 public synchronized  static SingalModel getInstance(){
    if(singalModel ==null)
     singalModel =new SingalModel();

     return singalModel;
 }

    /**
     * 内部类的方式
     */
 static  class Instance{
     static {
         System.out.println("1111");
     }
     private static SingalModel getInsatnce =new SingalModel();
 }



}
