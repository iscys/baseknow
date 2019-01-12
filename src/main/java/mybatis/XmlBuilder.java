package mybatis;

import com.baseknow.utils.XmlParser;

import java.io.InputStream;

public class XmlBuilder {

    MapperScanConfig config;
    XmlParser parser;
    XmlBuilder(InputStream inputStream,MapperScanConfig config)throws Exception{
        this.config=config;
        this.parser=new XmlParser(inputStream);

    }
}
