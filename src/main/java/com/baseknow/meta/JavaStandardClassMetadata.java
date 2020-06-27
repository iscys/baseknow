package com.baseknow.meta;

import java.lang.reflect.Modifier;
import java.util.LinkedHashSet;

public class JavaStandardClassMetadata implements JavaClassMetadata {

    private final Class<?> introspectedClass;

    public JavaStandardClassMetadata(Class<?> introspectedClass){

        this.introspectedClass =introspectedClass;
    }

    public final Class<?> getIntrospectedClass() {
        return this.introspectedClass;
    }

    @Override
    public String getClassName() {
        return this.introspectedClass.getName();
    }

    @Override
    public boolean isInterface() {
        return this.introspectedClass.isInterface();
    }

    @Override
    public boolean isAnnotation() {
        return this.introspectedClass.isAnnotation();
    }

    @Override
    public boolean isAbstract() {
        return Modifier.isAbstract(this.introspectedClass.getModifiers());
    }

    @Override
    public boolean isConcrete() {
        return !(isInterface() || isAbstract());
    }

    @Override
    public boolean isFinal() {
        return Modifier.isFinal(this.introspectedClass.getModifiers());
    }

    @Override
    public boolean isIndependent() {
        return (!hasEnclosingClass() ||
                (this.introspectedClass.getDeclaringClass() != null &&
                        Modifier.isStatic(this.introspectedClass.getModifiers())));
    }

    @Override
    public boolean hasEnclosingClass() {
        return (this.introspectedClass.getEnclosingClass() != null);
    }

    @Override
    public String getEnclosingClassName() {
        Class<?> enclosingClass = this.introspectedClass.getEnclosingClass();
        return (enclosingClass != null ? enclosingClass.getName() : null);
    }

    @Override
    public boolean hasSuperClass() {
        return this.introspectedClass.getSuperclass()!=null;
    }

    @Override
    public String getSuperClassName() {
        Class<?> superclass = this.introspectedClass.getSuperclass();

        return superclass !=null?superclass.getName():null;
    }

    @Override
    public String[] getInterfaceNames() {
        Class<?>[] interfaces = this.introspectedClass.getInterfaces();
        String [] interfacesName = new String[interfaces.length];
        for(int i=0;i<interfaces.length;i++){
            interfacesName[i]=interfaces[i].getName();
        }
        return interfacesName;
    }

    @Override
    public String[] getMemberClassNames() {
        LinkedHashSet<String> memberClassNames = new LinkedHashSet<>(4);
        for (Class<?> nestedClass : this.introspectedClass.getDeclaredClasses()) {
            memberClassNames.add(nestedClass.getName());
        }
        return memberClassNames.toArray(new String[0]);
    }
}
