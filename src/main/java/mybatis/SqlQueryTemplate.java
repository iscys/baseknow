package mybatis;


import java.util.List;

public interface SqlQueryTemplate<T> {

    public List<T> loadData();

    public int total(int length,int limit);
}



