package com.zhongzhi.service;

import java.util.List;

import com.zhongzhi.mapper.StudentMapper;

public class StudentService {
	StudentMapper studentMapper;

	public StudentMapper getStudentMapper() {
		return studentMapper;
	}

	public void setStudentMapper(StudentMapper studentMapper) {
		this.studentMapper = studentMapper;
	}

	public List<Student> getAllStudent(){

		List<Student> list = studentMapper.selectAll();
		try {
			int i = 100;
			int a = i / 0;
		} catch (Exception e) {
			// TODO: handle exception
			//throw new Exception();
		}
		// System.out.println(list);
		
		System.out.println("getAllStudent");
		return list;
	}

	public void demo1() {
		System.out.println("demo1");
	}

	public void demo2() {
		System.out.println("demo2");
	}
}
