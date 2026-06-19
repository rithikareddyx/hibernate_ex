package com.example.studentdemo;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Student {
	@Id
	private int sid;
	private String sname;
	private String email;
	private String course;
	private int age;
	public Student() {}
	public Student(int sid,String sname,String email,String course,int age) {
		this.sid=sid;
		this.sname=sname;
		this.email=email;
		this.course=course;
		this.age=age;
	}
	
	public void setId(int sid) {
		this.sid=sid;
	}
	public void setName(String sname) {
		this.sname=sname;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public void setCourse(String course) {
		this.course=course;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public int getId() {
		return sid;
	}
	public String getName() {
		return sname;
	}
	public String getEmail() {
		return email;
	}
	public String getCourse() {
		return course;
	}
	public int getAge() {
		return age;
	}
	
}
