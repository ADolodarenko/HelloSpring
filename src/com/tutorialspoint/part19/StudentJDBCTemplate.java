package com.tutorialspoint.part19;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class StudentJDBCTemplate implements StudentDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);		
	}

	@Override
	public List<Student> listStudents() {
		String sql = "select * from student";
		
		List<Student> students = jdbcTemplateObject.query(sql, new StudentMapper());
		
		return students;
	}

	@Override
	public Student getStudent(Integer id) {
		String sql = "select * from student where id = ?";
		
		Student student = jdbcTemplateObject.queryForObject(sql, new Object[] {id}, new StudentMapper());
		
		return student;
	}

	@Override
	public void create(String name, Integer age) {
		String sql = "insert into student (name, age) values (?, ?)";
		
		jdbcTemplateObject.update(sql, name, age);
		
		System.out.println("Created student with Name = " + name + " and Age = " + age);		
	}

	@Override
	public void update(Integer id, Integer age) {
		String sql = "update student set age = ? where id = ?";
		
		jdbcTemplateObject.update(sql, new Object[] {age, id});
		
		System.out.println("Updated student Id = " + id + " with Age = " + age);
	}

	@Override
	public void delete(Integer id) {
		String sql = "delete from student where id = ?";
		
		jdbcTemplateObject.update(sql, new Object[] {id});
		
		System.out.println("Deleted student Id = " + id);
	}

}
