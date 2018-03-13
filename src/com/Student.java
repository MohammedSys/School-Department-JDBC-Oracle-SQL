package com;

public class Student {
	private int studentId;
	private int deptId;
	private String studentName;
	private String studentAddress;
	private String studentContact;
	
	public Student(){
		
	}
	
	public Student(int studentId, int deptId, String studentName, String studentAddress, String studentContact){
		this.studentId = studentId;
		this.deptId = deptId;
		this.studentName = studentName;
		this.studentAddress = studentAddress;
		this.studentContact = studentContact;
		
	}
	
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
	public String getStudentContact() {
		return studentContact;
	}
	public void setStudentContact(String studentContact) {
		this.studentContact = studentContact;
	}
	
	
}
