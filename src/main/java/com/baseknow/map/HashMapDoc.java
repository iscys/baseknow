package com.baseknow.map;

import java.util.HashMap;



/**
 *<p> HashMap 源码分析篇，我的博客地址：
 *<p> <a>https://www.cnblogs.com/iscys/p/10012187.html</a>
 *我们这里为了方便观察不考虑范型
 * @author iscys
 *
 */
public class HashMapDoc {


	public static void main(String[] args) {
		HashMapDoc doc =new HashMapDoc();
		doc.put("r15ty", "323");
		doc.put("rtr8y3", "323");
		doc.put("rtr7y3", "323");
		doc.put("rt6ry3", "323");
		doc.put("r4try3", "323");
		doc.put("rt3ry3", "323");
		doc.put("rtr2y3", "3290888223");
		doc.put("rtr1y3", "323");
		doc.put("rtry93", "323");
		doc.put("rtry83", "323");
		doc.put("rtry73", "323");
		doc.put("rtry63", "323");
		doc.put("rtry53", "323");
		doc.put("rtry43", "323");
		doc.put("rtry33", "323");
		doc.put("rtry23", "323");
		doc.put("rtry13", "329993");
		Object object = doc.get("rtr2y3");
		System.err.println(object);
		
		//0000-1111
		//0001-0000
		//0000-1010
		//0001-0100
		//100000
		//000101
		//System.out.println("eertiri".hashCode() & 32);
		System.out.println(75483495 & 63);
		
	}
	/**
	 * 因为map 是由数组和链表的结构组成的，且每一个数据都维护着键和值的信息；
	 * 所以在hashmap 的源码中维护着一个节点对象，用于保存用户传过来的键值信息；
	 * 
	 * @param args
	 */

	
	static class Node{
		//hash值
		int hash;
		Object key;//key 
		Object value; //value
		Node next; //因为是单向链表的结构，所以会维护着下一个节点的信息进行链表
		//构造函数，维护添加节点的信息
		Node(int hash,Object key,Object value ,Node next){
			this.hash=hash;
			this.key=key;
			this.value =value;
			this.next=next;
		}
	}
	//Node数组
	Node[] tables;
	//数组扩容的临界值 = 数组大小*加载因子
	int threshold;
	//加载因子，用于表示，数组扩容的临界值（阈值）
	static final float LOAD_FACTOR =0.75f;
	//默认初始化数组的大小1<<4 =16
	static final int DEFAULT_SIZE =1<<4;
	//数组扩容最大到多少
	 static final int MAXIMUM_CAPACITY = 1 << 30;
	//size,记录容器的元素;
	int size;
	//modify；修改的次数
	int modify;
	
	
	
	HashMapDoc(){
	//new HashMap();
	}
	
	//元素添加操作,如果有替换的操作，返回旧的值
	public Object put (Object key,Object value) {
		//计算hash
		
		return  putval(hash(key),key,value);
		
	}
	  static final int hash(Object key) {
	        int h;
	        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	    }

	private Object putval(int hash, Object key, Object value) {
		Node [] tab;
		Node p;
		int n;
		int i;//记录数组下标
		//在第一次操作的什么，肯定是空，要进行初始化的操作
		if((tab=tables)==null || (n=tab.length)==0) {
			//数组大小为16
			tab=tables =new Node[DEFAULT_SIZE];
			n =tab.length;
			//扩容的临界值为
			threshold =(int) (DEFAULT_SIZE*LOAD_FACTOR);
		}
		//数据的填充, 以下相当于取莫运算，保证数组不越界以及命中数组空栏位，提升查询效率
		if((p=tables[i=(n-1) & hash])==null) {
			//为空说明数组下表没有元素，则添加
			tab[i]=new Node(hash,key,value,null);
		}
		else {
			//否则，就包含了，如果是添加元素的key 在数组中存在了，就进行value替换
			Node v;
			if(p.hash==hash && p.key==key) {
				//在后面进行重新赋值
				v=p;
				}
			else {
				//进行链表的操作
				for(int nucount=0; ;nucount++) {
					//如果 节点的next 为空说明我们可以进行链表的操作，跳出循环
					if((v=p.next)==null) {
						//给节点的next 赋值
						p.next = new Node(hash,key,value,null);
						break;
					}
					//判断链表key 是否重复
					if(v.hash==hash && v.key ==key) {
						v=p;
					}
				}
				
				}
			
			//新值替换旧值,如果存在重复的key
			if(v!=null) {
				Object oldValue =v.value;
				//重新赋值
				v.value =value;
				//返回旧值
				return oldValue;
			}
		}
		
		//添加完之后需要进行后续判断1.size++ 2.是否需要扩容
		modify++;
		//进行扩容
		if(++size >threshold) {
			resize();
		}
		
		return null;
	
		
	}
	/**
	 * 扩容操作
	 */
	private void resize() {
			Node[] oldTab = tables;
	        int oldCap = (oldTab == null) ? 0 : oldTab.length;
	        int oldThr = threshold;
	        int newCap, newThr = 0;
	        //2倍的扩容 16 -32-64
	        if((newCap =oldCap<<1)<MAXIMUM_CAPACITY && oldCap>=DEFAULT_SIZE) {
	        	threshold = oldThr <<1 ; //也是两倍
	        }
	        Node [] newTable =new Node[newCap];
	        tables =newTable; 
	        //在新的数组容器中，重新进行Node的分配，为什么呢，就是为了能在数组展示的尽量在数组展示，
	        //因为一链表查询就会慢了；
	        if(oldTab !=null) {
	        	//这里操作就是将没扩容之前数组遍历，重新计算，放入新的数组中；
	        	for(int j=0;j<oldCap;j++) {
	        		Node v ;
	        		
	        		if((v=oldTab[j])!=null) {
	        			//如果不存在下一个链表元素，直接进行重新计算放入数组
	        			if(v.next !=null) {
	        				newTable[(newCap-1)&v.hash] =v;
	        			}
	        			else {
	        				//否则就是原来的数组中存在链表
	        				Node loHead = null, loTail = null;
	                        Node hiHead = null, hiTail = null;
	                        Node next;
	                        do {
	                        next =v.next;
	                        //位置不变
	                        if((v.hash & oldCap )==0) {
	                        	if(loHead ==null) {
	                        		loHead=v;
	                        	}else {
	                        		loHead.next=v;
	                        		loTail=v;
	                        	}
	                        }
	                        else {
	                        	//位置改变
                                if (hiTail == null)
                                    hiHead = v;
                                else
                                    hiTail.next = v;
                                hiTail = v;
                            }
	                        }
	                        while((v=next)!=null);
	                        if (loTail != null) {
	                            loTail.next = null;
	                            newTable[j] = loHead;
	                        }
	                        if (hiTail != null) {
	                            hiTail.next = null;
	                            newTable[j + oldCap] = hiHead;
	                        }
	        				
	        				
	        			}
	        		}
	        		
	        		
	        	}
	        }
	        
	        
		
	};
	
	
	
	
	Object get(Object key) {
		//先算hash 
		int hash = hash(key);
		Node [] table ;
		Node first;
		Node e;
		int n;
		if((table=tables)!=null && (n=table.length)>0 && (first =table[(n-1) &hash])!=null) {
			if(first.hash==hash && (first.key).equals(key)) {
				return first.value;
			}
			if((e=first.next)!=null) {
				do {
					if(first.hash==hash && (first.key).equals(key)) {
						return first.value;
					}
				}
				while((e=e.next)!=null);
			}
		}
		
		return null;
	}
	
	
	
}
