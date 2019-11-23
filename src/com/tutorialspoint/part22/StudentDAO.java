package com.tutorialspoint.part22;

import java.util.List;

import javax.sql.DataSource;

public interface StudentDAO {
	
	/**
	 * This is the method to be used to initialize
     * database resources i.e. connection.
	 */
	public void setDataSource(DataSource dataSource);
	
	/**
	 * This is the method to be used to create
     * a record in the Student and Marks tables.
	 */
	public void create(String name, Integer age, Integer marks, Integer year);
	
	/**
	 * This is the method to be used to list down
     * all the records from the Student and Marks tables.
	 */
	public List<StudentMarks> listStudentMarks();

}
