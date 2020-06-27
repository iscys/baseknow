package com.baseknow.map;


import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.HashMap;

public class DefaultUdfFileChooserFactory implements FileChooserFactory {

    public static DefaultUdfFileChooserFactory INSTANCE = new DefaultUdfFileChooserFactory();

    private DefaultUdfFileChooserFactory() { }


    public FileChooser  newChooser (int mainFileCount, String tenantId){

      return  new GenericUdfFileChooser(mainFileCount,tenantId);

    }

    private static final class GenericUdfFileChooser implements FileChooser {
        private static final  String FILE_PREFIX ="rule_slot_";
        private String tenantId;
        private int fileSlot;
        private int mainFileCount;

        GenericUdfFileChooser(int mainFileCount,String tenantId){
            this.tenantId =tenantId;
            this.mainFileCount =mainFileCount;
            this.fileSlot =Math.abs((tenantId.hashCode())%mainFileCount);
        }



        public int getFileSlot() {
            return fileSlot;
        }
        public int getFileCount(){
            return mainFileCount;
        }
        public String getTenantId(){
            return tenantId;
        }

        @Override
        public String getMainFileName() {
            return String.format(getFormatPartFileName(),"0");
        }

        @Override
        public String getFormatPartFileName() {
            String formatPartFileName =FILE_PREFIX+fileSlot+"_%s.properties";
            return formatPartFileName;
        }
    }

    public static void main(String[] args) throws Exception {

        HashMap map =new HashMap();
        map.put("123","vistivm\n");
        HashMap map1 =new HashMap();
        map1.put("1123","vistivmdsf");
        map1.put("dwe","vissfstivm");
        String s = JSON.toJSONString(map);

        String s1 = JSON.toJSONString(map1);
        String s2 =s+"\n"+s1;
System.out.println(s2);
        FileOutputStream out =new FileOutputStream("/Users/iscys/IdeaProjects/baseknow/src/main/resources/rule.properties");

        out.write(s2.getBytes());
        out.close();

/**
        InputStream resourceAsStream = DefaultUdfFileChooserFactory.class.getResourceAsStream("/rule.properties");
        InputStreamReader reader =new InputStreamReader(resourceAsStream);
        BufferedReader buff =new BufferedReader(reader);
        String s = buff.readLine();
        System.out.println(s);
 **/
    }
}
