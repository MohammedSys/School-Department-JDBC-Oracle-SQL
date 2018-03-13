package com;

public class StudentDepartment {
	String studentName;
	String studentContact;
	String deptName;
	String deptOwner;
	
	StudentDepartment(){
		
	}
	
	StudentDepartment(String studentName, String studentContact, String deptName, String deptOwner){
		this.studentName = studentName;
		this.studentContact = studentContact;
		this.deptName = deptName;
		this.deptOwner = deptOwner;	
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentContact() {
		return studentContact;
	}

	public void setStudentContact(String studentContact) {
		this.studentContact = studentContact;
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
