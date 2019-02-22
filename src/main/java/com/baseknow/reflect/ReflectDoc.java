package com.baseknow.reflect;

import org.springframework.context.annotation.Configuration;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Configuration
public class ReflectDoc {


    public void testAnnotation (@MyAnno String test){

        System.out.println(test);
    }

    public static void main(String[] args) throws Exception {

        Class<?> ref = Class.forName("com.baseknow.reflect.ReflectDoc");

        Configuration annotation = ref.getAnnotation(Configuration.class);
        System.out.println(annotation);

    }

}
