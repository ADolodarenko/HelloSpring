package com.tutorialspoint.part21;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentMarksMapper implements RowMapper<StudentMarks> {

	@Override
	public StudentMarks mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		StudentMarks studentMarks = new StudentMarks();
		
		studentMarks.setId(resultSet.getInt("id"));
		studentMarks.setName(resultSet.getString("name"));
		studentMarks.setAge(resultSet.getInt("age"));
		studentMarks.setSid(resultSet.getInt("sid"));
		studentMarks.setMarks(resultSet.getInt("marks"));
		studentMarks.setYear(resultSet.getInt("year"));		
		
		return studentMarks;
	}

}
