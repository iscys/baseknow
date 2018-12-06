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
		
		XmlPojo po =new XmlPojo("123","123","123");
		
		Msg msg =new Msg("ss","ss");
		Msg msg2 =new Msg("ss1","ss1");
		List li =new ArrayList<>();
		li.add(msg2);li.add(msg);
		po.setMsg(li);
		String pojoToXml = XmlParseUtils.pojoToXml(po);
		System.out.println(pojoToXml);
		//转pojo
		XmlPojo poo = XmlParseUtils.xmlToPojo(po.getClass(), pojoToXml);
		System.out.println(poo);
	}
	
}
