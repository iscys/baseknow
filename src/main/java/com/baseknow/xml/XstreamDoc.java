package com.baseknow.xml;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.baseknow.testclass.XmlPojo;
import com.baseknow.testclass.XmlPojo.Msg;
import com.baseknow.utils.XmlParseUtils;
import com.thoughtworks.xstream.XStream;

/**
 * 将pojo -->xml 
 * pojo 转换为xml
 * @author cys
 *
 */
public class XstreamDoc {
	
	public static void main(String[] args) {
		
		
		XStream xstream = new XStream();
		XmlPojo po =new XmlPojo("123","123","123");
		
		Msg msg =new Msg("ss","ss");
		Msg msg2 =new Msg("ss1","ss1");
		List li =new ArrayList<>();
		li.add(msg2);li.add(msg);
		po.setMsg(li);
		String pojoToXml = XmlParseUtils.pojoToXml(po);
	//	xstream.processAnnotations(po.getClass());
		//xstream.processAnnotations(getInnerClasses(po.getClass()));
	//	String xml = xstream.toXML(po);
		System.out.println(pojoToXml);
		//转pojo
	XmlPojo poo = XmlParseUtils.xmlToPojo(po.getClass(), pojoToXml);
	poo.getMsg();
	}
	private static Class<?>[] getInnerClasses(Class<?> clz) {
	    Class<?>[] innerClasses = clz.getClasses();
	    if (innerClasses == null) {
	      return null;
	    }

	    List<Class<?>> result = new ArrayList<>();
	    result.addAll(Arrays.asList(innerClasses));
	    for (Class<?> inner : innerClasses) {
	      Class<?>[] innerClz = getInnerClasses(inner);
	      if (innerClz == null) {
	        continue;
	      }

	      result.addAll(Arrays.asList(innerClz));
	    }

	    return result.toArray(new Class<?>[0]);
	  }
}
