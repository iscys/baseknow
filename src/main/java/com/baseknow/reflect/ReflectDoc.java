package com.baseknow.reflect;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Configuration
public class ReflectDoc {

    private String name;

    public void testAnnotation (@MyAnno String test){

        System.out.println(test);
    }

    public static void main(String[] args) throws Exception {

        Class<?> ref = Class.forName("com.baseknow.reflect.ReflectDoc");

        Configuration annotation = ref.getAnnotation(Configuration.class);
        System.out.println(annotation);

        Field[] fields = ref.getDeclaredFields();
        for(Field field :fields){
            System.out.println(field.getGenericType());

        }

    }

}
