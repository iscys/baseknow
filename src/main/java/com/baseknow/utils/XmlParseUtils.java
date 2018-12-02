package com.baseknow.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 * xml 工具类
 * 包含jaxp 解析器的创建；
 * Xpath 解析器的创建；
 * dom4j 解析器创建；
 * 获取XML document 对象；
 * 获取Node attriute
 * xml 的转换
 * @author iscys
 *
 */
public class XmlParseUtils {
	
	/**
	 *  获取 jaxp XML 解析器
	 *  位于javax 包中，Java 内置支持
	 * @throws ParserConfigurationException 
	 */
	
	public static  DocumentBuilder getXmlBuilder() throws ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		return builder;
	}
	
	/**
	 * 获取xpath的实例对象
	 */
	public static XPath getXpath() {
		  XPathFactory factory = XPathFactory.newInstance();
		  XPath xpath = factory.newXPath();
		  return xpath;
	}
	
	/**
	 * jaxp 获取Document 对象,通过一个文件对象
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public static Document getDocumentViaFile(DocumentBuilder builder,File file) throws Exception {
		DocumentBuilder xmlBuilder;
		if((xmlBuilder=builder)==null) {
			xmlBuilder=getXmlBuilder();
		}
		return xmlBuilder.parse(file);
		
	}
	
	/**
	 * jaxp 获取Document 对象,通过一个输入流
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public static Document getDocumentViaStream(DocumentBuilder builder,InputStream stream) throws Exception {
		DocumentBuilder xmlBuilder;
		if((xmlBuilder=builder)==null) {
			xmlBuilder=getXmlBuilder();
		}
		return xmlBuilder.parse(stream);
		
	}
	
	/**
	 * 将node 属性key value 存放到 Properties 中；eg:
	 * <test  name ="mytest" class="com.XX.XX">
	 * 将name ->mytest
	 * class -> com.XXX.XXX
	 * 存入Properties
	 * 
	 */
	public static Properties parseNodeAttributes(Node n) {
		  Properties attributes = new Properties();
		    NamedNodeMap attributeNodes = n.getAttributes();
		    //判断是否为空
		    if (attributeNodes != null) {
		      for (int i = 0; i < attributeNodes.getLength(); i++) {
		        Node attribute = attributeNodes.item(i);
		        attributes.put(attribute.getNodeName(), attribute.getNodeValue());
		      }
		    }
		    return attributes;
	}

}
