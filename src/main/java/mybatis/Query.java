package mybatis;


import java.util.List;

public class Query{

    public static <T> void queryPage(SqlQueryTemplate<T> query, int length, int limit){

        List<T> ts = query.loadData();
        query.total(length,limit);

    }
}