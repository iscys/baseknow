package com.baseknow.array;
/**
 * 数组排序
 * @author iscys
 *
 */
public class Paixu1 {
	
	
	
	
	public static void main(String[] args) {
		//maopao();
		normal();
	}
	/**
	 * 冒泡排序
	 */
	static void maopao() {
		int[] arrys = new int[] {9,6,4,7,3,1,4,5,98,34,78,2,8};
		
		for(int i=0;i<arrys.length;i++) {
			//不减1 会造成数组越界
			for(int j=0;j<arrys.length-1;j++) {
				int a =arrys[j];
				int b =arrys[j+1];
				int tmp;
				if(a>b) {
					tmp =a;
					a=b;
					b=tmp;
					arrys[j]=a;
					arrys[j+1]=b;
				}
			}
		}
		for(int i =0;i<arrys.length;i++) {
			System.out.print(arrys[i]);
		}
	}
	
	//常规排序
	static void normal() {
		int[] arrys = new int[] {9,6,4,7,3,1,4,5,98,34,78,2,8};
		
		for(int i=0;i<arrys.length;i++) {
			for(int j=i+1;j<arrys.length;j++) {
				int a =arrys[i];
				int b =arrys[j];
				int tmp;
				if(a>b) {
					tmp =a;
					a=b;
					b=tmp;
					arrys[i]=a;
					arrys[j]=b;
				}
			}
		}
		
		for(int i =0;i<arrys.length;i++) {
			System.out.print(arrys[i]);
		}
	}
}
