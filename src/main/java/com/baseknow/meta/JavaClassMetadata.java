package com.baseknow.meta;

public interface JavaClassMetadata {


    String getClassName();


    boolean isInterface();


    boolean isAnnotation();


    boolean isAbstract();

    /**
     * not interface or abstract
     * @return
     */
    boolean isConcrete();

    /**
     *  class is marked as final
     * @return
     */
    boolean isFinal();


    boolean isIndependent();


    boolean hasEnclosingClass();


    String getEnclosingClassName();


    boolean hasSuperClass();


    String getSuperClassName();


    String[] getInterfaceNames();


    String[] getMemberClassNames();

}
