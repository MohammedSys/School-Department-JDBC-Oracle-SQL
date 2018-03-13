package com;

import java.sql.SQLException;
import java.sql.Statement;

public class Demo {
	
	public static void main(String args[]){

		create();
		
		DbTransaction dbt = new DbTransaction("jdbc:oracle:thin:@localhost:1521:xe", "TBL_Department_1420100", "TBL_Student_1420100", "system", "system");
		Department dept = new Department(2, "iStar", "Radhika");
		TestProcedure tp = new TestProcedure();
		Student phani = new Student(2, 1, "Phani", "Vijayawada", "1234546");
		Student shobha = new Student(3, 2, "Shobha", "Vijayawada", "12345469");
		Student madhuri = new Student(4, 2, "Madhuri", "Vijayawada", "12345479");
		tp.addDepartment(dbt, dept) ;
		tp.addStudent(dbt, phani);
		tp.addStudent(dbt, shobha);
		tp.addStudent(dbt, madhuri);
		tp.displayStudentAndDepartment(dbt, 2);
		tp.displayCountofStudentByDepartment(dbt);
		
		cleanup();
	}

	
	public static void create(){
		DbTransaction dbt = new DbTransaction("jdbc:oracle:thin:@localhost:1521:xe", "TBL_Department_1420100", "TBL_Student_1420100", "system", "system");
		
		try {
			Statement s = dbt.getConnection().createStatement();
			s.execute("CREATE TABLE TBL_Department_1420100 (dept_id NUMBER(4) PRIMARY KEY, dept_name Varchar2(30) unique, dept_owner Varchar2(30) unique)");
			s.execute("CREATE TABLE TBL_Student_1420100 ( student_id NUMBER(4) PRIMARY KEY, dept_id NUMBER(4), student_name Varchar2(10), student_address Varchar2(10), student_contact Varchar2(10), FOREIGN KEY (dept_id) REFERENCES TBL_Department_1420100(dept_id))");
			s.execute("INSERT INTO TBL_Department_1420100 VALUES (1, 'TBU', 'Sathya')");
			s.execute("INSERT INTO TBL_Student_1420100 VALUES (1, 1, 'Chakri', 'Nizampet', '123456789')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void cleanup(){
		DbTransaction dbt = new DbTransaction("jdbc:oracle:thin:@localhost:1521:xe", "TBL_Department_1420100", "TBL_Student_1420100", "system", "system");
		try {
			Statement s = dbt.getConnection().createStatement();
			s.execute("DELETE TBL_Student_1420100");
			s.execute("DELETE TBL_Department_1420100");
			s.execute("DROP TABLE TBL_Student_1420100");
			s.execute("DROP TABLE TBL_Department_1420100");
			dbt.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}


