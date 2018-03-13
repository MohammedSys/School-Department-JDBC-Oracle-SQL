package com;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestProcedure {

/*	This method will take DbTransaction object & Department as input. This method would be using
	JDBC to add department to department table. Method will return 1 after successfully addition and
	-1 for any failure.*/
	public int addDepartment(DbTransaction db,Department dept) {
		
		try {
			System.out.println("INSERT INTO TBL_Department_1420100 VALUES (" + dept.getDeptId() + ", '" + dept.getDeptName() + "', '" + dept.getDeptOwner() + "')");
			db.getConnection().createStatement().execute("INSERT INTO TBL_Department_1420100 VALUES (" + dept.getDeptId() + ", '" + dept.getDeptName() + "', '" + dept.getDeptOwner() + "')");
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return 1;
		
	}
	
	/*This method will take DbTransaction object & Department as input. This method would be using
	JDBC to add student to student table . Method will return true after successfully addition and false
	for any failure.*/
	public int addStudent(DbTransaction db, Student student) {
		
		try {
			System.out.println("INSERT INTO TBL_Student_1420100 VALUES (" + student.getStudentId() + ", " + student.getDeptId() + ", '" + student.getStudentName() + "', '" + student.getStudentAddress() + "', '" + student.getStudentContact() + "')");
			db.getConnection().createStatement().execute("INSERT INTO TBL_Student_1420100 VALUES (" + student.getStudentId() + ", " + student.getDeptId() + ", '" + student.getStudentName() + "', '" + student.getStudentAddress() + "', '" + student.getStudentContact() + "')");
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return 1;
		
	}
	
	
	/*This method will take DbTransaction object & studentid as input. This method will return List of
	StudentDepartment Object for a particular student, identified by the input parameter studentId. */
	public List<StudentDepartment> displayStudentAndDepartment(DbTransaction db,int studentId){
		String  selectTableSQL = "SELECT student_name, student_contact, dept_name, dept_owner FROM TBL_Student_1420100 JOIN TBL_Department_1420100 ON TBL_Student_1420100.dept_id = TBL_Department_1420100.dept_id WHERE student_id = " + studentId;
		ResultSet rs;
		List<StudentDepartment> studentDepartments = null;
		try {
			System.out.println(selectTableSQL);
			rs = db.getConnection().createStatement().executeQuery(selectTableSQL);
			studentDepartments = new ArrayList<StudentDepartment>();
			StudentDepartment sd = new StudentDepartment();
			while (rs.next()) {
				sd.setStudentName(rs.getString("STUDENT_NAME"));
				sd.setStudentContact(rs.getString("STUDENT_CONTACT"));
				sd.setDeptName(rs.getString("DEPT_NAME"));
				sd.setDeptOwner(rs.getString("DEPT_OWNER"));
			    studentDepartments.add(sd);
			    System.out.println(rs.getString("STUDENT_NAME") + ", " + rs.getString("STUDENT_CONTACT") + ", " + rs.getString("DEPT_NAME") + ", " + rs.getString("DEPT_OWNER"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return studentDepartments;
		
	}
	
	
	/*This method will take DbTransaction object & Department as input. This method will display
	student count with each Department name.*/
	public void displayCountofStudentByDepartment(DbTransaction db){
		String  selectTableSQL = "SELECT TBL_Student_1420100.dept_id, COUNT(student_id) as CS FROM TBL_Student_1420100 JOIN TBL_Department_1420100 ON TBL_Student_1420100.dept_id = TBL_Department_1420100.dept_id GROUP BY TBL_Student_1420100.dept_id ORDER BY TBL_Student_1420100.dept_id";
		System.out.println(selectTableSQL);
		ResultSet rs;
		try {
			rs = db.getConnection().createStatement().executeQuery(selectTableSQL);
			while (rs.next()) {
				System.out.println(rs.getString("DEPT_ID") + " -> " + rs.getString("CS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
}
