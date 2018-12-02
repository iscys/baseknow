package com.baseknow.xml;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.baseknow.utils.ResourceUtils;

/**
 * xpath 的使用
 * @author iscys
 *
 */
public class XpathDoc {
	
	
	public static void main(String[] args) throws Exception {
		Document document = getDocument();
		//获取xpath的对象
		  XPathFactory factory = XPathFactory.newInstance();
		  XPath xpath = factory.newXPath();
		  Node evaluate = (Node)xpath.evaluate("/mapper", document,XPathConstants.NODE);
		  System.out.println(evaluate.getAttributes().item(0).getNodeName());
		  Node evaluate2 = (Node) xpath.evaluate("select", evaluate, XPathConstants.NODE);
		 // System.out.println(evaluate2.getTextContent());
		  NodeList evaluate3 = (NodeList) xpath.evaluate("select|insert|update|delete", evaluate, XPathConstants.NODESET);
		  String select = evaluate3.item(0).getTextContent();
		  System.out.println(select);
		  
	}
	
	
	
	static Document getDocument() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		File file = ResourceUtils.getFile("springTest/ImageDisplayMapper.xml");
		return builder.parse(file);
	}

}
