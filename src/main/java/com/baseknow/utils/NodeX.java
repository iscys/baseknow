package com.baseknow.utils;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import java.util.List;
import java.util.Properties;

public class NodeX {
    private XmlParser xmlParser;
    private Node node;
    private Properties attributes;
    private String name;
    public NodeX(XmlParser parser,Node node){
        this.xmlParser=parser;
        this.node=node;
        this.attributes =getAttributes(node);
        this.name = node.getNodeName();
    }


    /**
     * 获取Node标签下的属性放入properties
     * @param node
     * @return
     */
    public Properties getAttributes(Node node){
        Properties attributes = new Properties();
        NamedNodeMap attributeNodes = node.getAttributes();
        //判断是否为空
        if (attributeNodes != null) {
            for (int i = 0; i < attributeNodes.getLength(); i++) {
                org.w3c.dom.Node attribute = attributeNodes.item(i);
                attributes.put(attribute.getNodeName(), attribute.getNodeValue());
            }
        }
        return attributes;
    }


    public String getStringAttribute(String name) {
        return getStringAttribute(name, null);
    }

    public String getStringAttribute(String name, String def) {
        String value = attributes.getProperty(name);
        if (value == null) {
            return def;
        } else {
            return value;
        }
    }


    public String getNodeName(){
        return name;
    }


    /**
     * 继续解析
     * @param express
     * @return
     * @throws Exception
     */
    public List<NodeX> evalNodes( String express) throws Exception {

        return xmlParser.evalNodes(node,express);
    }

    public NodeX evalNode(String express) throws Exception {

        return xmlParser.evalNode(node,express);
    }

}
