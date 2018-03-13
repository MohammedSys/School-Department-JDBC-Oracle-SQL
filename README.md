# School-Department-JDBC-Oracle-SQL
Students and Departments management using Oracle SQL Plus and JDBC

Create the **Department** table in the database with naming convention as TBL_Department_&lt;Your Employee Id&gt;

**TBL_Department_&lt;Your Employee Id&gt;**

| Column name | Data Type | Additional Information |
|----|----|----|
| dept_id | Number(4) | Primary key |
| dept_name | Varchar2(30) | unique |
| dept_owner | Varchar2(30) | unique |


Class outline for Department class is as follows :

![department](https://user-images.githubusercontent.com/1732922/37349433-6c4dfb1a-26fc-11e8-8b9a-08fcc0cfe7d5.jpg)

Create the **Student** table in the database with naming convention TBL_Student_&lt;Your Employee Id&gt;

**TBL_Student_&lt;Your Employee Id&gt;**

|Column name | Data Type | Additional Information|
|----|----|----|
| student_id | Number(4) | Primary key |
| dept_id | Number(4) | Foreign key references Department table |
| student_name | Varchar2(10) |
| student_address | Varchar2(20) |
| student_contact | Varchar2(10) |

Class outline for Student class is as follows :

![student](https://user-images.githubusercontent.com/1732922/37349995-baf34ba2-26fd-11e8-8198-028915250964.jpg)

Create Java classes as per below templates and instructions in package _com_:

### DbTransaction class:

This class has attributes – `url, tableName, tableName1, connection, user and password`.

The constructor will take parameters as below sequence:
`url, user, password, tableName, tableName1`

`getConnection` and `closeConnection` should be implemented as per code shared at the end of the document.

![dbtransaction](https://user-images.githubusercontent.com/1732922/37350232-4003220e-26fe-11e8-8fc1-c3809098b523.png)

### StudentDepartment Class:

This is a bean class and the outline for the same has been given below.

![studentdepartment](https://user-images.githubusercontent.com/1732922/37350297-7890426e-26fe-11e8-91cc-1109f7d1787f.jpg)

### TestProcedure Class:

This class has below 4 methods

![testprocedure](https://user-images.githubusercontent.com/1732922/37350357-9c8cd9c0-26fe-11e8-94a7-555d09646511.jpg)

For each of the method result which you are retrieving must be done using SQL queries logic. Also please make sure that Connections are closed in the finally block.

**1) int addDepartment(DbTransaction db,Department dept) :**

This method will take DbTransaction object & Department as input. This method would be using JDBC to add department to department table. Method will retun 1 after successfully addition and -1 for any failure.

**2) addStudent(DbTransaction db,Student student) :**

This method will take DbTransaction object & Department as input. This method would be using JDBC to add student to student table . Method will retun true after successfully addition and false for any failure.

**3) List&lt;StudentDepartment&gt; displayStudentAndDepartment(DbTransaction db,int studentId):**

This method will take DbTransaction object & stidentid as input. This method will return List of StudentDepartment Object for a particular student, identified by the input parameter studentId.

**4) void displayCountofStudentByDepartment(DbTransaction db):**

This method will take DbTransaction object & Department as input. This method will display student count with each Department name.


### main method:

Create the main method in the `Demo` Class

Create `DbTransaction` class object with all parameters and test above methods (passing `DbTransaction` object) from main method.


Also make the following methods in the Demo Class:-

a. Create method :-This method will take DbTransaction object.This method will create the table of the required emp id, do the insertion of some random data.

b. clean up method :-This method will take DbTransaction object.This method will delete the table through the clean up call.
Note: Call the cleanup() in the finally block of the main method.


**Code for `getConnection()` method:**

```
public Connection getConnection()
{
  try {
    closeConnection();
    Class.forName("oracle.jdbc.driver.OracleDriver");
    connection = DriverManager.getConnection(url,user,password); }
  catch (SQLException e) {
    e.printStackTrace();
  } catch (ClassNotFoundException e) {
    e.printStackTrace();
  }
}
```

**Code for `CloseConnection()`:**

```
public void closeConnection()
{
  try
  {
    if(connection != null && connection.isClosed() == false)
    connection.close();
    connection = null;
  }
  catch(SQLException e)
  {
    e.printStackTrace();
  }
}
```
