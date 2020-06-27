package com.baseknow.meta;

import java.util.Set;

public interface JavaAnnotationMetadata extends JavaClassMetadata{

    Set<String> getAnnotationTypes();

    Set<String> getMetaAnnotationTypes(String annotationName);

    boolean hasAnnotation(String annotationName);

    boolean hasMetaAnnotation(String annotationName);

    boolean isAnnotated(String annotationName);


}
