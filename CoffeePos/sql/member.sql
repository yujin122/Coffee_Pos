create table member(
	name varchar2(20) not null,
	birth number(8) not null,
	gender varchar(10) not null,
	phone varchar2(20) primary key,
	mail varchar2(50)
);