关于Java 基础知识，框架，集合，utils的总结


nohup sh mqbroker -n localhost:9876 &
nohup sh mqnamesrv &>>nohup.out
java -Djava.ext.dirs=${JAVA_HOME}/jre/lib/ext:${PWD}/lib org.apache.rocketmq.namesrv.NamesrvStartup