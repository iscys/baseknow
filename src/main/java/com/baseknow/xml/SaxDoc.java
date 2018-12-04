package com.baseknow.xml;

import java.io.File;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.baseknow.utils.ResourceUtils;
import com.baseknow.utils.XmlParseUtils;

public class SaxDoc {
	
	
	public static void main(String[] args) throws Exception {
		File file = ResourceUtils.getFile("springTest/ImageDisplayMapper.xml");
		Document doc = XmlParseUtils.getJaxpDocument(null, file);
		XPath xpath = XmlParseUtils.getXpath();
		Node evaluate = (Node) xpath.evaluate("/mapper/select", doc,XPathConstants.NODE);
		
		NodeList childNodes = evaluate.getChildNodes();
		System.out.println(childNodes.getLength());
		for(int i=0;i<childNodes.getLength();i++) {
			Node item2 = childNodes.item(i);
			System.out.println(item2);
		}
	}

}
