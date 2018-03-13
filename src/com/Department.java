package com;

public class Department {
	private int deptId;
	private String deptName;
	private String deptOwner;
	
	public Department(){
		
	}
	
	public Department(int department_id, String department_name, String department_owner){
		this.deptId = department_id;
		this.deptName = department_name;
		this.deptOwner = department_owner;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptOwner() {
		return deptOwner;
	}

	public void setDeptOwner(String deptOwner) {
		this.deptOwner = deptOwner;
	}
	
	
}
