package com.tutorialspoint.part21;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class StudentJDBCTemplate implements StudentDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private PlatformTransactionManager transactionManager;
	
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);		
	}

	@Override
	public void create(String name, Integer age, Integer marks, Integer year) {
		
		TransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(definition);
		
		try {
			
			String sqlInsertStudent = "insert into student (name, age) values (?, ?)";
			jdbcTemplate.update(sqlInsertStudent, name, age);
			
			String sqlId = "select max(id) from student";
			int id = jdbcTemplate.queryForInt(sqlId);
			
			String sqlInsertMarks = "insert into marks (sid, marks, year) values (?, ?, ?)";
			jdbcTemplate.update(sqlInsertMarks, id, marks, year);
			
			System.out.println("Created student #" + id + " with his marks");
			
			transactionManager.commit(status);			
			
		} catch (DataAccessException e) {
			
			System.out.println("Error creating a student with marks, rolling back");
		
			transactionManager.rollback(status);
			
			throw e;			
		}
		
	}

	@Override
	public List<StudentMarks> listStudentMarks() {
		String sql = "select * from student, marks where student.id = marks.sid";
		
		List<StudentMarks> studentsMarks = jdbcTemplate.query(sql, new StudentMarksMapper());
		
		return studentsMarks;
	}

}
