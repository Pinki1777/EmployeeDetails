Drop table if exists Employee_Table;

create table Employee_Table(
	id int auto_increment primary key,
	dept varchar(50) not null,
	name varchar(50) not null,
	salary double
	
);

