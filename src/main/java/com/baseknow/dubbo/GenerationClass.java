package com.baseknow.dubbo;



import org.apache.dubbo.common.extension.Adaptive;

import java.lang.reflect.Method;

public class GenerationClass {

    public static void main(String[] args) throws Exception {
        String code = generation();
        System.out.println(code);

    }

    public static String generation() throws Exception{
        StringBuilder code = new StringBuilder();
        Class<?> type = Class.forName("com.baseknow.dubbo.IdubboService");
        Method[] methods = type.getMethods();

        boolean hasAnnotation =false;
        for(Method m:methods){
           if(m.isAnnotationPresent(Adaptive.class)){
           hasAnnotation =true;
           break;}
        }
        if(!hasAnnotation){
            throw new  IllegalArgumentException("不存在Adapter 注解");
        }
        code.append("package "+type.getPackage().getName()+";");
        code.append("\nimport java.lang.Exception;");
        code.append("\npublic class DubboService$Adapter"+" implements "+type.getCanonicalName()+" {");
        for(Method m:methods){

            Class<?> returnType = m.getReturnType();
            String name = m.getName();
            Class<?>[] parameterTypes = m.getParameterTypes();
            code.append("\npublic "+returnType.getCanonicalName()+" "+name+"(");
            for(int i=0;i<parameterTypes.length;i++){
                if (i > 0) {
                    code.append(", ");
                }
                code.append(parameterTypes[i].getCanonicalName());
                code.append(" arg"+i);
            }
            code.append("){");
            code.append("\n}");
        }

        System.out.println(type);
        code.append("\n}");
        return code.toString();
    }
}
