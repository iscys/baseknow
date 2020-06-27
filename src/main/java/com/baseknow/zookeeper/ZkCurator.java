package com.baseknow.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

import java.util.List;

/**
 * Curator zookeeper
 * @author iscys
 */

public class ZkCurator {

    private CuratorFramework client;


    public ZkCurator(String address){
        CuratorFrameworkFactory.Builder builder = CuratorFrameworkFactory.builder().connectString(address)
                .retryPolicy(new RetryNTimes(1, 1000))
                .connectionTimeoutMs(5000);
        //构造CuratorFramework 实例
        client= builder.build();
        client.start();



    }

    /**
     * 创建永久节点
     * @param path
     */
    public void createPersistent(String path) {
        try {
            client.create().forPath(path);
        } catch (KeeperException.NodeExistsException e) {
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    /**
     * 创建临时节点
     * @param path
     */
    public void createEphemeral(String path) {
        try {
            client.create().withMode(CreateMode.EPHEMERAL).forPath(path);
        } catch (KeeperException.NodeExistsException e) {
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    /**
     * 递归创建临时节点
     * @param path
     */
    public void createParentEphemeral(String path) {
        try {
            client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath(path);
        } catch (KeeperException.NodeExistsException e) {
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    /**
     * 递归创建永久节点
     * @param path
     */
    public void createParentPersistent(String path) {
        try {
            client.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath(path);
        } catch (KeeperException.NodeExistsException e) {
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    /**
     * 删除节点
     * @param path
     */

    public void delete(String path) {
        try {
            client.delete().forPath(path);
        } catch (KeeperException.NoNodeException e) {
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    /**
     * 获取子节点
     * @param path
     * @return
     */
    public List<String> getChildren(String path) {
        try {
            return client.getChildren().forPath(path);
        } catch (KeeperException.NoNodeException e) {
            return null;
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    /**
     * 是否连接
     * @return
     */
    public boolean isConnected() {
        return client.getZookeeperClient().isConnected();
    }

    /**
     * 添加对子节点的监听
     * @param listener 监听器，必须实现  CuratorWatcher 接口
     * @param path
     * @return 节点下的子节点数组
     *
     */

    public List<String> addTargetChildListener(CuratorWatcher listener,String path){
        try {

            return client.getChildren().usingWatcher(listener).forPath(path);

        } catch (KeeperException.NoNodeException e) {
            return null;
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        }


    }

    public void doClose() {
        client.close();
    }



    public static void main(String[] args) throws Exception {

        ZkCurator zkCurator = new ZkCurator("47.95.245.138:2181");
        Thread.sleep(1000);
        System.out.println(zkCurator.isConnected());

        zkCurator.createParentEphemeral("/iscys/iscys/iscys");
        zkCurator.createParentEphemeral("/iscys/iscys/iscys1");


        List<String> strings = zkCurator.addTargetChildListener(new CuratorWatcher() {
            @Override
            public void process(WatchedEvent event) throws Exception {
                String path = event.getPath();
                System.out.println("iscys" + path);
            }
        }, "/iscys/iscys");

        System.out.println(strings.toString());


        zkCurator.addTargetChildListener(new CuratorWatcher() {
            @Override
            public void process(WatchedEvent event) throws Exception {
                String path = event.getPath();
                System.out.println("mycys"+path);
            }
        },"/mycys/mycys");



        Thread.sleep(10000000);

    }




}
