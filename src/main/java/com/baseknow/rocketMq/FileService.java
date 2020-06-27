package com.baseknow.rocketMq;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
@Configuration
public class FileService {

    public static void main(String[] args) throws Exception {

        final Class<?>[] interfaces = Configuration.class.getInterfaces();
        System.out.println(interfaces);

        final Controller annotation = AnnotationUtils.findAnnotation(FileService.class, Controller.class);

        System.out.println(annotation);
        RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
        String name = runtime.getName();
       System.out.println(name);
       Thread.sleep(10000000);
    }
}
