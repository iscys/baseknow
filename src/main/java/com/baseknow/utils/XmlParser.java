package com.baseknow.utils;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 解析XML类,java 内置解析器
 * evalNode 使用Xpath 进行解析；
 * 解析的Node 封装成NodeX 进行方便的解析
 */
public class XmlParser {
    private Document document;
    private XPath xpath;
    public XmlParser(InputStream inputStream) throws Exception{
        this.document =createDocument(inputStream);
        this.xpath =createXpath();
    }

    public Document createDocument(InputStream inputStream) throws Exception{

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();//创建解析工厂
        factory.setNamespaceAware(false);//是否支持XML 命名空间
        factory.setIgnoringComments(true);//忽略掉注释
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document parse = builder.parse(inputStream);
        return parse;

    }
    public XPath createXpath(){
        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        return xpath;
    }

    /**
     * 返回的是单个Node
     * @param express
     * @return
     * @throws Exception
     */
    public NodeX evalNode(String express)throws Exception{

        return evalNode(document,express);

    }
    public NodeX evalNode(Object root,String express) throws Exception{

        Node node= (Node) xpath.evaluate(express,root, XPathConstants.NODE);

        return new NodeX(this,node);
    }

    /**
     * 返回NodeList
     * @param express
     * @throws Exception
     */
    public List<NodeX> evalNodes(String express) throws Exception{
       return evalNodes(document,express);
    }


    public List<NodeX> evalNodes(Object root,String express) throws Exception{

        List<NodeX> xnodes = new ArrayList<>();
        NodeList nodes = (NodeList)xpath.evaluate(express, root, XPathConstants.NODESET);
        for(int i=0;i<nodes.getLength();i++){
            xnodes.add(new NodeX(this,nodes.item(i)));
        }
        return xnodes;
    }


    public static void main(String[] args) throws Exception{
        XmlParser parser =new XmlParser(new FileInputStream(ResourceUtils.getFile("springTest/ImageDisplayMapper.xml")));
        NodeX nodeX = parser.evalNode("//select");
        NodeList childNodes = nodeX.getNode().getChildNodes();
        for(int i=0;i<childNodes.getLength();i++){
            NodeX child = nodeX.newXNode(childNodes.item(i));
            if (child.getNode().getNodeType() == Node.CDATA_SECTION_NODE
                    || child.getNode().getNodeType() == Node.TEXT_NODE) {
                System.out.println(child.getStringBody(""));
            }
        }

    }
}
