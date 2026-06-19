package com.example.employee;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Employee {
	@Id
	private int eid;
	private String ename;
	private String dept;
	private float salary;
	private String joiningDate;
	public Employee() {}
	public Employee(int eid,String ename,String dept,float salary,String joiningDate) {
		this.eid=eid;
		this.ename=ename;
		this.dept=dept;
		this.salary=salary;
		this.joiningDate=joiningDate;
	}
	
	public void setId(int eid) {
		this.eid=eid;
	}
	public void setName(String ename) {
		this.ename=ename;
	}
	public void setdept(String dept) {
		this.dept=dept;
	}
	public void setsalary(float salary) {
		this.salary=salary;
	}
	public void setjoiningDate(String joiningDate) {
		this.joiningDate=joiningDate;
	}
	public int getId() {
		return eid;
	}
	public String getName() {
		return ename;
	}
	public String getdept() {
		return dept;
	}
	public float getsalary() {
		return salary;
	}
	public String getjoiningDate() {
		return joiningDate;
	}
	
}
