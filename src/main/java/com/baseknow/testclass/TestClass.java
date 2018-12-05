package com.baseknow.testclass;

import java.io.Serializable;

public class TestClass implements Serializable{
	@Override
	public String toString() {
		return "TestClass [name=" + name + ", age=" + age + "]";
	}
	private static final long serialVersionUID = -6427276488672757050L;

	public TestClass(String name,String age){
		this.name=name;
		this.age=age;
	}
	private String name;
	private String age;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String isAutoWrized() {
		return "autoWrized..ok";
	}

}
