package com.baseknow.map;

import java.util.Comparator;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * TreeMap 
 * 二叉树，
 * 红黑树
 * 
 * @author iscys
 *
 */
public class TreeMapDoc<K,V> {
	//树的根节点
	private AclNode<K, V> root;
	//size
	private int size;
	private Comparator<K> compa;

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return size == 0 ? false : true;
	}

	public int compare(K a, K b) {
		if (compa != null) {
			return compa.compare(a, b);
		} else {
			@SuppressWarnings("unchecked")
			Comparable<K> c = (Comparable<K>) a;
			return c.compareTo(b);
		}
	}

	/**
	 * 插入操作
	 *
	 * @param key
	 * @param value
	 */
	public void put(K key, V value) {
		if (null == root) {
			root = new AclNode(key, value);
			++size;
		} else {
			AclNode<K, V> p = root;
			while (null != p) {
				int ex = compare(key, p.k);
				if (ex == 0) {
					p.setValue(value);
					break;
				} else if (ex < 0) {

					if (p.left == null) {
						p.left = new AclNode(key, value);
						++size;
						break;
					} else {
						p = p.left;
					}
				} else {

					if (p.right == null) {
						p.right = new AclNode(key, value);
						++size;
						break;
					} else {
						p = p.right;
					}

				}


			}
		}
	}

	/**
	 * 查找操作
	 * 比较+递归
	 */

	public AclNode<K, V> getEntity(K key) {
		AclNode<K, V> p = root;

			while (p != null) {
				int ex = compare(key, p.k);
				if (ex < 0) {
					p = p.left;
				} else if (ex > 0) {
					p = p.right;
				} else {
					return p;
				}
			}
			return null;
		}
	/**
	 * 删除
	 */
	public void delete(K key){
		AclNode<K, V> p = root;

		while (p != null) {
			int ex = compare(key, p.k);
			if (ex < 0) {
				p = p.left;
			} else if (ex > 0) {
				p = p.right;
			} else {
				
			}
		}


	}

	/**
	 * 得到最小的节点
	 */

	public AclNode<K,V> getFirstNode(AclNode<K,V> node){
		AclNode<K,V> p =node;
		if(p!=null){
			while(p.left!=null){
				p=p.left;
			}
		}
		return p;
	}
	/**
	 * 得到最大节点
	 */
	public AclNode<K,V> getLastNode(AclNode<K,V> node){
		AclNode<K,V> p =node;
		if(p!=null){
			while(p.right!=null){
				p=p.right;
			}
		}
		return p;
	}


    /**
     * remove
     */

    public V remove(K key){

        AclNode<K, V> entity = getEntity(key);
        if(entity!=null){

            if(entity.left !=null && entity.right !=null){
                AclNode<K, V> rightMin = getFirstNode(entity.right);
            }
        }


    }
}



/**
 * node tree
 * key.value
 * tree left tree right
 * @author iscys
 *
 * @param <K>
 * @param <V>
 */
class AclNode<K,V> implements Entry<K, V>{
	 K k;
	 V v;
	 AclNode<K,V> left;
	 AclNode<K,V> right;
	
	
	@Override
	public String toString() {
		return "AclNode [k=" + k + ", v=" + v + "]";
	}

	public AclNode(K k, V v) {
		super();
		this.k = k;
		this.v = v;
	}

	public K getKey() {
		return this.k;
	}

	@Override
	public V getValue() {
		return this.v;
	}

	@Override
	public V setValue(V value) {
		return this.v=value;
	}

}