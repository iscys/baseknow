package mybatis;

import java.util.concurrent.ConcurrentHashMap;

public class MapperConfiguration {

    //存放生sql 的map ，通过id 查询对应的sql
    private ConcurrentHashMap<String,MapperStatementSql> statement =new ConcurrentHashMap<>();

    /**
     * 存放statement
     */
    public void addMapperStatement(MapperStatementSql sql){
        statement.put(sql.getId(),sql);
    }

    /**
     * 得到statement
     */
    public ConcurrentHashMap getStatement(){
        return statement;
    }
}
