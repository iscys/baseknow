package mybatis;

import com.baseknow.utils.NodeX;

public class XmlStatementBuilder {

    private NodeX context;
    private MapperConfiguration config;
    public XmlStatementBuilder(NodeX node,MapperConfiguration config){
        this.context=node;
        this.config=config;
    }

    public void parse()throws Exception{
        String id = context.getStringAttribute("id");
        String parameterType = context.getStringAttribute("parameterType");
        Class<?> parameterTypeClass = resolveClass(parameterType);
        String resultType = context.getStringAttribute("resultType");
        Class<?> resultTypeClass = resolveClass(resultType);
        parseDynsql(context);
        MapperStatementSql builder =new MapperStatementSql();
        config.addMapperStatement(builder);


    }

    public void parseDynsql(NodeX context){

    }

    public Class resolveClass(String classType) throws Exception{

        return Class.forName(classType);

    }


}
