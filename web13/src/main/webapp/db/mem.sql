drop table mem;

select * from mem;

select * from mem where id = 'user1';

create table mem (
	id varchar2(20) primary key,
	pwd varchar2(20) not null,
	name varchar2(20) not null,
	lev char(1) not null,
	gender char(1) not null,
	phone varchar2(30) not null
);

INSERT INTO mem VALUES ('user1', '1234', 'John Doe', 'A', 'M', '123-456-7890');
INSERT INTO mem VALUES ('user2', '1234', 'Jane Smith', 'B', 'F', '987-654-3210');
INSERT INTO mem VALUES ('user3', '1234', 'Sam Johnson', 'C', 'M', '555-555-5555');
