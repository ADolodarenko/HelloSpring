create function get_record(
	in in_id int,
	out out_name varchar(20),
	out out_age int) as
'
	select name, age
	from student
	where id = in_id;
'
language sql;