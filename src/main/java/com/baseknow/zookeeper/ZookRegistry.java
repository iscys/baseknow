package com.baseknow.zookeeper;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.exception.ZkNoNodeException;
import org.I0Itec.zkclient.exception.ZkNodeExistsException;

import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;

/**
 * zookeeper 连接操作方法
 */
public class ZookRegistry {

    private final ZkClient client;

    /**
     * 连接zookeeper，超时时间为5秒
     * @param url
     */
    ZookRegistry(String url){
        this.client=new ZkClient(url,5000);
    }
    /**
     * 连接zookeeper，设置超时时间
     * @param url
     * @param timeout
     */
    ZookRegistry(String url,int timeout){
        this.client=new ZkClient(url,timeout);
    }

    /**
     * 创建一个持续的递归链接
     * 比如你可以直接创建一个 eg: /dubbo/zk/xxx 的递归目录
     * @param path
     */
    public void createPersistent(String path) {
        try {
            client.createPersistent(path, true);
        } catch (ZkNodeExistsException e) {
        }
    }

    /**
     * 创建一个短的链接,节点只能一个一个的创建
     * 不支持递归链接
     * @param path
     */
    public void createEphemeral(String path) {
        try {
            client.createEphemeral(path);
        } catch (ZkNodeExistsException e) {
        }
    }

    /**
     * 删除节点,只能一个节点一个节点的删除
     * @param path
     */
    public void delete(String path) {
        try {
            client.delete(path);
        } catch (ZkNoNodeException e) {
        }
    }

    /**
     * 与delete 相反，
     * @param path
     */
    public void deleteRecursive(String path){
        try {
            client.deleteRecursive(path);
        } catch (ZkNoNodeException e) {
        }
    }

    /**
     * 得到子节点
     * @param path
     */
    public List<String> getChildren(String path) {
        try {
            return client.getChildren(path);
        } catch (ZkNoNodeException e) {
            return null;
        }
    }



    /**
     * 断开链接
      */
    public void doClose() {
        client.close();
    }

    /**
     * 返回zkClinet 对象
     * @return
     */
    public ZkClient getClient(){
        return client;
    }

    public static void main(String[] args) {
        ZookRegistry zkClient =new ZookRegistry("47.95.245.138:2181",5000);
        System.out.println(zkClient.getClient());
        List<String> children = zkClient.getChildren("/dubbo/com.baseknow.dubbo.IdubboService");
        System.out.println(children);
        // zkClient.create("/cys/zka");


    }

}
