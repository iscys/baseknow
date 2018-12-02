package com.baseknow.xml;

import java.io.File;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.baseknow.utils.ResourceUtils;
import com.baseknow.utils.XmlParseUtils;

/**
 * 使用jaxp dom 解析XML
 * @author iscys
 *
 */
public class JaxpDomDoc {
	
	
	public static void main(String[] args) throws Exception {
		//obtain 工厂对象
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//obtain DocumentBuilder via DocumentBuilderFactory
		DocumentBuilder docBuilder = factory.newDocumentBuilder();
		File file = ResourceUtils.getFile("springTest/beandefiniition.xml");
		//获取document 对象
		Document parse = docBuilder.parse(file);
		//查询节点
		NodeList elementsByTagName = parse.getElementsByTagName("bean");
		
		Node item = elementsByTagName.item(1);
		
		//获取标签的属性键值对；
		Properties parseNodeAttributes = XmlParseUtils.parseNodeAttributes(item);
		
		NamedNodeMap attributes = item.getAttributes();
		System.out.println(attributes.item(0).getNodeName());
		System.out.println(attributes.item(0).getNodeValue());
		
		
	}

}
