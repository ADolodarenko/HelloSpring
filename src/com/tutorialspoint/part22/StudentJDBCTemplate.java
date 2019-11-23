package com.tutorialspoint.part22;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentJDBCTemplate implements StudentDAO {
	
	private JdbcTemplate jdbcTemplate;

	@Override
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);		
	}

	@Override
	public void create(String name, Integer age, Integer marks, Integer year) {
		
		try {
			
			String sqlInsertStudent = "insert into student (name, age) values (?, ?)";
			jdbcTemplate.update( sqlInsertStudent, name, age);

			String sqlId = "select max(id) from student";
			int sid = jdbcTemplate.queryForInt(sqlId);

			String sqlInsertMarks = "insert into marks (sid, marks, year) values (?, ?, ?)";
			jdbcTemplate.update(sqlInsertMarks, sid, marks, year);
			
			System.out.println("Created student #" + sid + " with marks");
        
            //throw new RuntimeException("simulate Error condition") ;
            
		} catch (DataAccessException e) {
			
			System.out.println("Error in creating record, rolling back");
	        throw e;
	         
		}
		
	}

	@Override
	public List<StudentMarks> listStudentMarks() {
		
		String sql = "select * from student, marks where student.id = marks.sid";
	    List <StudentMarks> studentMarks = jdbcTemplate.query(sql, new StudentMarksMapper());
	      
	    return studentMarks;
	    
	}

}
