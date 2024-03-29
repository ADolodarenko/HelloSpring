package com.tutorialspoint.part20;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class StudentJDBCTemplate implements StudentDAO {
	private DataSource dataSource;
	private SimpleJdbcCall jdbcCall;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		
		this.jdbcCall = new SimpleJdbcCall(dataSource).withFunctionName("get_record");
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public Student getStudent(Integer id) {
		SqlParameterSource in = new MapSqlParameterSource().addValue("in_id", id);
		Map<String, Object> out = jdbcCall.execute(in);
		
		Student student = new Student();
		student.setId(id);
		student.setName((String) out.get("out_name"));
		student.setAge((Integer) out.get("out_age"));
		
		return student;
	}

	@Override
	public List<Student> listStudents() {
		String sql = "select * from student";
		List <Student> students = jdbcTemplateObject.query(sql, new StudentMapper());
	    return students;
	}

	@Override
	public void create(String name, Integer age) {
		String sql = "insert into student (name, age) values (?, ?)";
	    jdbcTemplateObject.update(sql, name, age);
	    System.out.println("Created Record Name = " + name + " Age = " + age);
	}

}
