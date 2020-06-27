package com.baseknow.meta;

import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.LinkedHashSet;
import java.util.Set;

public class JavaStandardAnnotationMetadata extends JavaStandardClassMetadata implements JavaAnnotationMetadata {

    private final Annotation[] annotations;

    public JavaStandardAnnotationMetadata(Class<?> introspectedClass) {
        super(introspectedClass);
        this.annotations =introspectedClass.getAnnotations();
    }

    @Override
    public Set<String> getAnnotationTypes() {
         LinkedHashSet<String> annotationTypes = new LinkedHashSet<>();
         for(Annotation ann:annotations){
             annotationTypes.add(ann.annotationType().getName());
         }
         return annotationTypes;
    }

    @Override
    public Set<String> getMetaAnnotationTypes(String annotationName) {
        return null;
    }

    @Override
    public boolean hasAnnotation(String annotationName) {
        for (Annotation ann : this.annotations) {
            if (ann.annotationType().getName().equals(annotationName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasMetaAnnotation(String annotationName) {
        return false;
    }

    @Override
    public boolean isAnnotated(String annotationName) {
        return false;
    }

    public static void main(String[] args) {
         ClassLoader classLoader = JavaStandardClassMetadata.class.getClassLoader();

        final URL resource = classLoader.getResource("com");
        System.out.println();

    }
}
