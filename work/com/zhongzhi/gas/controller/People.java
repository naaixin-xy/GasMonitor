package com.zhongzhi.gas.controller;

public class People {
	int id;
	int age;
	String name;
	String sex;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "People [id=" + id + ", age=" + age + ", name=" + name + ", sex=" + sex + "]";
	}
	public People() {
		super();
		// TODO Auto-generated constructor stub
	}
	public People(int id, int age, String name) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
	}
}
