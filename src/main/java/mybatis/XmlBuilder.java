package mybatis;

import com.baseknow.utils.NodeX;
import com.baseknow.utils.XmlParser;

import java.io.InputStream;
import java.util.List;

public class XmlBuilder {

    private MapperConfiguration config;
    private  XmlParser parser;
    XmlBuilder(InputStream inputStream,MapperConfiguration config)throws Exception{
        this.config=config;
        this.parser=new XmlParser(inputStream);

    }


    public void parse() throws Exception {
        configurationElement(parser.evalNode("/mapper"));

    }

    private void configurationElement(NodeX context)throws Exception {

        String nameSpace =context.getStringAttribute("namespace");
        //解析xml 中select delete update insert 标签
        BuidStatementFormContext(context.evalNodes("select|delete|update|insert"));
    }

    private void BuidStatementFormContext(List<NodeX> evalNodes) throws Exception {
        for(NodeX node :evalNodes) {
            XmlStatementBuilder builder = new XmlStatementBuilder(node,config);
            builder.parse();
        }
    }
}
