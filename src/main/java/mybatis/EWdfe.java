package mybatis;

import java.util.List;

public class EWdfe {

    public static void qude(){
        Query.queryPage(new SqlQueryTemplate<NormalJdbc>() {
            @Override
            public List<NormalJdbc> loadData() {
                return null;
            }

            @Override
            public int total(int length, int limit) {
                return 0;
            }
        },100,12);
    }
}
