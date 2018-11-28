package com.baseknow.url;

import java.net.URI;
import java.net.URL;

public class UrlDoc {
	
	public static void main(String[] args) throws Exception {
		URL url =new URL("http://www.com:8080?qwq=qwq&ddww=ww");
		System.out.println(url.getQuery());
		System.out.println(url.getHost());
		System.out.println(url.getProtocol());
		System.out.println(url.getFile());
		System.out.println(url.getDefaultPort());//80
	}

}
