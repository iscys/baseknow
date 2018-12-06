package com.baseknow.testclass;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class XmlPojo {
	@XStreamAlias("timespace")
	private String times;
	@XStreamAlias("unionid")
	private String unionid;
	@XStreamAlias("openid")
	private String openid;
	@XStreamAlias("items")
	private List<Msg> msg;
	
	public XmlPojo(String times,String unionid,String openid){
		this.times =times;
		this.unionid =unionid;
		this.openid =openid;
	}
	
	@XStreamAlias("item")
	public static class  Msg{
		@XStreamAlias("content")
		private String content;
		@XStreamAlias("tocode")
		private String code;
		public Msg(String content,String code){
			this.content=content;
			this.code=code;
		}
	}
	
	



	public List<Msg> getMsg() {
		return msg;
	}
	public void setMsg(List<Msg> msg) {
		this.msg = msg;
	}
	public String getTimes() {
		return times;
	}
	public void setTimes(String times) {
		this.times = times;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
}
