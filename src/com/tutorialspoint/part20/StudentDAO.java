package com.tutorialspoint.part20;

import java.util.List;

import javax.sql.DataSource;

public interface StudentDAO {
	
	/** 
     * This is the method to be used to initialize
     * database resources ie. connection.
     */
	public void setDataSource(DataSource dataSource);
  
	/** 
     * This is the method to be used to list down
     * a record from the Student table corresponding
     * to a passed student id.
     */
	public Student getStudent(Integer id);
  
	/** 
     * This is the method to be used to list down
     * all the records from the Student table.
     */
	public List<Student> listStudents();
	
	/** 
     * This is the method to be used to create
     * a record in the Student table.
     */
	public void create(String name, Integer age);

}
