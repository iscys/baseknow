package com.baseknow.utils;

import org.w3c.dom.CharacterData;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.List;
import java.util.Properties;

public class NodeX {
    private XmlParser xmlParser;
    private Node node;
    private Properties attributes;
    private String name;
    private String body;
    public NodeX(XmlParser parser,Node node){
        this.xmlParser=parser;
        this.node=node;
        this.attributes =getAttributes(node);
        this.name = node.getNodeName();
        this.body =parseBody(node);
    }



    public NodeX newXNode(Node node) {
        return new NodeX(xmlParser, node);
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

    public Integer getIntAttribute(String name) {
        return getIntAttribute(name, null);
    }

    public Integer getIntAttribute(String name, Integer def) {
        String value = attributes.getProperty(name);
        if (value == null) {
            return def;
        } else {
            return Integer.parseInt(value);
        }
    }

    public Long getLongAttribute(String name) {
        return getLongAttribute(name, null);
    }

    public Long getLongAttribute(String name, Long def) {
        String value = attributes.getProperty(name);
        if (value == null) {
            return def;
        } else {
            return Long.parseLong(value);
        }
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

    /**
     * 获取标签下的内容，不会返回嵌套标签的内容，方便解析
     * @param node
     * @return
     */
    public  String parseBody(Node node){
        String data = getBodyData(node);
        if(null==data){
            NodeList children = node.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                Node child = children.item(i);
                data = getBodyData(child);
                if (data != null) break;
            }
        }
        return data;
    }

    public String getBodyData(Node child){
        if (child.getNodeType() == Node.CDATA_SECTION_NODE
                || child.getNodeType() == Node.TEXT_NODE) {
            String data = ((CharacterData) child).getData();
            return data;
        }
        return null;
    }

    public Node getNode(){
        return node;
    }

    public String getStringBody() {
        return getStringBody(null);
    }

    public String getStringBody(String def) {
        if (body == null) {
            return def;
        } else {
            return body;
        }
    }


}
