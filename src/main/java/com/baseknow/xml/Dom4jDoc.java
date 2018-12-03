package com.baseknow.xml;

import java.io.File;
import org.dom4j.Document;
import com.baseknow.utils.ResourceUtils;
import com.baseknow.utils.XmlParseUtils;

public class Dom4jDoc {
	
	
	public static void main(String[] args) throws Exception {
	
		File file = ResourceUtils.getFile("springTest/beandefiniition.xml");
		
		Document doc = XmlParseUtils.getDom4jDocument(file);
		System.out.println(doc.getRootElement());
		
		
		
		
	}

}
